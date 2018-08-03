package com.poc.pubcentral.bo;

import com.google.common.base.Objects;
import com.poc.pubcentral.bo.dao.interfaces.ContentType;

/**
 * User component to perform login operation
 */

public class UserPojo implements ContentType {

    private final String user;
    private final String password;

    public UserPojo(String name, String pass) {
        this.user = name;
        this.password = pass;
    }

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPojo userPojo1 = (UserPojo) o;
        return Objects.equal(user, userPojo1.user) &&
                Objects.equal(password, userPojo1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(user, password);
    }
}
