package com.misicode.eggnews.domain;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.StringTokenizer;

@Document(collection = "users")
public class User {
    @Id
    private String idUser;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String names;

    @NotNull
    private String surnames;

    @NotNull
    private Boolean isActive = true;

    @DBRef
    private List<News> news;

    @NotNull
    @DBRef
    private Role role;

    @CreatedDate
    @NotNull
    private LocalDateTime createdAt;

    @LastModifiedDate
    @NotNull
    private LocalDateTime updatedAt;

    public String getIdUser() {
        return idUser;
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

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getSomeName() {
        return (new StringTokenizer(names)).nextToken() + " " + surnames;
    }

    public String getFullName() {
        return names + " " + surnames;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
