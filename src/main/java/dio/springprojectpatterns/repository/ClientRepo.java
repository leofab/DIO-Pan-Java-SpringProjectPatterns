package dio.springprojectpatterns.repository;

import dio.springprojectpatterns.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends CrudRepository<Client, Long> {
}
