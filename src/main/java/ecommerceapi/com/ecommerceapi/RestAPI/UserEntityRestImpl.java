package ecommerceapi.com.ecommerceapi.RestAPI;

import ecommerceapi.com.ecommerceapi.DTO.UserEntityDTO;
import ecommerceapi.com.ecommerceapi.Entity.Role;
import ecommerceapi.com.ecommerceapi.Entity.UserEntity;
import ecommerceapi.com.ecommerceapi.RestAPI.AppAPI.UserEntityAPI;
import ecommerceapi.com.ecommerceapi.Service.ServiceInterface.RoleService;
import ecommerceapi.com.ecommerceapi.Service.ServiceInterface.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class UserEntityRestImpl  implements UserEntityAPI {
    @Autowired
    public UserEntityService userEntityService;

    @Autowired
    public RoleService roleService;

    @Override
    public ResponseEntity<List<UserEntity>> findAllUser() {
        List<UserEntity> getAllUser= userEntityService.findAllUser();
        return new ResponseEntity<>(getAllUser, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserEntity> getUserByEmail(String email) {
        UserEntity getAllUser= userEntityService.findUserByEmail(email);
        return new ResponseEntity<>(getAllUser, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> save(UserEntityDTO request) {

        try{
            if (validateSignUp(request)) {
                UserEntity user = userEntityService.findUserByEmail(request.getEmail());
                if (Objects.isNull(user)) {
                    userEntityService.save(getUserFromMap(request));
                    return new ResponseEntity<>("Saved", HttpStatus.OK);
                }

                return new ResponseEntity<>("User already exist", HttpStatus.OK);

            }


            return  new ResponseEntity<>("Invalid request",HttpStatus.OK);

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return  new ResponseEntity<>("Invalid request",HttpStatus.OK);
    }

    private boolean validateSignUp(UserEntityDTO request){

        if(!request.getFirstname().equals("") && !request.getLastname().equals("") &&
                !request.getEmail().equals("")&& !request.getGender().equals("")
                && !request.getPhone().equals("") && !request.getPassword().equals("")
                && !request.getReTypePassword().equals("")

        ){
            if( request.getPassword().equals(request.getReTypePassword()) ) {

                return true;
            }
        }

        return false;
    }


    private UserEntity getUserFromMap(UserEntityDTO userdto){
        // UserEntity user= userService.getUserByEmail(userdto.getEmail());
        Role role = roleService.getRoleByName(userdto.getRole());
        List<Role> r= new ArrayList<>();
        r.add(role);

        UserEntity user=new UserEntity();
        user.setFirstname(userdto.getFirstname().toUpperCase(Locale.ROOT));
        user.setLastname(userdto.getLastname());
        user.setGender(userdto.getGender());
        user.setEmail(userdto.getEmail());
        user.setPhone(userdto.getPhone());
        user.setPassword(userdto.getPassword());
        user.setImageName(userdto.getImageName());
        user.setRole(r);
        return  user;
    }

}
