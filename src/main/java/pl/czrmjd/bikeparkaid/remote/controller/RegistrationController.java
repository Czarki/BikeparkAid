package pl.czrmjd.bikeparkaid.remote.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czrmjd.bikeparkaid.remote.model.RegistrationDto;
import pl.czrmjd.bikeparkaid.service.UserService;

@RestController
@RequestMapping(value = "/api/v1/registration") //{} placeholder @REQUESTbody, @requestparam, @pathvariable
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    //    ResponseEntity<Void> oznacza ze metoda nic nie zwraca, odpowiedź response z naszej aplikacji nie bedzie miala body!
    @PostMapping //get/post + mapping
    public ResponseEntity<Void> register(@RequestBody RegistrationDto registrationDto) {
        userService.register(registrationDto);

        return ResponseEntity.status(HttpStatus.CREATED)
            .build(); //.body zawiera od razu .build
    }
}
