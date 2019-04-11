package co.com.ibm.test.data.repo;

import co.com.ibm.test.data.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
}
