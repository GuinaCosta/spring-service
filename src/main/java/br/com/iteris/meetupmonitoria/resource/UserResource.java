package br.com.iteris.meetupmonitoria.resource;

import br.com.iteris.meetupmonitoria.dto.UserDto;
import br.com.iteris.meetupmonitoria.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@AllArgsConstructor
@RestController("user")
public class UserResource {

    private final UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<UserDto> searchUser(String id) {
        return ResponseEntity.ok(userService.findUser(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveUser(UserDto userDto) {
        return ResponseEntity.created(URI.create("/user/" + userService.saveUser(userDto))).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateUser(String id) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(String id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
