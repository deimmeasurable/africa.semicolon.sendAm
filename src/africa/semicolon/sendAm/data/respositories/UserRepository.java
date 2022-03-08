package africa.semicolon.sendAm.data.respositories;

import africa.semicolon.sendAm.data.models.User;

import java.util.List;

public interface UserRepository {
    User save(User aUser);
    User findByEmail(String email);
    void delete(User aUser);
    void delete(String email);
    List<User> findAll();

int count();
}
