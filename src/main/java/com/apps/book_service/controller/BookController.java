package com.apps.book_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping("/")
    public ResponseEntity<?> welcome() {
        return new ResponseEntity<String>("hello world..have a nice day.", HttpStatus.OK);
    }

    @GetMapping("/greet")
    public ResponseEntity<?> greetings() {
        return new ResponseEntity<String>("greetings message.", HttpStatus.OK);
    }

}
