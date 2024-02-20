package guru.springframework.spring6webapp.service

import guru.springframework.spring6webapp.entity.Author
import guru.springframework.spring6webapp.repository.AuthorRepository
import org.springframework.stereotype.Service


@Service
class AuthorService(private val authorRepository: AuthorRepository) {

    fun findAll(): Iterable<Author> = authorRepository.findAll()

    fun findById(id: Long): Author = authorRepository.findById(id).orElseGet { Author() }
}