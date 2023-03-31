package ecommerceapi.com.ecommerceapi.Service;

import ecommerceapi.com.ecommerceapi.Repository.UserEntityRepository;
import ecommerceapi.com.ecommerceapi.Entity.UserEntity;
import ecommerceapi.com.ecommerceapi.Service.ServiceInterface.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityServiceImpl implements UserEntityService {
    @Autowired
    public UserEntityRepository userEntityRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;
    @Override
    public List<UserEntity> findAllUser() {
        return userEntityRepository.findAll();
    }

    @Override
    public UserEntity save(UserEntity user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userEntityRepository.save(user);
    }

    @Override
    public UserEntity findUserByEmail(String email) {
        return  userEntityRepository.findByEmail(email);
    }
}
