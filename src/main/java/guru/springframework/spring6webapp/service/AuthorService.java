package guru.springframework.spring6webapp.service;

import guru.springframework.spring6webapp.entity.Author;
import guru.springframework.spring6webapp.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorService {
    private AuthorRepository authorRepository;

    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findById(Long id) {
        return authorRepository.findById(id).orElseGet(Author::new);
    }

}
