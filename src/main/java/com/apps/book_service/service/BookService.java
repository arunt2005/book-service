package com.apps.book_service.service;

import com.apps.book_service.dto.BookDTO;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    public BookDTO getBookById(int bookId) {
        return new BookDTO(1, "Java", "John Wick");
    }
}
