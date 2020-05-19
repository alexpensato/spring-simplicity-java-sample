package org.pensatocode.simplicity.sample.repository.impl;

import org.pensatocode.simplicity.jdbc.AbstractJdbcRepository;
import org.pensatocode.simplicity.sample.domain.Book;
import org.pensatocode.simplicity.sample.repository.BookRepository;
import org.pensatocode.simplicity.sample.repository.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository(value = "bookRepository")
public class BookRepositoryImpl extends AbstractJdbcRepository<Book, Long> implements BookRepository {

    public BookRepositoryImpl(@Autowired JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, new BookMapper(), "book", Book.class, "id");
    }
}