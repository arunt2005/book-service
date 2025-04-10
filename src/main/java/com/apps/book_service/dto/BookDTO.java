package com.apps.book_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDTO {

    private int bookId;
    private String bookName;
    private String bookAuthor;
}
