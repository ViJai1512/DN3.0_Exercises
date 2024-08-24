package com.bookstoreapi.controller;

import com.bookstoreapi.entity.Book;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bookstoreapi.exception.BookNotFoundException;
import com.bookstoreapi.dto.BookDTO;
import com.bookstoreapi.mapper.BookMapper;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();


    @GetMapping
    public  ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> bookDTOs = new ArrayList<>();
        for (Book book : books) {
            bookDTOs.add(BookMapper.INSTANCE.bookToBookDTO(book));
        }
        return ResponseEntity.ok(bookDTOs);
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.bookDTOToBook(bookDTO);
        books.add(book);
        return ResponseEntity.ok(BookMapper.INSTANCE.bookToBookDTO(book));
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book with ID " + id + " not found"));
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        books.add(book);

        // Create custom headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Custom-Header", "BookStoreAPI-Create");

        // Return ResponseEntity with the book, headers, and status 201 Created
        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(headers)
                .body(book);
    }


    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getId() == id) {
                books.set(i, updatedBook);
                return updatedBook;
            }
        }
        return null;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        books.removeIf(book -> book.getId() == id);

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Custom-Header", "BookStoreAPI-Delete");


        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .headers(headers)
                .build();
    }
}
