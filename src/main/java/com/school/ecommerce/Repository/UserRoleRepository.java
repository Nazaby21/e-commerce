package com.school.ecommerce.Repository;

import com.school.ecommerce.Model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    boolean existsByRoleName(String roleName);
}
