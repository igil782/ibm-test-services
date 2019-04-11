package co.com.ibm.test.data.repo;

import co.com.ibm.test.data.entity.CardEntity;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<CardEntity, Long> {
}
