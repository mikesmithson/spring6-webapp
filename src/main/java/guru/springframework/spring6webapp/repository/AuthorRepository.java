package guru.springframework.spring6webapp.repository;

import guru.springframework.spring6webapp.entity.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
