package com.simplepayment.dtos;

import com.simplepayment.projections.UserProjection;

public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String userType;

    public UserDTO() {
    }

    public UserDTO(UserProjection projection) {
        this.id = projection.getUserId();
        this.firstName = projection.getUserFirstName();
        this.lastName = projection.getUserLastName();
        this.userType = projection.getUserType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}
