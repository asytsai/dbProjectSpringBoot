package com.springcourse.dbProjectSpringBoot.bootstrap;

import com.springcourse.dbProjectSpringBoot.model.Book;
import com.springcourse.dbProjectSpringBoot.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {
    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        Book book1 = new Book("Domain Driven Design", "123", "RandomHouse");
        System.out.println("Id " + book1.getId());
        Book savedDDD = bookRepository.save(book1);

        System.out.println("Id " + savedDDD.getId());

        Book book2 = new Book("Spring", "223", "Oreiley");
        Book savedSpring = bookRepository.save(book2);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Id: " + book.getId());
            System.out.println("Title: " + book.getTitle());
        });

    }
}
