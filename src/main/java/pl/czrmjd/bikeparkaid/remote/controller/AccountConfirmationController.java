package pl.czrmjd.bikeparkaid.remote.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czrmjd.bikeparkaid.service.UserService;

@RestController
@RequestMapping(value = "/api/v1/account-confirmation")
public class AccountConfirmationController {
    private final UserService userService;

    public AccountConfirmationController(UserService userService) {
        this.userService = userService;
    }

    //    placeholder {key}  w getMapping (@GetMapping("{key}")) oznacza ze chcemy uzyskać wartość z endpointu czesci endpointu
//    przykład:
//    wysyłąmy reguest GET na endpoint: /api/v1/account-confirmation/aaabbbccc
//    w tym przypadku zmienna confirmationKey bedzie miala wartość: aaabbbccc
    @GetMapping("{key}")
    public ResponseEntity<Void> confirmAccount(@PathVariable("key") String confirmationKey) {
        userService.confirmAccount(confirmationKey);
//        jeśli chcemy wystać status odpowiedzi 200 OK nie trzeba uzywac metody .status() mozna bezposrednio
//        uzyc metody .ok() jest ona rownoznaczna z metoda .status(HttpStatus.OK)
        return ResponseEntity.ok()
            .build();

    }
}
