package com.seguridad.api.controller;

import com.seguridad.api.dto.auth.UserDto;
import com.seguridad.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> findAll(){
        List<UserDto> lista = userService.getAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id){
        UserDto usuario = userService.getById(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto){
        UserDto saved = userService.save(userDto);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto, @PathVariable String id){
        UserDto update = userService.update(userDto, id);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
