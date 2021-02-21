package bg.softuni.music_db.services;

import bg.softuni.music_db.models.services.UserLoginServiceModel;
import bg.softuni.music_db.models.services.UserRegisterServiceModel;

public interface UserService {
    void register(UserRegisterServiceModel map);

    boolean authenticate(String username, String password);

    void login(UserLoginServiceModel map);

    void logout();
}
