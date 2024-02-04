package guru.springframework.spring6webapp.controller;

import guru.springframework.spring6webapp.entity.Book;
import guru.springframework.spring6webapp.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    @GetMapping
    public Iterable<Book> allBooks() {
        return bookService.findAll();
    }

    @GetMapping("/book/{id}")
    public Book allBooks(@PathVariable Long id) {
        return bookService.findById(id);
    }

}
