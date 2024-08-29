package com.sparta.schedulemanager_extension.service;

import com.sparta.schedulemanager_extension.dto.user.UserRequestDto;
import com.sparta.schedulemanager_extension.dto.user.UserResponseDto;
import com.sparta.schedulemanager_extension.entity.User;
import com.sparta.schedulemanager_extension.repository.UserRespository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    final UserRespository userRespository;

    public UserService(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    /** 유저를 생성하는 메서드
     *
     * @param userRequestDto 유저 이름, 이메일이 담긴 객체
     * @return 생성된 유저의 정보가 담긴 객체
     */
    @Transactional
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = new User(userRequestDto);
        userRespository.save(user);

        return new UserResponseDto(user);
    }

    /** 특정 Id를 갖고 있는 유저 정보를 조회하는 메서드
     *
     * @param userId 조회하고자 하는 유저 Id
     * @return 조회에 성공한 유저 정보 객체
     */
    @Transactional
    public UserResponseDto getUser(Integer userId) {
        User user = userRespository.findById(userId).orElseThrow(
                () -> new RuntimeException("User not found"));

        return new UserResponseDto(user);
    }

    /** 모든 유저 정보를 조회하는 메서드
     *
     * @return 모든 유저 정보가 담긴 객체
     */
    @Transactional
    public List<UserResponseDto> getAllUser() {
        return userRespository.findAll()
                .stream()
                .map(UserResponseDto::new)
                .toList();
    }

    /** 특정 Id의 유저를 삭제하는 메서드
     *
     * @param userId 삭제하고자 하는 유저 id
     * @return 삭제된 유저 id
     */
    @Transactional
    public Integer deleteUser(Integer userId) {
        userRespository.deleteById(userId);
        return userId;
    }
}
