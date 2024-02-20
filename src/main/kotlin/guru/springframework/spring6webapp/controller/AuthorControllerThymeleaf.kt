package guru.springframework.spring6webapp.controller

import guru.springframework.spring6webapp.service.AuthorService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class AuthorControllerThymeleaf(private val authorService: AuthorService) {

    @RequestMapping("/authors/html")
    fun getAllAuthors(model: Model): String {
        model.addAttribute("authors", authorService.findAll())
        return "authors"
    }
}
