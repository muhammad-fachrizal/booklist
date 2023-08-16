package com.fachrizal.booklist.controller;

import com.fachrizal.booklist.entity.Book;
import com.fachrizal.booklist.service.BookService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/bookList")
    public String getAll(Model model){
        model.addAttribute("books", bookService.getAllBooks());
        return "book-list";
    }

    @GetMapping("/bookList/formAddBook")
    public String formAddBook(Model model){
        model.addAttribute(new Book());
        return "form-add-book";
    }

    @PostMapping({"/bookList/formAddBook", "/bookList/formUpdateBook/{id}"})
    public String saveBook(@ModelAttribute("book") @Valid Book book, Errors errors, Model model, @RequestParam("submitButton") String submitButtonValue){
        if(errors.hasErrors()) { 
            model.addAttribute("book", book);
            return (submitButtonValue.equals("Add")) ? "form-add-book" : "form-update-book";
        }
        bookService.saveBook(book);
        return "redirect:/bookList";
    }

    @GetMapping("/bookList/formUpdateBook/{id}")
    public String formUpdateBook(@PathVariable(value = "id") long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "form-update-book";
    }

    @GetMapping("/bookList/deleteBook/{id}")
    public String deleteBook(@PathVariable(value = "id") long id) {
        this.bookService.deleteBookById(id);
        return "redirect:/bookList";
    }

}
