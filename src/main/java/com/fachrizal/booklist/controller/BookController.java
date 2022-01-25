package com.fachrizal.booklist.controller;

import com.fachrizal.booklist.model.Book;
import com.fachrizal.booklist.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public String getAll(Model model){
        model.addAttribute("books", bookService.getAllBooks());
        return "list";
    }

    @GetMapping("/formAddBook")
    public String formAddBook(){
        return "form-add-book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book")Book book){
        bookService.saveBook(book);
        return "redirect:/list";
    }

    @GetMapping("/formUpdateBook/{id}")
    public String formUpdateBook(@PathVariable(value = "id") long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "form-update-book";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(value = "id") long id) {
        this.bookService.deleteBookById(id);
        return "redirect:/list";
    }

}
