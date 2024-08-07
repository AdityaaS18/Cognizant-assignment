package com.library;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void doSomething() {
        System.out.println("BookRepository is doing something...");
    }
}
