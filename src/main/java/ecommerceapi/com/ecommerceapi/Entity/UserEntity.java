package ecommerceapi.com.ecommerceapi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class UserEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;
    @Column(name = "gender")
    private String gender;
    @Column(name = "phone")
    private String phone;

    @Column(name = "image_name")
    private String imageName;
    @NaturalId()
    private String email;
    private  String password;


    @JoinTable(name="user_roles" ,
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    @ManyToMany( fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Role> role;

}
