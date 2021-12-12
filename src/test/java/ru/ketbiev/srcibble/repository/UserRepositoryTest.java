package ru.ketbiev.srcibble.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.ketbiev.srcibble.dto.UserDTO;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

class UserRepositoryTest {

    @Test
    void create() {
        try {
            String dt = OffsetDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            UserRepository userRepository = new UserRepository(
                    "jdbc:postgresql://localhost:5432/test_db",
                    "postgres",
                    "root");
            UserDTO user = new UserDTO(
                    "test",
                    "12345",
                    "Test Test",
                    "2021-12-01 12:00:00",
                    dt);
            System.out.println(userRepository.create(user).getId());
            Assertions.assertTrue(true);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            Assertions.fail();
        }
    }

    @Test
    void get() {
        try {
            UserRepository userRepository = new UserRepository(
                    "jdbc:postgresql://localhost:5432/test_db",
                    "postgres",
                    "root");
            System.out.println(userRepository.get(9));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            Assertions.fail();
        }
    }

    @Test
    void update() throws Exception {
        try {
            String dt = OffsetDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            UserRepository userRepository = new UserRepository(
                    "jdbc:postgresql://localhost:5432/test_db",
                    "postgres",
                    "root");
            UserDTO user = new UserDTO(
                    8,
                    "testUpdate",
                    "12345",
                    "Test Test",
                    null,
                    "2021-12-01 12:00:00",
                    dt);
            System.out.println(userRepository.update(user));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            Assertions.fail();
        }
    }

    @Test
    void delete() throws Exception {
        try {
            UserRepository userRepository = new UserRepository(
                    "jdbc:postgresql://localhost:5432/test_db",
                    "postgres",
                    "root");
            System.out.println(userRepository.delete(8));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            Assertions.fail();
        }
    }
}