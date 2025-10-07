package com.murick.e_commerce.controller;

import com.murick.e_commerce.dto.UserDto;
import com.murick.e_commerce.payload.PageableResponse;
import com.murick.e_commerce.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto user = userService.createUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/allUser")
    public ResponseEntity<PageableResponse<UserDto>> getAll(
            @RequestParam(value = "sortedBy", defaultValue = "firstName", required = false) String sortedBy,
            @RequestParam(value = "sortedDir", defaultValue = "asc", required = false) String sortedDir,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo
    ){
        PageableResponse<UserDto> userData = userService.getAll(pageNo, pageSize, sortedBy, sortedDir);
        return  new ResponseEntity<>(userData,HttpStatus.OK);

    }








}
