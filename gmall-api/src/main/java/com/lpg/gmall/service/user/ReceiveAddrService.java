package com.lpg.gmall.service.user;

import com.lpg.gmall.bean.user.UmsMemberReceiveAddress;

import java.util.List;

/**
 * @Description
 * @auther l
 * @create 2020-05-22 16:14
 */
public interface ReceiveAddrService {


    List<UmsMemberReceiveAddress> getAddrById(String id);

    String addAddr(UmsMemberReceiveAddress umra);

    String updateAddr(String id, UmsMemberReceiveAddress umra);

    String deleteAddr(String id);
}
