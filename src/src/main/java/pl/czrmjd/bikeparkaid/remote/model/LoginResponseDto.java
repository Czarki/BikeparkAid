package pl.czrmjd.bikeparkaid.remote.model;

// Klasa ktora ma jedno pole accessToken jako string
// wartoscia tego pola bedzie token wygenerowany za pomoca biblioteki JWT - oczywiscie po logowaniu prawidłowymi danymi
public class LoginResponseDto {
    private String accessToken;

    public LoginResponseDto() {
    }

    public String getAccessToken() {
        return accessToken;
    }
}
