package com.workitalki.workitalki.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class adminController {

    @GetMapping("/test")
    public ResponseEntity getTest(){
        return new ResponseEntity("성공", HttpStatus.OK);
    }
}
