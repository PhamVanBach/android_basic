package com.BPeventhandling.model;

import java.io.Serializable;

public class Employee implements Serializable {
    private String _firstName;
    private  String _LastName;
    private Boolean gender;

    public Employee() {

    }

    public Employee(String _firstName, String _LastName, Boolean gender) {
        this._firstName = _firstName;
        this._LastName = _LastName;
        this.gender = gender;
    }

    public String get_firstName() {
        return _firstName;
    }

    public void set_firstName(String _firstName) {
        this._firstName = _firstName;
    }

    public String get_LastName() {
        return _LastName;
    }

    public void set_LastName(String _LastName) {
        this._LastName = _LastName;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
}
