package com.springcourse.dbProjectSpringBoot;

import com.springcourse.dbProjectSpringBoot.model.Book;
import com.springcourse.dbProjectSpringBoot.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class SpringBootJPATestSplice {
    @Autowired
    BookRepository bookRepository;

    @Test
    void testJpaTestSplice() {
        long countBefore = bookRepository.count();
        bookRepository.save(new Book("My book", "3756", "Self"));
        long countAfter = bookRepository.count();
        assertThat(countBefore).isLessThan(countAfter);
    }
}
