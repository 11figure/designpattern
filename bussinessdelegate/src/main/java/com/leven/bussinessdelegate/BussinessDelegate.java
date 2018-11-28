package com.leven.bussinessdelegate;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:54 2018/8/15
 * @Modified By:
 */
public class BussinessDelegate {

    private BusinessService businessService;
    private LookupService lookupService;
    private ServiceType serviceType;

    public void setLookupService(LookupService lookupService) {
        this.lookupService = lookupService;
    }

    public void doTask() {
        businessService = lookupService.lookUpService(serviceType);
        businessService.doProcessing();
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
