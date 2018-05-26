package com.leven.image;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 13:11 2018/5/19
 * @Modified By:
 */
@RestController
public class ImageController {

    @RequestMapping(value = "/image-path", method = RequestMethod.GET)
    public String getImagePath() {
        return "/product-image.png";
    }
}
