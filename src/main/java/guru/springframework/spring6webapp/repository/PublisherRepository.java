package guru.springframework.spring6webapp.repository;

import guru.springframework.spring6webapp.entity.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
