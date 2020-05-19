package org.pensatocode.simplicity.sample.controller;

import org.pensatocode.simplicity.sample.domain.Book;
import org.pensatocode.simplicity.sample.repository.BookRepository;
import org.pensatocode.simplicity.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController extends AbstractController<Book, Long> {
    public BookController(@Autowired BookRepository bookRepository) {
        super(bookRepository);
    }
}