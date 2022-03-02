package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.dtos.requests.RegisterUserRequest;
import africa.semicolon.sendAm.data.dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.data.dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.exception.SendAmAppException;
import africa.semicolon.sendAm.exception.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserServiceImplTest {
    private UserService userService;

    @BeforeEach
    void setUp() {

        userService = new UserServiceImpl();
    }

    @Test
    void afterRegister_repositoryContainsOneElement() {
        //given
        RegisterUserRequest registerForm = new RegisterUserRequest();
        registerForm.setFirstName("lion");
        registerForm.setLastName("lion");
        registerForm.setEmailAddress("lionage@gmail.com");
        registerForm.setAddress("herbert macaulay");

        userService.register(registerForm);

        assertEquals(1, userService.getRepository().count());

    }

    private RegisterUserRequest createRegisterForm() {
        RegisterUserRequest registerForm = new RegisterUserRequest();
        registerForm.setFirstName("lion");
        registerForm.setLastName("lion");
        registerForm.setEmailAddress("lionage@gmail.com");
        registerForm.setAddress("herbert macaulay");
        registerForm.setPhoneNumber("911");
        return registerForm;
    }

    @Test
    public void duplicateEmail_throwException() {
        RegisterUserRequest lionForm = createRegisterForm();

        userService.register(lionForm);

        assertThrows(SendAmAppException.class, () -> userService.register(lionForm));
//        assertThrows(RegisterFailureException.class,()->userService.register(lionForm));


    }

    @Test
    public void duplicateEmailWithDifferenceCase_throwException() {
        RegisterUserRequest lionForm = createRegisterForm();

        //when
        userService.register(lionForm);
        lionForm.setEmailAddress("Lionage@gmail.com");
        assertThrows(SendAmAppException.class, () -> userService.register(lionForm));
//       assertThrows(RegisterFailureException.class,()->userService.register(lionForm));
    }

    @Test
    public void registrationReturnsCorrectResponseTest() {
        RegisterUserRequest lionForm = createRegisterForm();
        RegisterUserResponse response = userService.register(lionForm);
        assertEquals("lion lion", response.getFullName());
        assertEquals("lionage@gmail.com", response.getEmail());

    }

    @Test
    public void findRegisteredUserByEmailTest() {
        RegisterUserRequest lionForm = createRegisterForm();
        userService.register(lionForm);

        FindUserResponse response = userService.findUserByEmail(lionForm.getEmailAddress().toLowerCase());

        assertEquals("lion lion", response.getFullName());
        assertEquals("lionage@gmail.com", response.getEmail());

    }

    @Test
    public void findingUnregisterEmail_throwExceptionTest() {
        RegisterUserRequest lionForm = createRegisterForm();
        userService.register(lionForm);

        assertThrows(UserNotFoundException.class, () -> userService.findUserByEmail("johnage@gmail.com"));
    }
    @Test
    public void findByUserEmailIsNotCaseSensitiveTest(){
        RegisterUserRequest lionForm = createRegisterForm();
        userService.register(lionForm);
        FindUserResponse response =userService.findUserByEmail("lionAge@gmail.com");

        assertEquals("lion lion", response.getFullName());
        assertEquals("lionage@gmail.com", response.getEmail());


    }

}
