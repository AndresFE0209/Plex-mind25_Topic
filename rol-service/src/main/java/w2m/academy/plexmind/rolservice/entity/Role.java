package w2m.academy.plexmind.rolservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "role_name", nullable = false, length = 20)
    private String name;

    // Constructores
    public Role() {}

    public Role(String name) {
        this.name = name;
    }

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString (opcional)
    @Override
    public String toString() {
        return "Role{id=" + id + ", name='" + name + "'}";
    }
}
