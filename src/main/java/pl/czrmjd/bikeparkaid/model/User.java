package pl.czrmjd.bikeparkaid.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    private final Integer id;
    private final String hash;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final boolean isAdmin;
    private final String address;
    private final String telNumber;
}
