package stc21.project.reducto.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
@RequiredArgsConstructor
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_users_sequence")
    @SequenceGenerator(
            name = "pk_users_sequence",
            sequenceName = "users_id_seq",
            initialValue = 1000,
            allocationSize = 1)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "first_name", nullable = true)
    private String firstName;

    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true, unique = true)
    private String email;

    @Column(nullable = true, unique = true)
    private String phoneNumber;
}
