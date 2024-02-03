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
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new HashSet<>();
    @ManyToOne(targetEntity = Publisher.class)
    private Publisher publisher;
}
