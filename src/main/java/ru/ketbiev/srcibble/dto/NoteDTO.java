package ru.ketbiev.srcibble.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class NoteDTO {
    private int id;
    @NonNull private String name;
    private String text;
    @NonNull private String createDateTime;
}
