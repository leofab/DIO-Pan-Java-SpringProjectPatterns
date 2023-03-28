package dio.springprojectpatterns.repository;

import dio.springprojectpatterns.model.Adress;
import org.springframework.data.repository.CrudRepository;

public interface AdressRepo extends CrudRepository<Adress, String > {
}
