package org.pensatocode.simplicity.sample.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.pensatocode.simplicity.sample.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BookRepositoryIntegrationTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testCreateAndFindOneBook() {
        // Create mock Book
        Book mockBook = new Book("MockBook", "MockCity");

        Assertions.assertEquals(0L, mockBook.getId());

        Book newBook = bookRepository.save(mockBook);

        Assertions.assertNotNull(newBook);
        Assertions.assertTrue(newBook.getId() > 0L);

        Book bookFound = bookRepository.findOne(newBook.getId());

        Assertions.assertNotNull(bookFound);
        Assertions.assertEquals(newBook.getId(), bookFound.getId());
        Assertions.assertEquals(newBook, bookFound);
        Assertions.assertNotSame(newBook, bookFound);

    }

}
