package ecommerceapi.com.ecommerceapi.RestAPI.AppAPI;

import ecommerceapi.com.ecommerceapi.DTO.RoleDTO;
import ecommerceapi.com.ecommerceapi.Entity.Role;
import ecommerceapi.com.ecommerceapi.Service.ServiceInterface.RoleService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(path="/role")
public interface RoleAPI {


    @GetMapping("/get")
    public ResponseEntity<List<Role>> getAllRole();

    @GetMapping("/get/{role}")
    public ResponseEntity<Role> getRoleByEmail(@PathVariable("role") String role);


    @PostMapping("/save")
    public ResponseEntity<String> saveRole(@RequestBody RoleDTO roleDto);
}
