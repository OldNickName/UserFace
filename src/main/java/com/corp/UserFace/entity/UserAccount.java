package com.corp.UserFace.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min = 3, max = 16, message = "username должен быть от 3х до 16ти символов ")
    @Pattern(regexp = "^[a-zA-Z]{3,16}$", message = "должно состоять только из латинских символов")
    private String userName;

    @Pattern(regexp = "^[a-zA-Z]+[0-9]+|[0-9]+[a-zA-Z]+$")
    @Size(min = 3, max = 16, message = "username должен быть от одного до 16ти символов ")
    private String password;

    @Pattern(regexp = "^[a-zA-Z]{1,16}$", message = "должно состоять только из латинских символов")
    @Size(min = 1, max = 16, message = "username должен быть от одного до 16ти символов ")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z]{1,16}$", message = "должно состоять только из латинских символов")
    @Size(min = 1, max = 16, message = "username должен быть от одного до 16ти символов ")
    private String lastName;

    private String status;

    private LocalDateTime registrationDate;

    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
            name="user_role",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<Role> roles;

    public UserAccount() {
    }

    public UserAccount(Long id,String userName, String password, String firstName, String lastName, String status) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.registrationDate = LocalDateTime.now();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
