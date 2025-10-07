package com.murick.e_commerce.transformer;

import com.murick.e_commerce.dto.UserDto;
import com.murick.e_commerce.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserTransformer implements Transformer<User, UserDto>{
   public User toEntity(UserDto userDto){
        User userEntity = new User();
        userEntity.setUserId(userDto.getUserId());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setPhone(userDto.getPhone());
        return  userEntity;
    }

    @Override
    public User toUpdate(User entity, UserDto dto) {
        return null;
    }

    public UserDto toDto(User userEntity) {

       UserDto userDto = new UserDto();
        userDto.setUserId(userEntity.getUserId());
        userDto.setEmail(userEntity.getEmail());
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setPhone(userEntity.getPhone());
        return userDto;
    }

    public List<UserDto> toDtoList(List<User> users){
        List<UserDto> userDtos = users.stream().map(this::toDto).collect(Collectors.toList());
        return userDtos;
    }

}