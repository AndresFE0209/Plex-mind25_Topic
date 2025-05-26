package w2m.academy.plexmind.rolservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import w2m.academy.plexmind.rolservice.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    // Puedes agregar métodos personalizados si lo necesitas, por ejemplo:
    Role findByName(String name);
}
