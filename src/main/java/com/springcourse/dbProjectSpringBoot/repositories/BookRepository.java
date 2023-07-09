package com.springcourse.dbProjectSpringBoot.repositories;

import com.springcourse.dbProjectSpringBoot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
