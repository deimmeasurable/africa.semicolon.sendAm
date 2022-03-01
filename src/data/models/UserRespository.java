package data.models;

import java.util.List;

interface UserRepository {
    User save(User aUser);
    User findByEmail(String email);
    void delete(User aUser);
    void delete(String email);
    List<User> findAll();

int count();
}
