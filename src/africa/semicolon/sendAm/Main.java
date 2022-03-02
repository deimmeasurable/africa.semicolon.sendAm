package africa.semicolon.sendAm;

import africa.semicolon.sendAm.controllers.UserController;
import africa.semicolon.sendAm.data.dtos.requests.RegisterUserRequest;
import africa.semicolon.sendAm.data.dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.data.dtos.responses.RegisterUserResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Main {
    private static UserController userController=new UserController();

    public static void main(String[] args) {
        //load options
//        loadOptions();
        SpringApplication.run(Main.class, args);
        //if option is register
        //load form
        //print output
        // load options

        //if option is search by email
        //ask for email
        //show
        // load options
    }

    private static void loadOptions() {
        String options = """
                -> A for Register
                -> B for Find by email
                """;
        String input = collectStringInput(options);
        switch (input.toLowerCase()){
            case "a"->loadRegisterForm();
            case "b"-> askUserForEmail();
            default -> {
                display("get sense");
                loadOptions();
            }
        }
    }
    private static  void askUserForEmail(){
        String userEmail=collectStringInput("Enter the email you want to search");
        FindUserResponse response = userController.getUserByEmail(userEmail);
        display(response.toString());
        loadOptions();
    }

    private static String collectStringInput(String message) {
        Scanner scanner=new Scanner(System.in);
        display(message);
        return scanner.nextLine();
    }
    private  static void display(String message){
        System.out.println(message);
    }
    private static void loadRegisterForm(){
        RegisterUserRequest form = new RegisterUserRequest();
        form.setFirstName(collectStringInput("Enter your first name"));
        form.setLastName(collectStringInput("Enter your last name"));
        form.setAddress(collectStringInput("Enter your address"));
        form.setPhoneNumber(collectStringInput("Enter your phoneNumber"));
        form.setEmailAddress(collectStringInput("Enter your first name"));
        RegisterUserResponse response = userController.registerNewUser(form);
        display(response.toString());
        loadOptions();
    }
}
