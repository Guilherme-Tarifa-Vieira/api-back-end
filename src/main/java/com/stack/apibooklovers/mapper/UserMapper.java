package com.stack.apibooklovers.mapper;

import com.stack.apibooklovers.domain.user.User;
import com.stack.apibooklovers.domain.user.UserResponseDTO;


public class UserMapper {

    public static UserResponseDTO UserMapperDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }


}