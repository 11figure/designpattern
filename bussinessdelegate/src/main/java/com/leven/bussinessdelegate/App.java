package com.leven.bussinessdelegate;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:24 2018/8/16
 * @Modified By:
 */
public class App {

    public static void main(String[] args) {
        BussinessDelegate bussinessDelegate = new BussinessDelegate();
        LookupService lookupService = new LookupService();
        lookupService.setEjbService(new EjbService());
        lookupService.setJmsService(new JmsService());

        bussinessDelegate.setLookupService(lookupService);
        bussinessDelegate.setServiceType(ServiceType.EJB);


        Client client = new Client(bussinessDelegate);
        client.doTask();

        bussinessDelegate.setServiceType(ServiceType.JMS);
        client.doTask();
    }
}
