package is.stanton.andy.interrogate;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RequestMapping("/user")
@Controller
public class InterrogateController {
    @Inject
    private UserRepository userRepository;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAllByOrderByNameAsc();
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody User getUser(@PathVariable Long id) {
        return userRepository.findOne(id);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody User updateUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping(value = "/id/{id}")
    public @ResponseBody void deleteUser(@PathVariable Long id) {
        userRepository.delete(id);
    }
}
