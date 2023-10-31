package com.api.crud.contrroller;

import com.api.crud.model.UserEntity;
import com.api.crud.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    @GetMapping("listUsers")
    public ArrayList<UserEntity> getListUsers(){
        return this.userService.getListUsers();
    }

    @PostMapping("save")
    public UserEntity saveUser(@RequestBody UserEntity user){
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "userById/{id}")
    public Optional<UserEntity> getUserPorId(@PathVariable Long id){
        return this.userService.getPorId(id);
    }

    @DeleteMapping(path="delete/{id}")
    public String deletePorId(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUserPorId(id);

        if (ok){
            return "Usuario con id" + id + "eliminado";
        }else {
            return "Error, usuario con id" + id + "tiene un problema y no se puede eliminar";
        }
    }
}
