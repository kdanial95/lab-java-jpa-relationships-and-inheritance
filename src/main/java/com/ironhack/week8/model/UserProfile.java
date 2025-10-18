package com.ironhack.week8.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserProfile {
    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "emergency_contact")
    private String emergencyContact;

    public UserProfile() {}

    public UserProfile(String contactInfo, String emergencyContact) {
        this.contactInfo = contactInfo;
        this.emergencyContact = emergencyContact;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
}
