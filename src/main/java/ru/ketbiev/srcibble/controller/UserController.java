package ru.ketbiev.srcibble.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ketbiev.srcibble.model.User;
import ru.ketbiev.srcibble.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public int create(@RequestBody User user) throws Exception {
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public int get(@PathVariable int id) throws Exception {
        return userService.get(id);
    }

    @PutMapping
    public int update(@RequestBody User user) throws Exception {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable int id) throws Exception {
        return userService.delete(id);
    }
}
