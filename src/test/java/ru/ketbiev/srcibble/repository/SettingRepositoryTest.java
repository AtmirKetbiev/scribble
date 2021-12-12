package ru.ketbiev.srcibble.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.ketbiev.srcibble.dto.SettingDTO;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

class SettingRepositoryTest {
    @Test
    void create() throws Exception {
        String dt = OffsetDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        SettingRepository settingRepository = new SettingRepository(
                "jdbc:postgresql://localhost:5432/test_db",
                "postgres",
                "root");
        SettingDTO setting = new SettingDTO(
                1,
                "night",
                false);
        Assertions.assertEquals(settingRepository.create(setting), 1);
    }
}