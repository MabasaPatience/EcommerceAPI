package ecommerceapi.com.ecommerceapi.Service.ServiceInterface;

import ecommerceapi.com.ecommerceapi.Entity.UserEntity;

import java.util.List;

public interface UserEntityService {
    List<UserEntity> findAllUser();

    UserEntity save(UserEntity user);

    UserEntity findUserByEmail(String email);

}
