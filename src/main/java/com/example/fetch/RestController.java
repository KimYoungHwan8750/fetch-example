package com.example.fetch;


import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileInputStream;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/data")
    public ResponseEntity<byte[]> getData(){
        ClassPathResource classPathResource = new ClassPathResource("static/asyncHtml.html");
        try(FileInputStream fileInputStream = new FileInputStream(classPathResource.getFile())) {
            byte[] html = fileInputStream.readAllBytes();
            fileInputStream.close();
            return new ResponseEntity<>(html, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/text")
    public ResponseEntity<String> getString(){
        return new ResponseEntity<>("텍스트 응답!",HttpStatus.OK);
    }
}
