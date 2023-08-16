package com.fachrizal.booklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fachrizal.booklist.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
