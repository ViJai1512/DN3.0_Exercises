package com.bookstoreapi.assembler;

import com.bookstoreapi.controller.BookController;
import com.bookstoreapi.entity.Book;
import com.bookstoreapi.model.BookModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class BookModelAssembler extends RepresentationModelAssemblerSupport<Book, BookModel> {

    public BookModelAssembler() {
        super(BookController.class, BookModel.class);
    }

    @Override
    public BookModel toModel(Book book) {
        BookModel bookModel = instantiateModel(book);

        // Set book properties
        bookModel.setId(book.getId());
        bookModel.setTitle(book.getTitle());
        bookModel.setAuthor(book.getAuthor());
        bookModel.setPrice(book.getPrice());
        bookModel.setIsbn(book.getIsbn());

        // Add HATEOAS links
        bookModel.add(linkTo(methodOn(BookController.class).getBookById(book.getId())).withSelfRel());
        bookModel.add(linkTo(methodOn(BookController.class).getAllBooks()).withRel("books"));

        return bookModel;
    }
}
