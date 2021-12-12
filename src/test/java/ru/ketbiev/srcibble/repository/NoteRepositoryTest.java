package ru.ketbiev.srcibble.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.ketbiev.srcibble.dto.NoteDTO;
import ru.ketbiev.srcibble.dto.UserDTO;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

class NoteRepositoryTest {
    @Test
    void create() throws Exception {
        String dt = OffsetDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        NoteRepository noteRepository = new NoteRepository(
                "jdbc:postgresql://localhost:5432/test_db",
                "postgres",
                "root");
        NoteDTO noteDTO = new NoteDTO("987654321", dt);

        Assertions.assertEquals(noteRepository.create(1, noteDTO), 1);
    }
}