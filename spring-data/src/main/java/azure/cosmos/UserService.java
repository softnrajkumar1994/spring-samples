package azure.cosmos;

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
        userRepository.save(user);
    }

    public List<User> getUsers(String name) {
        return userRepository.findByName(name);
    }
}
