package com.nedyalkoboydev.autoserviceplatform.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginViewModel {
    private String email;
    private String password;
}
