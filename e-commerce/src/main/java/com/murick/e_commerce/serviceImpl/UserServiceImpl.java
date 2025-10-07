package com.murick.e_commerce.serviceImpl;

import com.murick.e_commerce.dto.UserDto;
import com.murick.e_commerce.entity.User;
import com.murick.e_commerce.helper.Helper;
import com.murick.e_commerce.payload.PageableResponse;
import com.murick.e_commerce.repository.UserRepository;
import com.murick.e_commerce.service.UserService;
import com.murick.e_commerce.transformer.UserTransformer;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

//interface --> class= implements
//interface --> interface = extends
//abstractclass  --> class = extends

//    Entity       Dto

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserTransformer userTransformer;

    @Override
    public UserDto createUser(UserDto userDto) {// request

        User user = userTransformer.toEntity(userDto);
        User save = userRepository.save(user);
        UserDto userDto1 = userTransformer.toDto(save);
        return userDto1;
    }

    @Override
    public PageableResponse<UserDto> getAll(int pageNumber, int pageSize, String sortedBy, String sortedDir) {
        Sort sort = (sortedDir.equalsIgnoreCase("des")) ? (Sort.by(sortedBy).descending()) : (Sort.by(sortedBy)).ascending();
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);
        Page<User> page = userRepository.findAll(pageRequest);

        return Helper.getPageableResponse(page,new UserTransformer());
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
       userRepository.findById(id).orElseThrow(()-> new RuntimeException("User Not Found"));

        return null;
    }


}
