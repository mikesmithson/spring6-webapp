package guru.springframework.spring6webapp.controller

import guru.springframework.spring6webapp.entity.Author
import guru.springframework.spring6webapp.service.AuthorService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/authors")
class AuthorController(private val authorService: AuthorService) {
    @GetMapping
    fun allAuthors(): Iterable<Author> = authorService.findAll()

    @GetMapping("/author/{id}")
    fun getById(@PathVariable id: Long): Author {
        return authorService.findById(id)
    }
}
