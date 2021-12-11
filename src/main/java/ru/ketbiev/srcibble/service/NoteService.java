package ru.ketbiev.srcibble.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.ketbiev.srcibble.dto.NoteDTO;
import ru.ketbiev.srcibble.dto.UserDTO;
import ru.ketbiev.srcibble.repository.NoteRepository;

public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public int create(UserDTO userDTO, NoteDTO noteDTO) throws Exception {
        return noteRepository.create(userDTO, noteDTO);
    }
}
