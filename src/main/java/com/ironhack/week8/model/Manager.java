package com.ironhack.week8.model;

import jakarta.persistence.*;

@Entity
public class Manager extends Employee {
    private String department;
    private String position;
    private float salary;
    private float bonus;
    private String teamSize;

    @Embedded
    private UserProfile userProfile;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "contactInfo", column = @Column(name = "emp_comtact_info")),
            @AttributeOverride(name = "emergencyContact", column = @Column(name = "emp_emergency_contact"))
    })

    private UserProfile empUserProfile;

    public Manager() {}

    public Manager(String name, String surname, String email, String phoneNumber, String department, String position, float salary, float bonus, String teamSize) {
        super(name, surname, email, phoneNumber);
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.bonus = bonus;
        this.teamSize = teamSize;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public String getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(String teamSize) {
        this.teamSize = teamSize;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public UserProfile getEmpUserProfile() {
        return empUserProfile;
    }

    public void setEmpUserProfile(UserProfile empUserProfile) {
        this.empUserProfile = empUserProfile;
    }
}
