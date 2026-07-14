package com.Energy.user_service.controller;

import com.Energy.user_service.dto.UserDto;
import com.Energy.user_service.entity.User;
import com.Energy.user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    ResponseEntity<UserDto> createUser(@RequestBody UserDto userdto){
        UserDto created = userService.createUser(userdto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        UserDto userDto = userService.getUserById(id);
        if(userDto == null){
            return new ResponseEntity<>(userDto, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/{id}")
    ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        try {
            userService.updateUser(id,userDto);
            return ResponseEntity.ok("user updated succesully");
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
