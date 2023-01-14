package com.nedyalkoboydev.autoserviceplatform.application.services.contracts;

import com.nedyalkoboydev.autoserviceplatform.domain.models.AuthenticationResponse;
import com.nedyalkoboydev.autoserviceplatform.domain.models.LoginViewModel;
import com.nedyalkoboydev.autoserviceplatform.domain.models.RegisterViewModel;

public interface IAuthenticationService {
    AuthenticationResponse register (RegisterViewModel request);
    AuthenticationResponse login(LoginViewModel request);
}
