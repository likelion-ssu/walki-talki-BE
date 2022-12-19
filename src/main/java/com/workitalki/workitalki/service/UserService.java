package com.workitalki.workitalki.service;

import com.workitalki.workitalki.dto.UserInfoDto;
import com.workitalki.workitalki.entity.User;
import com.workitalki.workitalki.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity joinUser(UserInfoDto userInfoDto){
        User user = new User(userInfoDto);
        user.builder()
                        .roles(Collections.singletonList("ROLE_USER"))
                                .build();
        userRepository.save(user);
        return new ResponseEntity("회원가입 성공", HttpStatus.OK);
    }
}
