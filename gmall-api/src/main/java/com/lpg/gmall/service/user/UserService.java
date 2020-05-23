package com.lpg.gmall.service.user;

import com.lpg.gmall.bean.user.UmsMember;

import java.util.List;

/**
 * @Description
 * @auther l
 * @create 2020-05-22 11:57
 */

public interface UserService {


    List<UmsMember> getAllUser();

    UmsMember getOneById(String id);

    String addUser(UmsMember um);

    String update(UmsMember um);

    String delete(String id);
}
