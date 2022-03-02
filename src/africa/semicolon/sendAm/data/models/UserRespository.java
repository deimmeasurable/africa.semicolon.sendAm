package africa.semicolon.sendAm.data.models;

import java.util.List;

public interface UserRespository {
    User save(User aUser);
    User findByEmail(String email);
    void delete(User aUser);
    void delete(String email);
    List<User> findAll();

int count();
}
