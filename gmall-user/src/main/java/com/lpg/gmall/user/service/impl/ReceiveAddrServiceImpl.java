package com.lpg.gmall.user.service.impl;

import com.alibaba.fastjson.JSON;

import com.lpg.gmall.bean.user.UmsMemberReceiveAddress;
import com.lpg.gmall.mapper.user.ReceiveAddrMapper;
import com.lpg.gmall.service.user.ReceiveAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @auther l
 * @create 2020-05-22 16:15
 */
@Service
public class ReceiveAddrServiceImpl implements ReceiveAddrService {

    @Autowired
    ReceiveAddrMapper receiveAddrMapper;

    /**
     * 按照用户Id去查找用户的收货地址
     * @param id 用户id
     * @return 收货地址列表
     */

    @Override
    public List<UmsMemberReceiveAddress> getAddrById(String id) {
        UmsMemberReceiveAddress umra = new UmsMemberReceiveAddress();
        umra.setMemberId(id);
        List<UmsMemberReceiveAddress> receiveAddresses = receiveAddrMapper.select(umra);
        return receiveAddresses;
    }

    @Override
    public String addAddr(UmsMemberReceiveAddress umra) {
        System.out.println(umra);
        int isInsert = receiveAddrMapper.insert(umra);
        Map<String, Object> map = new HashMap<>();
        if (isInsert > 0){
            map.put("msg", "添加地址成功");
            map.put("code", "success");
            map.put("status", "1");
        }else{
            map.put("msg", "添加地址失败");
            map.put("code", "fail");
            map.put("status", "0");
        }
        String msg = JSON.toJSONString(map);
        return msg;
    }

    @Override
    public String updateAddr(String id, UmsMemberReceiveAddress umra) {

        umra.setId(id);
        int isUpdate = receiveAddrMapper.updateByPrimaryKeySelective(umra);

        Map<String, Object> map = new HashMap<>();
        if (isUpdate > 0){
            map.put("msg", "更新地址成功");
            map.put("code", "success");
            map.put("status", "1");
        }else{
            map.put("msg", "更新地址失败");
            map.put("code", "fail");
            map.put("status", "0");
        }
        String msg = JSON.toJSONString(map);
        return msg;

    }

    @Override
    public String deleteAddr(String id) {
        int isDelete = receiveAddrMapper.deleteByPrimaryKey(id);
        Map<String, Object> map = new HashMap<>();
        if (isDelete > 0){
            map.put("msg", "删除地址成功");
            map.put("code", "success");
            map.put("status", "1");
        }else{
            map.put("msg", "删除地址失败");
            map.put("code", "fail");
            map.put("status", "0");
        }
        String msg = JSON.toJSONString(map);
        return msg;
    }
}
