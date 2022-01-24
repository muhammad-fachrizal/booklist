package com.fachrizal.booklist.controller;

import com.fachrizal.booklist.model.Book;
import com.fachrizal.booklist.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/list")
    public String getAll(Model model){
        List<Book> bookList = bookRepository.findAll();
        model.addAttribute("books", bookList);
        return "list";
    }

    @GetMapping("/formAddBook")
    public String formAddBook(){
        return "form-add-book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book")Book book){
        bookRepository.save(book);
        return "redirect:/list";
    }

    @GetMapping("/formUpdateBook/{id}")
    public String formUpdateBook(@PathVariable(value = "id") long id, Model model) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null){
            model.addAttribute("book", book);
        }
        return "form-update-book";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(value = "id") long id) {
        this.bookRepository.deleteById(id);
        return "redirect:/list";
    }

}
