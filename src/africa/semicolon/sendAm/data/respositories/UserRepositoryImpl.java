package africa.semicolon.sendAm.data.respositories;

import africa.semicolon.sendAm.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final List<User> data = new ArrayList<>();
    private String email;

    @Override
    public User save(User aUser) {
        data.add(aUser);
        return aUser;

    }



    @Override
    public User findByEmail(String email) {
        for (User aUser : data) {
          if(aUser.getEmail().equals(email))
            return aUser;
        }
return null;
    }


    @Override
    public void delete(User aUser) {
    data.remove(aUser);
    }

    @Override
    public void delete(String email) {
        User foundUser= findByEmail(email);
        data.remove(foundUser);

    }
    @Override
    public List<User> findAll() {
        return data;
    }

    @Override
    public int count() {
        return data.size();
    }

}
