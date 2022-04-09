package net.seyfe.waamainlab.domain.dto;

import lombok.Data;

@Data
public class UserDto {
    long id;
    private String email;
    private String firstname;
    private String lastname;
}
