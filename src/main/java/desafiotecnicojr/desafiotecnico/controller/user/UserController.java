package desafiotecnicojr.desafiotecnico.controller.user;


import desafiotecnicojr.desafiotecnico.dtos.user.UserList;
import desafiotecnicojr.desafiotecnico.service.UserService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<Page<UserList>> listUser(@ParameterObject Pageable pageable) {
        return ResponseEntity.ok(userService.listUser(pageable));
    }
}
