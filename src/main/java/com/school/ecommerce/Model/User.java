package com.school.ecommerce.Model;

import com.school.ecommerce.Audit.BaseEntity;
import com.school.ecommerce.Enumeration.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username")
    private String username;
    private String email;
    private String password;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role roleId;
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
