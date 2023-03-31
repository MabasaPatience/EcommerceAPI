package ecommerceapi.com.ecommerceapi.RestAPI;

import ecommerceapi.com.ecommerceapi.DTO.RoleDTO;
import ecommerceapi.com.ecommerceapi.Entity.Role;
import ecommerceapi.com.ecommerceapi.RestAPI.AppAPI.RoleAPI;
import ecommerceapi.com.ecommerceapi.Service.ServiceInterface.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class RoleRestImpl  implements RoleAPI {
    @Autowired
    RoleService roleService;
    @Override
    public ResponseEntity<List<Role>> getAllRole() {
        List<Role> getAllRole= roleService.getAllRoles();
        return new ResponseEntity<>(getAllRole, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Role> getRoleByEmail(String role) {
        Role getAllRole= roleService.getRoleByName(role);
        return new ResponseEntity<>(getAllRole, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> saveRole(RoleDTO roleDto) {
        try {
            if (validateSignUp(roleDto)) {
                Role role = roleService.getRoleByName(roleDto.getName());
                if (Objects.isNull(role)) {
                    roleService.saveRole(getRoleFromMap(roleDto));
                    return new ResponseEntity<>("saved", HttpStatus.OK);
                }
                return new ResponseEntity<>("role already exist", HttpStatus.OK);
            }
            return new ResponseEntity<>("invalid Data", HttpStatus.OK);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>("Error", HttpStatus.OK);

    }

    private boolean validateSignUp(RoleDTO roleDto){

        if(!roleDto.getName().equals("")){
            return true;
        }
        return false;
    }

    private Role getRoleFromMap(RoleDTO roleDto){
        Role role=new Role();

        role.setName(roleDto.getName());

        return role;
    }

}
