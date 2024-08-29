package com.sparta.schedulemanager_extension.controller;

import com.sparta.schedulemanager_extension.dto.user.UserRequestDto;
import com.sparta.schedulemanager_extension.dto.user.UserResponseDto;
import com.sparta.schedulemanager_extension.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    /** 유저를 생성하는 메서드
     *
     * @param userRequestDto 유저 이름, 이메일이 담긴 객체
     * @return 생성된 유저의 정보가 담긴 객체
     */
    @PostMapping("/users")
    UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }

    /** 특정 Id를 갖고 있는 유저 정보를 조회하는 메서드
     *
     * @param userId 조회하고자 하는 유저 Id
     * @return 조회에 성공한 유저 정보
     */
    @GetMapping("/users/{userId}")
    UserResponseDto getUser(@PathVariable Integer userId) {
        return userService.getUser(userId);
    }

    /** 모든 유저 정보를 조회하는 메서드
     *
     * @return 모든 유저 정보가 담긴 객체
     */
    @GetMapping("/users")
    List<UserResponseDto> getAllUsers() {
        return userService.getAllUser();
    }

    /** 특정 Id의 유저를 삭제하는 메서드
     *
     * @param userId 삭제하고자 하는 유저 id
     * @return 삭제된 유저 id
     */
    @DeleteMapping("/users/{userId}")
    Integer deleteUser(@PathVariable Integer userId) {
        return userService.deleteUser(userId);
    }
}
