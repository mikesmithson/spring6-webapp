package guru.springframework.spring6webapp.controller;

import guru.springframework.spring6webapp.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class AuthorControllerThymeleaf {
    private AuthorService authorService;

    @RequestMapping("/authors/html")
    public String getAllAuthors(Model model)  {
            model.addAttribute("authors", authorService.findAll());
            return "authors";
        }

}
