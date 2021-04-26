package br.com.iteris.meetupmonitoria.resource;

import br.com.iteris.meetupmonitoria.dto.UserDto;
import br.com.iteris.meetupmonitoria.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Log
@AllArgsConstructor
@RestController("user")
public class UserResource {

    private final UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<UserDto> searchUser(@PathVariable(name = "id") String id) {
        log.info("m=searchUser id=" + id);
        UserDto user = userService.findUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody UserDto userDto) {
        log.info("m=saveUser id=" + userDto);
        return ResponseEntity.created(URI.create("/user/" + userService.saveUser(userDto))).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateUser(@PathVariable(name = "id") String id, @RequestBody UserDto userDto) {
        log.info("m=updateUser id=" + id + " userDto=" + userDto);
        return ResponseEntity.ok(userService.saveUser(id, userDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") String id) {
        log.info("m=deleteUser id=" + id);
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
