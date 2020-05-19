package org.pensatocode.simplicity.sample.repository;

import org.pensatocode.simplicity.jdbc.JdbcRepository;
import org.pensatocode.simplicity.sample.domain.Book;

public interface BookRepository extends JdbcRepository<Book, Long> {
}
