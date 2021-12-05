package ru.ketbiev.srcibble.repository;

import org.junit.jupiter.api.Test;
import ru.ketbiev.srcibble.model.User;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    void create() {
        UserRepository userRepository = new UserRepository(
                "jdbc:postgresql://localhost:5432/test_db",
                "postgres",
                "root");
        User user = new User(
                "2021-12-01 12:00:00",
                "2021-12-10 12:00:00",
                "testUser",
                "12345abc",
                "hi, its me!",
                "Test Test");
        userRepository.create(user);
    }
}