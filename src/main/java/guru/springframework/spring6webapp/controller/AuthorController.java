package guru.springframework.spring6webapp.controller;

import guru.springframework.spring6webapp.entity.Author;
import guru.springframework.spring6webapp.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
@AllArgsConstructor
public class AuthorController {
    private AuthorService authorService;

    @GetMapping
    public Iterable<Author> getAllAuthors()  {
        return authorService.findAll();
    }

    @GetMapping("/authors/{id}")
    public Author getById(@PathVariable Long id) {
        return authorService.findById(id);
    }

}
