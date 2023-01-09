package pl.czrmjd.bikeparkaid.remote.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czrmjd.bikeparkaid.data.entity.UserEntity;
import pl.czrmjd.bikeparkaid.remote.model.LoginResponseDto;
import pl.czrmjd.bikeparkaid.service.AccessTokenService;
import pl.czrmjd.bikeparkaid.service.UserService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/login")
public class LoginController {
    private final UserService userService;
    private final AccessTokenService accessTokenService;

    public LoginController(UserService userService, AccessTokenService accessTokenService) {
        this.userService = userService;
        this.accessTokenService = accessTokenService;
    }

    @PostMapping //get/post + mapping
    public ResponseEntity<LoginResponseDto> login(
        @RequestHeader("X-AUTH-EMAIL") String email,
        @RequestHeader("X-AUTH-PASSWORD") String password) throws Exception {

//        TODO: sprawdzenie czy user istnieje w bazie danych
        if (userService.checkExistUserByEmailAndPassword(email, password)) {
            UserEntity userEntity = userService.getUserByEmail(email);
            if (userEntity.isAccountConfirmed()) {
                String accessToken = accessTokenService.generateAccessToken(userEntity.getId(), userEntity.isAdmin());
                return ResponseEntity.status(HttpStatus.OK)
                    .body(new LoginResponseDto(accessToken));
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .build();
    }
}
