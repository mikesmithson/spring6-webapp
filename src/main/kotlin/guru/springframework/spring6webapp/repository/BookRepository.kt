package guru.springframework.spring6webapp.repository

import guru.springframework.spring6webapp.entity.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book, Long>
