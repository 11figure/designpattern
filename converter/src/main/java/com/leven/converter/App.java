package com.leven.converter;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:22 2018/8/14
 * @Modified By:
 */
public class App {

    public static void main(String[] args) {
        Converter<UserDto, User> userConverter = new UserConverter();

        UserDto dtoUser = new UserDto("John", "Doe", true, "whatever[at]wherever.com");
        User user = userConverter.convertFromDto(dtoUser);
        System.out.println("Entity converted from DTO:" + user);

        ArrayList<User> users = Lists.newArrayList(new User("Camile", "Tough", false, "124sad"),
            new User("Marti", "Luther", true, "42309fd"), new User("Kate", "Smith", true, "if0243"));
        System.out.println("Domain entities:");
        users.forEach(System.out::println);

        System.out.println("DTO entities converted from domain:");
        List<UserDto> dtoEntities = userConverter.convertFromEntity(users);
        dtoEntities.forEach(System.out::println);
    }
}
