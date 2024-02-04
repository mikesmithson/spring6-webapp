package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.entity.Author;
import guru.springframework.spring6webapp.entity.Book;
import guru.springframework.spring6webapp.entity.Publisher;
import guru.springframework.spring6webapp.repository.AuthorRepository;
import guru.springframework.spring6webapp.repository.BookRepository;
import guru.springframework.spring6webapp.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BootstrapRunner implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {
        Publisher manning = createPublisher();

        Author eric = createAuthor("Eric", "Evans");
        Author rod = createAuthor("Rod", "Johnson");

        Book ddd = createBook("Domain Driven Design", "123456", manning);
        Book noEJB = createBook("J2EE Development without EJB", "54757585", manning);

        eric.getBooks().add(ddd);
        rod.getBooks().add(noEJB);
        ddd.getAuthors().add(eric);
        noEJB.getAuthors().add(rod);

        authorRepository.save(eric);
        authorRepository.save(rod);
        bookRepository.save(ddd);
        bookRepository.save(noEJB);

        bookRepository.findAll().forEach(book -> System.out.println(book.getTitle()));


        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

    }

    private Book createBook(String title, String isbn, Publisher publisher) {
        Book book = new Book();
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPublisher(publisher);
        return bookRepository.save(book);
    }

    private Author createAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        return authorRepository.save(author);
    }

    private Publisher createPublisher() {
        Publisher manning = new Publisher();
        manning.setPublisherName("Manning Publications");
        manning.setAddress("20 Baldwin Road");
        manning.setCity("Shelter Island");
        manning.setState("New York");
        manning.setZip("11964");
        return publisherRepository.save(manning);
    }
}
