package azure.cosmos;


import com.azure.spring.data.cosmos.repository.CosmosRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRepository extends CosmosRepository<User, String> {
    List<User> findByName(String name);
}
