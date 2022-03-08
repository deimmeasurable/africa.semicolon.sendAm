package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.dtos.requests.RegisterUserRequest;
import africa.semicolon.sendAm.data.dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.data.dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.data.respositories.UserRepository;

public interface UserService {
    RegisterUserResponse register(RegisterUserRequest requestForm);

    UserRepository getRepository();

    FindUserResponse findUserByEmail(String email);
}
