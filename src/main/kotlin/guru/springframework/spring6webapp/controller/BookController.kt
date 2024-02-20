package guru.springframework.spring6webapp.controller

import guru.springframework.spring6webapp.entity.Book
import guru.springframework.spring6webapp.service.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookController(private val bookService: BookService) {
    @GetMapping
    fun allBooks(): Iterable<Book> = bookService.findAll()

    @GetMapping("/book/{id}")
    fun fetchABookBy(@PathVariable id: Long?): Book = bookService.findById(id!!)
}
