package com.example.JwtAuthentication.Transformer;

import com.example.JwtAuthentication.DTO.UserRequestDto;
import com.example.JwtAuthentication.Models.User;

public class UserRequestDtoToUser
{
    public static User userRequestdtoTouser(UserRequestDto userRequestDto)
    {
        return User.builder().uname(userRequestDto.getUname())
                .email(userRequestDto.getEmail())
                .password(userRequestDto.getPassword()).build();
    }
}
