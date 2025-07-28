package azure.cosmos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("Raj");
        user.setAge(30);
       // userRepository.save(user);
    }

    public List<User> getUsers(String name) {
        return userRepository.findByName(name);
    }
}
