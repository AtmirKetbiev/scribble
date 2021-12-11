package ru.ketbiev.srcibble.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SettingDTO {
    private int id;
    @NonNull private Integer userId;
    @NonNull private String theme;
    @NonNull private Boolean isMkd;
}
