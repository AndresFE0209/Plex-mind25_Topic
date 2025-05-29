package w2m.academy.plexmind.rolservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "role")
@NoArgsConstructor
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "role_name", nullable = false, length = 20)
    private String name;

    public Role(String name) {
        this.name = name;
    }

    // toString (opcional)
    @Override
    public String toString() {
        return "Role{id=" + id + ", name='" + name + "'}";
    }
}
