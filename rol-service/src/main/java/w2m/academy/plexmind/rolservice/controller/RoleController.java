package w2m.academy.plexmind.rolservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import w2m.academy.plexmind.rolservice.repository.RoleRepository;

@RestController
public class RoleController {

    private RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping("/roles")
    public String getRoles() {
        return roleRepository.findAll().toString();
    }
}
