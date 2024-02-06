package guru.springframework.spring6webapp.controller;

import guru.springframework.spring6webapp.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class BookControllerThymeleaf {
    private BookService bookService;

    @RequestMapping("/books/html")
    public String findAll(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }
}
