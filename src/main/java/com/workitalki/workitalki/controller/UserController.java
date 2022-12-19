package com.workitalki.workitalki.controller;

import com.workitalki.workitalki.config.JwtTokenProvider;
import com.workitalki.workitalki.dto.UserInfoDto;
import com.workitalki.workitalki.entity.User;
import com.workitalki.workitalki.repository.UserRepository;
import com.workitalki.workitalki.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final UserService userService;




    @PostMapping("/join")
    public ResponseEntity join(@RequestBody UserInfoDto userInfoDto){
        return userService.joinUser(userInfoDto);

    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody UserInfoDto userInfoDto) {
        
        User member = userRepository.findByEmail(userInfoDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));

        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
    }
}