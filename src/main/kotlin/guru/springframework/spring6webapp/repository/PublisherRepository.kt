package guru.springframework.spring6webapp.repository

import guru.springframework.spring6webapp.entity.Publisher
import org.springframework.data.repository.CrudRepository

interface PublisherRepository : CrudRepository<Publisher, Long>
