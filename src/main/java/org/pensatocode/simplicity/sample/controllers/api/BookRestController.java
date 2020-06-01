package org.pensatocode.simplicity.sample.controllers.api;

import org.pensatocode.simplicity.sample.domain.Book;
import org.pensatocode.simplicity.sample.repository.BookRepository;

import org.pensatocode.simplicity.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookRestController extends AbstractController<Book, Long> {
    public BookRestController(@Autowired BookRepository bookRepository) {
        super(bookRepository);
    }
}