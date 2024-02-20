package guru.springframework.spring6webapp.repository

import guru.springframework.spring6webapp.entity.Author
import org.springframework.data.repository.CrudRepository

interface AuthorRepository : CrudRepository<Author, Long>
