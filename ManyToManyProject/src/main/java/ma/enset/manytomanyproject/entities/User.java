package ma.enset.manytomanyproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity @Data @AllArgsConstructor @NoArgsConstructor @Table(name = "users")
public class User {
    @Id
    private String userid;
    @Column(unique = true)
    private String username;
    private String password;
    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
    private List<Role> roles;

}
