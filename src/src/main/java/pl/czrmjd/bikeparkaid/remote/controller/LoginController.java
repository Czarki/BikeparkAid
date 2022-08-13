package pl.czrmjd.bikeparkaid.remote.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czrmjd.bikeparkaid.remote.model.LoginResponseDto;

@RestController
@RequestMapping(value = "/api/v1/login")
public class LoginController {

    @PostMapping //get/post + mapping
    public ResponseEntity<LoginResponseDto> register(
        @RequestHeader("X-AUTH-EMAIL") String email,
        @RequestHeader("X-AUTH-PASSWORD") String password) {


        return ResponseEntity.status(HttpStatus.OK)
            .body(new LoginResponseDto()); // tutaj bedziemy dodawac utworzony obiekt LoginResponseDto,
//        w tej chwili nie mamy jeszcze implementacji logowania ale docelowo obiekt LoginResponseDto bedzie wypełniany danymi

    }
}
