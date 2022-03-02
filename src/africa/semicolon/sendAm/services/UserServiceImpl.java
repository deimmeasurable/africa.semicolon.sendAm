package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.dtos.requests.RegisterUserRequest;
import africa.semicolon.sendAm.data.dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.data.dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.data.models.User;
import africa.semicolon.sendAm.data.models.UserRepositoryImpl;
import africa.semicolon.sendAm.data.models.UserRespository;
import africa.semicolon.sendAm.exception.RegisterFailureException;
import africa.semicolon.sendAm.exception.UserNotFoundException;
//import africa.semicolon.sendAm.exception.*;
//import africa.semicolon.sendAm.exception.*;

public class UserServiceImpl implements UserService {
    private UserRespository userRepository=new UserRepositoryImpl();

    @Override
    public RegisterUserResponse register(RegisterUserRequest requestForm) {
        requestForm.setEmailAddress(requestForm.getEmailAddress().toLowerCase());
        System.out.println(requestForm.getEmailAddress().toLowerCase());
        if(emailExist(requestForm.getEmailAddress())) throw new RegisterFailureException("Email already exit");
        User user = new User(requestForm.getEmailAddress(),requestForm.getPhoneNumber(),requestForm.getFirstName()+ " "+ requestForm.getLastName(),requestForm.getAddress());

        userRepository.save(user);

        User savedUser=userRepository.save(user);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setEmail((savedUser.getEmail()));
        response.setFullName(savedUser.getFullName());

       return response;
    }

    private boolean emailExist(String emailAddress) {
        User user = userRepository.findByEmail(emailAddress);
        if(user!=null)return true;
        return false;
    }

    @Override
    public UserRespository getRepository() {
        return userRepository;
    }

    @Override
    public FindUserResponse findUserByEmail(String email) {
        email=email.toLowerCase();
        User user = userRepository.findByEmail(email);
        // create Response
        if(user==null)throw new UserNotFoundException(email+"comuserNotFound");
        FindUserResponse response = new FindUserResponse();
        response.setEmail(user.getEmail());
        response.setFullName(User.getFullName());

        return response;
    }

}
