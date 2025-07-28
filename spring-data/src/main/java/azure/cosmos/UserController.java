package azure.cosmos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/create")
    public String createUser() {
        userService.createUser();
        return "User created!";
    }

    @GetMapping("/find")
    public List<User> getUsers(@RequestParam String name) {
        return userService.getUsers(name);
    }
}
