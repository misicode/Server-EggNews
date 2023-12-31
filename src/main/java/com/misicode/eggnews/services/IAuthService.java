package com.misicode.eggnews.services;

import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.payload.SigninRequest;

public interface IAuthService {
    void login(SigninRequest signinRequest);

    User getUserAuthenticated();
}
