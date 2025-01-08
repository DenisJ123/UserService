package ie.atu.userservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserStorage userStorage;

    public UserController(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestParam String name,
                                             @RequestParam String email) {
        User newUser = userStorage.addUser(name, email);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userStorage.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
}
