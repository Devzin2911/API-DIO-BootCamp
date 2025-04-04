package dio.my_first_web_api.controller;

import dio.my_first_web_api.model.Usuario;
import dio.my_first_web_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UserRepository repository;

    @GetMapping()
    private List<Usuario> getUsers() {
        return repository.findAll();
    }

    @GetMapping("/{username}")
    public Usuario getOne(@PathVariable("username") String username) {
        return repository.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }

    @PostMapping("/{id}")
    public void postUser(@RequestBody Usuario usuario) {
        repository.save(usuario);
    }
}
