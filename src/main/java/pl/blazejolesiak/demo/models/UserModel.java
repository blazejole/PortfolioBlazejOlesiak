package pl.blazejolesiak.demo.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="webuser")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
@NotEmpty(message = "{NotEmpty.userModel.name}")
@Size(min=3, max=30, message = "{Size.userModel.name}")
    private String name;
    @NotEmpty(message = "{NotEmpty.userModel.email}")
    @Email
    private String email;
    @NotEmpty(message = "{NotEmpty.userModel.username}")
    @Size(min=3, max=60, message = "{Size.userModel.username}")
    private String username;
    @NotEmpty(message = "{NotEmpty.userModel.password}")
    @Size(min=3, max=40,message = "{Size.userModel.password}")
    private String password;
    @NotEmpty(message = "{NotEmpty.userModel.confirmPass}")
    @Size(min=3, max=40, message = "{Size.userModel.confirmPass}")
    private String confirmPass;

    public UserModel() {
    }

    public UserModel( String name, String email, String username, String password, String confirmPass) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.confirmPass = confirmPass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPass='" + confirmPass + '\'' +
                '}';
    }
}
