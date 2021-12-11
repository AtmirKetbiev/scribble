package ru.ketbiev.srcibble.dto;

import java.time.LocalDateTime;

public class BookDTO {

    private int id;
    private String name;
    private LocalDateTime createDateTime;
    private LocalDateTime finishDataTime;
    private String description;
    private  LocalDateTime lastLogin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getFinishDataTime() {
        return finishDataTime;
    }

    public void setFinishDataTime(LocalDateTime finishDataTime) {
        this.finishDataTime = finishDataTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
}
