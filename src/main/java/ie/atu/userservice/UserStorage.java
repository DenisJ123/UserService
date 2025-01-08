package ie.atu.userservice;

import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class UserStorage {
    private final Map<Long, User> users = new HashMap<>();
    private Long nextId = 1L;

    public User addUser(String name, String email) {
        User user = new User(nextId, name, email);
        users.put(nextId, user);
        nextId++;
        return user;
    }

    public User getUserById(Long id) {
        return users.get(id);
    }
}
