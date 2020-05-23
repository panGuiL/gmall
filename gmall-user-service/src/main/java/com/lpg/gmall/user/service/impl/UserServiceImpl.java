package com.lpg.gmall.user.service.impl;



import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.lpg.gmall.bean.user.UmsMember;
import com.lpg.gmall.mapper.user.UserMapper;
import com.lpg.gmall.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @auther l
 * @create 2020-05-22 11:58
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 查询所有的用户信息
     * @return UmsMember的列表
     */
    @Override
    public List<UmsMember> getAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public UmsMember getOneById(String id) {
        UmsMember umsMember = new UmsMember();
        umsMember.setId(id);
        return userMapper.selectOne(umsMember);
    }

    @Override
    public String addUser(UmsMember um) {
        Map<String, Object> map = new HashMap<>();
        um.setCreateTime(new Date());
        int isInsert = userMapper.insert(um);
        if(isInsert > 0){
            map.put("msg", "注册成功");
            map.put("code", "success");
            map.put("status", "1");
        }else{
            map.put("msg", "注册失败");
            map.put("code", "fail");
            map.put("status", "0");
        }
        String s = JSON.toJSONString(map);
        return s;
    }

    @Override
    public String update(UmsMember um) {

        Map<String, Object> map = new HashMap<>();
//        userMapper.updateByExample()
        int isUpdate = userMapper.updateByPrimaryKey(um);
        if (isUpdate > 0){
            map.put("msg", "修改成功");
            map.put("code", "success");
            map.put("status", "1");
        }else{
            map.put("msg", "修改失败");
            map.put("code", "fail");
            map.put("status", "0");
        }
        String msg = JSON.toJSONString(map);
        return msg;
    }

    @Override
    public String delete(String id) {
        UmsMember um = new UmsMember();
        Map<String, Object> map = new HashMap<>();
        um.setId(id);
        um.setStatus(0);
        int isDelete = userMapper.updateByPrimaryKeySelective(um);
//        userMapper.deleteByPrimaryKey(id);
        if (isDelete > 0){
            map.put("msg", "注销成功");
            map.put("code", "success");
            map.put("status", "1");
        }else{
            map.put("msg", "注销失败");
            map.put("code", "fail");
            map.put("status", "0");
        }
        String msg = JSON.toJSONString(map);
        return msg;
    }


}
