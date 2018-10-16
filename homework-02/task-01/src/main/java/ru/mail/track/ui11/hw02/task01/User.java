package ru.mail.track.ui11.hw02.task01;

/**
 * Класс, описывающий сущность User
 */
public class User {

    private String name;
    private String email;
    private String password;

    public User(String name,String email,String password) {
        this.name = name;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return name + "|" + email + "|" + password;
    }
}
