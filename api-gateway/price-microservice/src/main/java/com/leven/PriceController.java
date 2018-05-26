package com.leven;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 13:18 2018/5/19
 * @Modified By:
 */
@RestController
public class PriceController {
    @RequestMapping(value = "/price", method = RequestMethod.GET)
    public String getPrice() {
        return "100000";
    }
}
