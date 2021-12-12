package ru.ketbiev.srcibble.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ketbiev.srcibble.dto.UserDTO;
import ru.ketbiev.srcibble.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO create(UserDTO user) throws Exception {
        return userRepository.create(user);
    }

    public UserDTO get(int id) throws Exception {
        return userRepository.get(id);
    }

    public boolean update(UserDTO user) throws Exception {
        return userRepository.update(user);
    }

    public boolean delete(int id) throws Exception {
        return userRepository.delete(id);
    }
}
