package com.leven;

    import javax.annotation.Resource;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 12:57 2018/5/19
 * @Modified By:
 */
@RestController
public class ApiGateway {

    @Resource
    private ImageClient imageClient;
    @Resource
    private PriceClient priceClient;


    @RequestMapping("/desktop")
    public DesktopProduct getProductDesktop() {
        DesktopProduct desktopProduct = new DesktopProduct();
        desktopProduct.setImagePath(imageClient.getImagePathClient());
        desktopProduct.setPrice(priceClient.getPrice());
        return desktopProduct;
    }

    @RequestMapping("/mobile")
    public MobilProduct getProductMobile() {
        MobilProduct mobilProduct = new MobilProduct();
        mobilProduct.setPrice(priceClient.getPrice());
        return mobilProduct;
    }
}
