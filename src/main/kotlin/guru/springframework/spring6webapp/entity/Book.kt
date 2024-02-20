package guru.springframework.spring6webapp.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator
import jakarta.persistence.*
import org.apache.commons.lang3.builder.EqualsBuilder
import org.apache.commons.lang3.builder.HashCodeBuilder

@JsonIdentityInfo(generator = PropertyGenerator::class, property = "id")
@Entity
class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    lateinit var title: String
    lateinit var isbn: String

    @JsonBackReference
    @ManyToMany(mappedBy = "books")
    var authors: MutableSet<Author> = mutableSetOf()

    @JsonBackReference
    @ManyToOne(targetEntity = Publisher::class)
    var publisher: Publisher = Publisher()

    override fun equals(o: Any?): Boolean {
        if (this === o) return true

        if (o == null || javaClass != o.javaClass) return false

        val book = o as Book

        return EqualsBuilder().append(id, book.id).isEquals
    }

    override fun hashCode(): Int {
        return HashCodeBuilder(17, 37).append(id).toHashCode()
    }
}
