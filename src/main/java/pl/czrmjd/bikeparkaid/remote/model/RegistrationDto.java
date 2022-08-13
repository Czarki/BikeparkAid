package pl.czrmjd.bikeparkaid.remote.model;

public class RegistrationDto {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String address;
    private String telNumber;

    public RegistrationDto() {

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getTelNumber() {
        return telNumber;
    }
}
