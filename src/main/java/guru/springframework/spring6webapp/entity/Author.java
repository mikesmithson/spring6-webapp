package guru.springframework.spring6webapp.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToMany
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name= "book_id"))
    private Set<Book> books = new HashSet<>();

}
