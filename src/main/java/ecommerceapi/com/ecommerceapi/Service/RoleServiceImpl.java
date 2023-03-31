package ecommerceapi.com.ecommerceapi.Service;

import ecommerceapi.com.ecommerceapi.Entity.Role;
import ecommerceapi.com.ecommerceapi.Repository.RoleRepository;
import ecommerceapi.com.ecommerceapi.Service.ServiceInterface.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

@Autowired
public RoleRepository roleRepository;
    @Override
    public Role getRoleByName(String name) {
        return roleRepository.findRoleByName(name);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
