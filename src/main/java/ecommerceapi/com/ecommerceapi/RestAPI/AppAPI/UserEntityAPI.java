package ecommerceapi.com.ecommerceapi.RestAPI.AppAPI;

import ecommerceapi.com.ecommerceapi.DTO.LoginDTO;
import ecommerceapi.com.ecommerceapi.DTO.UserEntityDTO;
import ecommerceapi.com.ecommerceapi.Entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="/user")
public interface UserEntityAPI {

    @GetMapping("/get")
    public ResponseEntity<List<UserEntity>> findAllUser();

    @GetMapping("/get/{email}")
    public ResponseEntity<UserEntity> getUserByEmail(@PathVariable("email") String email);

    @PostMapping(path="/save")
    public ResponseEntity<String> signup(@RequestBody UserEntityDTO request);

    @PostMapping(path="/save")
    public ResponseEntity<String> login(@RequestBody LoginDTO request);

}
