package com.payu.payuServer.service;

import com.payu.payuServer.model.book;
import com.payu.payuServer.model.response;
import com.payu.payuServer.repository.bookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class bookService {

    @Autowired
    private bookRepository BookRepository;
    public List<book> getAllBooks() {
        return BookRepository.findAll();
    }

    public book addBook(book Book) {
        return BookRepository.save(Book);
    }

    public book updateBook(int id, book updatedBook) {
        Optional<book> bookToUpdateOptional = BookRepository.findById(id);
        if (bookToUpdateOptional.isPresent()) {
            book bookToUpdate = bookToUpdateOptional.get();
            bookToUpdate.setName(updatedBook.getName());
            bookToUpdate.setDate(updatedBook.getDate());
            bookToUpdate.setPrice(updatedBook.getPrice());
            bookToUpdate.setBookType(updatedBook.getBookType());
            return BookRepository.save(bookToUpdate);
        }
        return null;
    }

    public void deleteBook(int id) {
        BookRepository.deleteById(id);
    }
    }

