package africa.semicolon.sendAm.data.models;

public class User {

    private String User;
    private String email;
    private String phoneNumber;
    private static String fullName;
    private String address;

    public User(String email, String phoneNumber, String fullName, String address) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.address = address;


    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static String getFullName() {
        return fullName;
    }

    public static void setFullName(String fullName) {
        fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int count() {
        return 0;
    }
}
