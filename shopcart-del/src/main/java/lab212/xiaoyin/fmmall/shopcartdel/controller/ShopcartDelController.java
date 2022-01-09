package lab212.xiaoyin.fmmall.shopcartdel.controller;

import lab212.xiaoyin.fmmall.shopcartdel.service.ShopcartDelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-08 16:06
 */
@RestController
public class ShopcartDelController {

    @Autowired
    private ShopcartDelService shopcartDelService;

    @DeleteMapping("/shopcart/del")
    public int del(String cids) {
        return shopcartDelService.deleteShopcart(cids);
    }
}
