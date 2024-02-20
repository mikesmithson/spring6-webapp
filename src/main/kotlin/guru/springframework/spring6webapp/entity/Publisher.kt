package guru.springframework.spring6webapp.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import org.apache.commons.lang3.builder.EqualsBuilder
import org.apache.commons.lang3.builder.HashCodeBuilder

@Entity
class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    lateinit var publisherName: String
    lateinit var address: String
    lateinit var city: String
    lateinit var state: String
    lateinit var zip: String

    @JsonManagedReference
    @OneToMany(mappedBy = "publisher")
    lateinit var books: Set<Book>

    override fun equals(o: Any?): Boolean {
        if (this === o) return true

        if (o == null || javaClass != o.javaClass) return false

        val publisher = o as Publisher

        return EqualsBuilder().append(id, publisher.id).isEquals
    }

    override fun hashCode(): Int {
        return HashCodeBuilder(17, 37).append(id).toHashCode()
    }
}
