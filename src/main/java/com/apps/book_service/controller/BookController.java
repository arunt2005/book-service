package com.apps.book_service.controller;

import com.apps.book_service.dto.BookDTO;
import com.apps.book_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public ResponseEntity<?> welcome() {
        return new ResponseEntity<String>("hello world..have a nice day.", HttpStatus.OK);
    }

    @GetMapping("/greet")
    public ResponseEntity<?> greetings() {
        return new ResponseEntity<String>("greetings message.", HttpStatus.OK);
    }


    @GetMapping("/book/{bookId}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("bookId") int bookId) {
        return new ResponseEntity<BookDTO>(bookService.getBookById(bookId), HttpStatus.OK);
    }

}
