package com.springcourse.dbProjectSpringBoot;

import com.springcourse.dbProjectSpringBoot.model.Book;
import com.springcourse.dbProjectSpringBoot.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpringBootJPATestSplice {
    @Autowired
    BookRepository bookRepository;

    @Test
    @Order(1)
    @Commit
    void testJpaTestSplice() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(0);
        bookRepository.save(new Book("My book", "3756", "Self"));
        long countAfter = bookRepository.count();
        assertThat(countBefore).isLessThan(countAfter);
    }

    @Test
    @Order(2)
    void testJpaSpliceTransaction() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(1);
    }
}
