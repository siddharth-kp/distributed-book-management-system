package com.service.book.Service;

import com.service.book.Entity.Book;
import com.service.book.Repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getBook() {
        return bookRepository.findAll();
    }

    public Book getBook(int id) {
        return bookRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("book does not exist"));
    }

    public Book updateBook(Book book) {
        Book b = bookRepository.findById(book.getId()).orElseThrow(() ->
                new EntityNotFoundException("book does not exist"));
        b.setAuthor(book.getAuthor());
        b.setTitle(book.getTitle());
        b.setStock(book.getStock());
        b.setPrice(book.getPrice());
        return bookRepository.save(b);
    }

    public Boolean deleteBook(int id) {
        if(bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
