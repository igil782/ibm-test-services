package co.com.ibm.test.data.repo;

import co.com.ibm.test.data.entity.CityEntity;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<CityEntity, Long> {
}
