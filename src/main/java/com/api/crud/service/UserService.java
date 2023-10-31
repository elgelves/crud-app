package com.api.crud.service;

import com.api.crud.model.UserEntity;
import com.api.crud.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository iUserRepository;

    public ArrayList<UserEntity> getListUsers(){
        return (ArrayList<UserEntity>) iUserRepository.findAll();
    }

    public UserEntity saveUser(UserEntity user){
        return iUserRepository.save(user);
    }

    public Optional<UserEntity> getPorId(Long id){
        return iUserRepository.findById(id);
    }

    public Boolean deleteUserPorId(Long id){
        try{
            iUserRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
