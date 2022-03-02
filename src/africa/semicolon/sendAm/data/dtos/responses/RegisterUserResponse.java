package africa.semicolon.sendAm.data.dtos.responses;

public class RegisterUserResponse {
    private String fullName;
    private String email;

    public String getFullName() {
        return fullName;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email =email;
    }

    public void setFullName(String fullName) {
        this.fullName=fullName;
    }
}
