package ru.ketbiev.srcibble.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ketbiev.srcibble.dto.UserDTO;
import ru.ketbiev.srcibble.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public int create(UserDTO user) throws Exception {
        return userRepository.create(user);
    }

    public int get(int id) throws Exception {
        return userRepository.get(id);
    }

    public int update(UserDTO user) throws Exception {
        return userRepository.update(user.getId(),user);
    }

    public int delete(int id) throws Exception {
        return userRepository.delete(id);
    }
}
