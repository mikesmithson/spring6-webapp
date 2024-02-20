package guru.springframework.spring6webapp.service

import guru.springframework.spring6webapp.entity.Book
import guru.springframework.spring6webapp.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository) {
    fun findAll(): Iterable<Book> = bookRepository.findAll()

    fun findById(id: Long): Book = bookRepository.findById(id).get()
}
