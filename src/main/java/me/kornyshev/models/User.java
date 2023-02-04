package me.kornyshev.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class User {

    private String email;
    private String name;
    private String password;

}
