package com.apps.book_service.service;

import com.apps.book_service.dto.BookDTO;
import com.apps.book_service.entity.Book;
import com.apps.book_service.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Create
    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = mapToEntity(bookDTO);
        Book saved = bookRepository.save(book);
        return mapToDTO(saved);
    }

    // Read All
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Read by ID
    public BookDTO getBookById(Long id) {
        return bookRepository.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    // Update
    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(bookDTO.getTitle());
            book.setAuthor(bookDTO.getAuthor());
            book.setIsbn(bookDTO.getIsbn());
            return mapToDTO(bookRepository.save(book));
        }
        return null;
    }

    // Delete
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // --- DTO Mapper Methods ---

    private BookDTO mapToDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setIsbn(book.getIsbn());
        return dto;
    }

    private Book mapToEntity(BookDTO dto) {
        Book book = new Book();
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
        return book;
    }
}
