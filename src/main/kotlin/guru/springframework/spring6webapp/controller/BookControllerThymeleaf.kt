package guru.springframework.spring6webapp.controller

import guru.springframework.spring6webapp.service.BookService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class BookControllerThymeleaf(private val bookService: BookService) {
    @RequestMapping("/books/html")
    fun findAll(model: Model): String {
        model.addAttribute("books", bookService.findAll())
        return "books"
    }
}
