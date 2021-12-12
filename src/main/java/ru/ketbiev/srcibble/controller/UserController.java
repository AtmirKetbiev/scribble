package ru.ketbiev.srcibble.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ketbiev.srcibble.dto.UserDTO;
import ru.ketbiev.srcibble.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDTO create(@RequestBody UserDTO user) throws Exception {
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public UserDTO get(@PathVariable int id) throws Exception {
        return userService.get(id);
    }

    @PutMapping
    public boolean update(@RequestBody UserDTO user) throws Exception {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) throws Exception {
        return userService.delete(id);
    }
}
