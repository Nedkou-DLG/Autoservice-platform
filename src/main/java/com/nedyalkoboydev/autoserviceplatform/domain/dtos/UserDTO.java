package com.nedyalkoboydev.autoserviceplatform.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.Name;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String role;

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("{");
        stringBuilder.append(String.format("\"id\":%s, ", getId()));
        stringBuilder.append(String.format("\"firstname\":\"%s\", ", getFirstname()));
        stringBuilder.append(String.format("\"lastname\":\"%s\", ", getLastname()));
        stringBuilder.append(String.format("\"email\":\"%s\", ", getEmail()));
        stringBuilder.append(String.format("\"role\":\"%s\"}", getRole()));
        return stringBuilder.toString();
    }
}
