package com.leven.converter;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:14 2018/8/14
 * @Modified By:
 */
public class UserConverter extends Converter<UserDto , User> {
    public UserConverter() {
        super(userDto -> new User(userDto.getFirstName(), userDto.getLastName(), userDto.isActive(),
                userDto.getEmail()),
            user -> new UserDto(user.getFirstName(), user.getLastName(), user.isActive(),
                user.getUserId()));
    }

}
