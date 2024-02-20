package guru.springframework.spring6webapp.bootstrap

import guru.springframework.spring6webapp.entity.Author
import guru.springframework.spring6webapp.entity.Book
import guru.springframework.spring6webapp.entity.Publisher
import guru.springframework.spring6webapp.repository.AuthorRepository
import guru.springframework.spring6webapp.repository.BookRepository
import guru.springframework.spring6webapp.repository.PublisherRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.util.function.Consumer

@Component
class BootstrapRunner(
    private val authorRepository: AuthorRepository,
    private val bookRepository: BookRepository,
    private val publisherRepository: PublisherRepository
) : CommandLineRunner {
    @Throws(Exception::class)
    override fun run(vararg args: String) {
        val manning = createPublisher()

        val eric = createAuthor("Eric", "Evans")
        val rod = createAuthor("Rod", "Johnson")

        val ddd = createBook("Domain Driven Design", "123456", manning)
        val noEJB = createBook("J2EE Development without EJB", "54757585", manning)

        eric.books.add(ddd)
        rod.books.add(noEJB)
        ddd.authors.add(eric)
        noEJB.authors.add(rod)

        authorRepository.save(eric)
        authorRepository.save(rod)
        bookRepository.save(ddd)
        bookRepository.save(noEJB)

        bookRepository.findAll().forEach(Consumer { book: Book -> println(book.title) })


        println("In Bootstrap")
        println("Author Count: " + authorRepository.count())
        println("Book Count: " + bookRepository.count())
        println("Publisher Count: " + publisherRepository.count())
    }

    private fun createBook(title: String, isbn: String, publisher: Publisher): Book {
        val book = Book()
        book.title = title
        book.isbn = isbn
        book.publisher = publisher
        return bookRepository.save(book)
    }

    private fun createAuthor(firstName: String, lastName: String): Author {
        val author = Author()
        author.firstName = firstName
        author.lastName = lastName
        return authorRepository.save(author)
    }

    private fun createPublisher(): Publisher {
        val manning = Publisher()
        manning.publisherName = "Manning Publications"
        manning.address = "20 Baldwin Road"
        manning.city = "Shelter Island"
        manning.state = "New York"
        manning.zip = "11964"
        return publisherRepository.save(manning)
    }
}
