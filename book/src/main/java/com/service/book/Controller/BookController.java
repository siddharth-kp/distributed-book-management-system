package com.service.book.Controller;

import com.service.book.Entity.Book;
import com.service.book.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBook() {
        return ResponseEntity.ok(bookService.getBook());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBook(@PathVariable int id) {
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @GetMapping("/quantity/{id}")
    public ResponseEntity<Integer> getQuantity(@PathVariable int id) {
        return ResponseEntity.ok(bookService.getQuantity(id));
    }

    @GetMapping("setQuantity/{id}/{quantity}")
    public ResponseEntity<Object> setQuantity(@PathVariable int id, @PathVariable int quantity) {
        bookService.setQuantity(id,quantity);
        return ResponseEntity.ok(new Book());
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(book));
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteBook(@PathVariable int id) {
        return ResponseEntity.ok(bookService.deleteBook(id));
    }
}
