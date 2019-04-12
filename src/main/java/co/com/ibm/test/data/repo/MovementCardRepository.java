package co.com.ibm.test.data.repo;

import co.com.ibm.test.data.entity.MovementCardEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovementCardRepository extends CrudRepository<MovementCardEntity, Long> {

    List<MovementCardEntity> findByCardIdCard(Long idCard);

}
