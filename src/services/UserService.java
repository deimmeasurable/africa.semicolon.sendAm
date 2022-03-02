package services;

import data.dtos.requests.RegisterUserRequest;
import data.dtos.responses.RegisterUserResponse;
import data.models.UserRespository;

public interface UserService {
    RegisterUserResponse register(RegisterUserRequest requestForm);

    UserRespository getRepository();
}
