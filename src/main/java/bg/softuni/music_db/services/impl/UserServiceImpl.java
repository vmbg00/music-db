package bg.softuni.music_db.services.impl;

import bg.softuni.music_db.models.entities.User;
import bg.softuni.music_db.models.services.UserLoginServiceModel;
import bg.softuni.music_db.models.services.UserRegisterServiceModel;
import bg.softuni.music_db.repositories.UserRepository;
import bg.softuni.music_db.security.CurrentUser;
import bg.softuni.music_db.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void register(UserRegisterServiceModel userRegisterServiceModel) {
        User user = new User();

        user
                .setUsername(userRegisterServiceModel.getUsername())
                .setFullName(userRegisterServiceModel.getFullName())
                .setEmail(userRegisterServiceModel.getEmail())
                .setPassword(userRegisterServiceModel.getPassword())
                .setId(userRegisterServiceModel.getId());

        this.userRepository.save(user);
    }

    @Override
    public boolean authenticate(String username, String password) {
        Optional<User> user = this.userRepository.findByUsername(username);

        if (user.isEmpty()){
            return false;
        }
        else {
            return user.get().getPassword().equals(password);
        }
    }

    @Override
    public void login(UserLoginServiceModel map) {
        currentUser.setName(map.getUsername()).setAnonymous(false);
    }

    @Override
    public void logout() {
        this.currentUser.setName(null).setAnonymous(true);
    }
}
