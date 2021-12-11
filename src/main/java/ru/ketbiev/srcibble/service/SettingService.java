package ru.ketbiev.srcibble.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ketbiev.srcibble.dto.SettingDTO;
import ru.ketbiev.srcibble.repository.SettingRepository;

@Service
public class SettingService {

    @Autowired
    private SettingRepository settingRepository;

    public int create(SettingDTO settingDTO) throws Exception {
        return settingRepository.create(settingDTO);
    }

//    public int get(int id) throws Exception {
//        return settingRepository.get(id);
//    }
//
//    public int update(UserDTO user) throws Exception {
//        return settingRepository.update(user.getId(),user);
//    }
//
//    public int delete(int id) throws Exception {
//        return settingRepository.delete(id);
//    }
}
