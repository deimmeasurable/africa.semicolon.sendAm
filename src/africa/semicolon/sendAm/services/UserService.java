package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.dtos.requests.RegisterUserRequest;
import africa.semicolon.sendAm.data.dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.data.dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.data.models.UserRespository;

public interface UserService {
    RegisterUserResponse register(RegisterUserRequest requestForm);

    UserRespository getRepository();

    FindUserResponse findUserByEmail(String email);
}
