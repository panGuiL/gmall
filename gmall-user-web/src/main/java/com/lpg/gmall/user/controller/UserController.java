package com.lpg.gmall.user.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.lpg.gmall.bean.user.UmsMember;
import com.lpg.gmall.bean.user.UmsMemberReceiveAddress;
import com.lpg.gmall.service.user.ReceiveAddrService;
import com.lpg.gmall.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @auther l
 * @create 2020-05-22 11:56
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    UserService userService;
    @Reference
    ReceiveAddrService receiveAddrService;

    /**
     * 查询所有用户信息
     * @return 用户对象的列表
     */
    @GetMapping("/getAll")
    public List<UmsMember> getAllUser(){
        return userService.getAllUser();
    }

    /**
     * 根据id查询用户信息
     * @param id 用户id
     * @return 用户对象
     */
    @GetMapping("/getOneById/{id}")
    public UmsMember getOneById(@PathVariable String id){
        return userService.getOneById(id);
    }

    @PostMapping("/update")
    public String addUser(UmsMember um){
        System.out.println(um);
        String msgJson = userService.addUser(um);
        return msgJson;
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable String id, UmsMember um){
        um.setId(id);
        String msg = userService.update(um);
        return msg;
    }

    @DeleteMapping("/update/{id}")
    public String delete(@PathVariable String id){
        String msg = userService.delete(id);
        return msg;
    }


    /**
     * 根据用户id查询用户的收货地址
     * @param id 用户id
     * @return 收货地址对象的列表
     */
    @GetMapping("/getAddrById/{id}")
    public List<UmsMemberReceiveAddress> getAddrById(@PathVariable String id){
        return receiveAddrService.getAddrById(id);
    }

    @PostMapping("/updateAddr")
    public String addAddr(UmsMemberReceiveAddress umra){
        String msg = receiveAddrService.addAddr(umra);
        return msg;
    }

    @PutMapping("/updateAddr/{id}")
    public String updateAddr(@PathVariable String id, UmsMemberReceiveAddress umra){
        String msg = receiveAddrService.updateAddr(id, umra);
        return msg;
    }

    @DeleteMapping("/updateAddr/{id}")
    public String deleteAddr(@PathVariable String id){
        String msg = receiveAddrService.deleteAddr(id);
        return msg;
    }


}
