package com.murick.e_commerce.service;

import com.murick.e_commerce.dto.UserDto;
import com.murick.e_commerce.payload.PageableResponse;

import java.util.List;

public interface UserService {
   UserDto createUser(UserDto userDto);

   PageableResponse<UserDto> getAll(int pageNumber, int pageSize, String sortedBy, String sortedDir);
   UserDto updateUser(Long id, UserDto userDto);


}
