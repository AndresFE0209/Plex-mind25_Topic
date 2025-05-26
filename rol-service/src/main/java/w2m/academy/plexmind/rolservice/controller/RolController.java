package w2m.academy.plexmind.rolservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RolController {

    @GetMapping("/roles")
    public String getRoles() {
        return "List of roles";
    }
}
