package com.springapp.mvc.domain;

import javax.persistence.*;

/**
 * Created by prakhash on 26/08/15.
 */
@Entity
@Table(name = "authentication", schema = "", catalog = "danial")
public class AuthenticationEntity {
    private String userName;
    private String password;
    private String email;
    private String position;
    private int roleId;
    private int isActive;
    private String lastLoginDate;
    private String lastLoginTime;

    public AuthenticationEntity() {
    }

    @Id
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "is_active")
    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Basic
    @Column(name = "last_login_date")
    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Basic
    @Column(name = "last_login_time")
    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthenticationEntity that = (AuthenticationEntity) o;

        if (isActive != that.isActive) return false;
        if (roleId != that.roleId) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (lastLoginDate != null ? !lastLoginDate.equals(that.lastLoginDate) : that.lastLoginDate != null)
            return false;
        if (lastLoginTime != null ? !lastLoginTime.equals(that.lastLoginTime) : that.lastLoginTime != null)
            return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + roleId;
        result = 31 * result + isActive;
        result = 31 * result + (lastLoginDate != null ? lastLoginDate.hashCode() : 0);
        result = 31 * result + (lastLoginTime != null ? lastLoginTime.hashCode() : 0);
        return result;
    }

    public AuthenticationEntity(String userName, String password, String email, int roleId, int isActive,String lastLoginTime, String lastLoginDate,String position) {
        this.lastLoginTime = lastLoginTime;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.position = position;
        this.roleId = roleId;
        this.isActive = isActive;
        this.lastLoginDate = lastLoginDate;
    }
}
