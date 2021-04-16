package br.com.iteris.meetupmonitoria.service;

import br.com.iteris.meetupmonitoria.dto.UserDto;
import br.com.iteris.meetupmonitoria.repository.UserRepository;
import br.com.iteris.meetupmonitoria.repository.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserService {

    /**
     * user repository
     */
    private final UserRepository userRepository;

    /**
     * save the user
     * @param user the user informations
     * @return the user ID
     */
    public String saveUser(UserDto user) {
        String userId = UUID.randomUUID().toString();

        userRepository.save(new UserEntity(user.getName(), user.getAge(), user.getEmail(), userId));

        return userId;
    }

    /**
     * Find user on the database
     * @param userId the user id to find
     * @return user found on database
     */
    public UserDto findUser(String userId) {
        final UserDto userDto = new UserDto();
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        userEntity.ifPresent(userDto::createFromEntity);

        return userDto;
    }
}
