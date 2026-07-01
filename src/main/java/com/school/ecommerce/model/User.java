package com.school.ecommerce.model;

import com.school.ecommerce.audit.BaseEntity;
import com.school.ecommerce.enumeration.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username")
    private String username;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Product> products;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "role_id")
//    private UserRole role;
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
