package com.SampleProject.Hospital_Management.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Data // it will generate internally getter and setter there is no need to add manually means itself
//@AllArgsConstructor // it will add all parameter constructor internally again there is no need to add manually
public class Doctor {
    private int id;
    private String name;
    private String Email_id;
    private String specialization;

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

    public String getEmail_id() {
        return Email_id;
    }

    public void setEmail_id(String email_id) {
        Email_id = email_id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}


