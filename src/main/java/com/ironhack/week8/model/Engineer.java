package com.ironhack.week8.model;

import jakarta.persistence.Entity;

@Entity
public class Engineer extends Employee {
    private String specialization;
    private String experience;
    private String skills;
    private String languages;
    private String hobbies;
    private String education;

    public Engineer() {}

    public Engineer(String name, String surname, String email, String phoneNumber, String specialization, String experience, String skills, String languages, String hobbies, String education) {
        super(name, surname, email, phoneNumber);
        this.specialization = specialization;
        this.experience = experience;
        this.skills = skills;
        this.languages = languages;
        this.hobbies = hobbies;
        this.education = education;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
