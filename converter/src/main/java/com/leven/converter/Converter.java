package com.leven.converter;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:04 2018/8/14
 * @Modified By:
 */
public class Converter<T, U>{

    private final Function<T, U> fromDto;

    private final Function<U, T> fromEntity;

    public Converter(Function<T, U> fromDto, Function<U, T> fromEntity) {
        this.fromDto = fromDto;
        this.fromEntity = fromEntity;
    }


    public U convertFromDto(T dto) {
        U u = fromDto.apply(dto);
        return u;
    }

    public T convertFromEntity(U u) {
        T dto = fromEntity.apply(u);
        return dto;
    }

    public List<U> converFromDtos(List<T> list) {
        return list.stream().map(this::convertFromDto).collect(Collectors.toList());
    }

    public List<T> convertFromEntity(List<U> list) {
        return list.stream().map(this::convertFromEntity).collect(Collectors.toList());
    }

}
