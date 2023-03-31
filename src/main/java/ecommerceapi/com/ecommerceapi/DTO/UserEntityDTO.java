package ecommerceapi.com.ecommerceapi.DTO;

import lombok.Data;

@Data
public class UserEntityDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String gender;
    private String phone;
    private String imageName;
    private  String password;
    private String reTypePassword;
    private String role;
}
