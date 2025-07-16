package azure.cosmos;


import com.azure.spring.data.cosmos.repository.CosmosRepository;

public interface UserRepository extends CosmosRepository<User, String> {
    List<User> findByName(String name);
}
