package ecommerceapi.com.ecommerceapi.Service.ServiceInterface;

import ecommerceapi.com.ecommerceapi.Entity.Role;

import java.util.List;

public interface RoleService {
    Role getRoleByName(String name);

    public Role saveRole(Role role);
    List<Role> getAllRoles();
}
