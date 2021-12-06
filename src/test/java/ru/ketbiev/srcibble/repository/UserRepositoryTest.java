package ru.ketbiev.srcibble.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.ketbiev.srcibble.model.User;

class UserRepositoryTest {

    @Test
    void create() throws Exception {
        UserRepository userRepository = new UserRepository(
                "jdbc:postgresql://localhost:5432/scribble",
                "postgres",
                "root");
        User user = new User(
                "2021-12-01 12:00:00",
                "2021-12-10 12:00:00",
                "testUser",
                "12345abc",
                "hi, its me!",
                "Test Test");
        Assertions.assertEquals(userRepository.create(user), 1);
    }

    @Test
    void get() throws Exception {
        UserRepository userRepository = new UserRepository(
                "jdbc:postgresql://localhost:5432/scribble",
                "postgres",
                "root");
        Assertions.assertEquals(userRepository.get(1), 1);
    }

    @Test
    void update() throws Exception {
        UserRepository userRepository = new UserRepository(
                "jdbc:postgresql://localhost:5432/scribble",
                "postgres",
                "root");
        User user = new User(
                "2021-12-01 12:00:00",
                "2021-12-10 12:00:00",
                "testUser update",
                "12345abc",
                "hi, its me!",
                "Test Test");
        Assertions.assertEquals(userRepository.update(4, user), 1);
    }

    @Test
    void delete() throws Exception {
        UserRepository userRepository = new UserRepository(
                "jdbc:postgresql://localhost:5432/scribble",
                "postgres",
                "root");
        Assertions.assertEquals(userRepository.delete(1), 1);
    }
}