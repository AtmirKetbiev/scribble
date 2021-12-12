package ru.ketbiev.srcibble.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class SettingDTO {
    private int id;
    @NonNull private Integer userId;
    @NonNull private String theme;
    @NonNull private Boolean isMkd;
}
