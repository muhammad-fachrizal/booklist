package com.fachrizal.booklist.service;

import java.util.List;

import com.fachrizal.booklist.entity.Book;

public interface BookService {
    List<Book> getAllBooks();
    void saveBook(Book book);
    Book getBookById(long id);
    void deleteBookById(long id);
}
