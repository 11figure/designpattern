package com.leven.bussinessdelegate;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:55 2018/8/15
 * @Modified By:
 */
public class LookupService {

    private EjbService ejbService;
    private JmsService jmsService;
    public BusinessService lookUpService(ServiceType serviceType) {
        if (serviceType.equals(ServiceType.EJB)) {
            return ejbService;
        } else {
            return jmsService;
        }
    }

    public void setEjbService(EjbService ejbService) {
        this.ejbService = ejbService;
    }

    public void setJmsService(JmsService jmsService) {
        this.jmsService = jmsService;
    }
}
