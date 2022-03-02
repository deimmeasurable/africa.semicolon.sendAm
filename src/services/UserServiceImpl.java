package services;

import data.dtos.requests.RegisterUserRequest;
import data.dtos.responses.RegisterUserResponse;
import data.models.User;
import data.models.UserRepositoryImpl;
import data.models.UserRespository;
import exception.RegisterFailureException;

public class UserServiceImpl implements UserService {
    private UserRespository userRepository=new UserRepositoryImpl();

    @Override
    public RegisterUserResponse register(RegisterUserRequest requestForm) {
        requestForm.setEmailAddress(requestForm.getEmailAddress().toLowerCase());
        System.out.println(requestForm.getEmailAddress().toLowerCase());
        if(emailExist(requestForm.getEmailAddress())) throw new RegisterFailureException("Email already exit");
        User user = new User(requestForm.getEmailAddress(),requestForm.getPhoneNumber(),requestForm.getFirstName()+ " "+ requestForm.getLastName(),requestForm.getAddress());

        userRepository.save(user);


       return null;
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

}
