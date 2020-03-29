package com.example.controller;

import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "auth", produces = "application/json; charset=utf-8")
public class AuthController {

    @PostMapping("/login")
    private void login(@RequestBody @Validated FacebookAuthResponse facebookAuthResponse) {
        FacebookTemplate facebookTemplate = new FacebookTemplate(facebookAuthResponse.getAccessToken());
        User user = facebookTemplate.fetchObject("me", User.class, "id", "email", "first_name", "last_name");
        user.getFirstName();
    }
}
