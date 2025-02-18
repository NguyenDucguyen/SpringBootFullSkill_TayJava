package vn.tayjava.dto.request;

import java.io.Serializable;

public class UserRequestDTO implements Serializable {
    private String firtName;
    private String lastName;
    private String email;
    private String phone;

    public UserRequestDTO() {}

    public UserRequestDTO(String firtName, String lastName, String email, String phone) {
        this.firtName = firtName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserRequestDTO{" +
                "firtName='" + firtName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
