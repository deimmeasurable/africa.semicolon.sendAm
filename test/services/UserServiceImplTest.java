package services;

import data.dtos.requests.RegisterUserRequest;
import data.dtos.responses.RegisterUserResponse;
import exception.SendAmAppException;
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
void afterRegister_repositoryContainsOneElement(){
        //given
        RegisterUserRequest registerForm = new RegisterUserRequest();
        registerForm.setFirstName("lion");
        registerForm.setLastName("lion");
        registerForm.setEmailAddress("lionage@gmail.com");
        registerForm.setAddress("herbert macaulay");

        userService.register(registerForm);

        assertEquals(1,userService.getRepository().count());

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
    public void duplicateEmail_throwException(){
        RegisterUserRequest lionForm=createRegisterForm();

        userService.register(lionForm);

        assertThrows(SendAmAppException.class,()->userService.register(lionForm));
//        assertThrows(RegisterFailureException.class,()->userService.register(lionForm));


    }
    @Test
    public void duplicateEmailWithDifferenceCase_throwException(){
        RegisterUserRequest lionForm=createRegisterForm();

        //when
        userService.register(lionForm);
        lionForm.setEmailAddress("Lionage@gmail.com");
       assertThrows(SendAmAppException.class,()->userService.register(lionForm));
//       assertThrows(RegisterFailureException.class,()->userService.register(lionForm));
    }
   @Test
   public void registrationReturnsCorrectResponseTest(){
       RegisterUserRequest lionForm = createRegisterForm();
       RegisterUserResponse response = userService.register(lionForm);
      assertEquals("lion lion",response.getFullName());
       assertEquals("lionage@gmail.com",response.getEmail());

   }

}
