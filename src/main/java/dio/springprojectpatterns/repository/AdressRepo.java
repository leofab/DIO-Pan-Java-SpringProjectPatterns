package dio.springprojectpatterns.repository;

import dio.springprojectpatterns.model.Adress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepo extends CrudRepository<Adress, String > {
}
