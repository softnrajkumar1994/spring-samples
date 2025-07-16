package azure.cosmos;

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
