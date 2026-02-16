package com.shailesh.logbook.entity;
import com.shailesh.logbook.entity.Role;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "users",
uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = "employeeId")
})

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique=true)
    private Long employeeId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)

    private Role role;

}
