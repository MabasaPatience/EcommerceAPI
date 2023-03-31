package ecommerceapi.com.ecommerceapi.Repository;

import ecommerceapi.com.ecommerceapi.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query("SELECT r FROM Role r where r.name= :name")
    public Role  findRoleByName(String name);
}
