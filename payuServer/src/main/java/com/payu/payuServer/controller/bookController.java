package com.payu.payuServer.controller;
import com.payu.payuServer.model.book;
import com.payu.payuServer.model.response;
import com.payu.payuServer.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class bookController {

    @Autowired
    private bookService BookService;

    @GetMapping
    public List<book> getAllBooks() {
        return BookService.getAllBooks();
    }

    @PostMapping
    public ResponseEntity<response> addBook(@RequestBody book Book) {
        BookService.addBook(Book);
        response response = new response("Book added successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<response> updateBook(@PathVariable int id, @RequestBody book Book) {
        book updatedBook = BookService.updateBook(id, Book);
        response response = new response("Book updated successfully");
        if (updatedBook != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<response> deleteBook(@PathVariable int id) {
        BookService.deleteBook(id);
        response response = new response("Book deleted successfully");
        return ResponseEntity.ok(response);
    }
}
