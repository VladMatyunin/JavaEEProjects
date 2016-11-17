package ru.kpfu.itis.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Vlad.M on 06.09.2016.
 */
public class RegistrForm {
    @NotEmpty(message = "Введите ваше имя.")
    @Size(min = 2, max = 30, message = "Введите корректное имя.")
    private String name;
    @NotEmpty(message = "Введите вашу фамилию.")
    @Size(min = 2, max = 50, message = "Введите корректую фамилию.")
    private String surname;
    @NotEmpty(message = "Введите вашу почту")
    @Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
            message="Неверный формат email")
    private String email;
    @NotEmpty(message = "Введите пароль")
    @Size(max = 20, min = 6, message = "Длина пароля - от 6 до 20 символов")
    private String password;
    private String confirmPassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
