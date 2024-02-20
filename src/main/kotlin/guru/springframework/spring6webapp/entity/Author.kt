package guru.springframework.spring6webapp.entity

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator
import jakarta.persistence.*
import org.apache.commons.lang3.builder.EqualsBuilder
import org.apache.commons.lang3.builder.HashCodeBuilder

@JsonIdentityInfo(generator = PropertyGenerator::class, property = "id")
@Entity
class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    lateinit var firstName: String
    lateinit var lastName: String

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
        name = "book_author",
        joinColumns = [JoinColumn(name = "author_id")],
        inverseJoinColumns = [JoinColumn(name = "book_id")]
    )
    var books: MutableSet<Book> = mutableSetOf()
    override fun equals(o: Any?): Boolean {
        if (this === o) return true

        if (o == null || javaClass != o.javaClass) return false

        val author = o as Author

        return EqualsBuilder().append(id, author.id).isEquals
    }

    override fun hashCode(): Int {
        return HashCodeBuilder(17, 37).append(id).toHashCode()
    }
}
