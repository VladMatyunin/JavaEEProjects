package ru.kpfu.itis.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Vlad.M on 07.09.2016.
 */
public class PostForm {
    @NotEmpty(message = "Введите ваше название")
    @Size(min = 2, max = 30, message = "Введите корректное название")
    private String name;
    @NotEmpty(message = "Введите текст")
    @Size(min = 100, max = 5000, message = "Введите корректный текст")
    private String text;
    @NotEmpty(message = "выберите тэг")
    private String tags;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
