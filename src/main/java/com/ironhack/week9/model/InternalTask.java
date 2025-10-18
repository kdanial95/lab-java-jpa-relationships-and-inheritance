package com.ironhack.week9.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("INTERNAL")
public class InternalTask extends Task {
    public InternalTask() {}
    public InternalTask(String title, java.time.LocalDate dueDate, boolean completed) {
        super(title, dueDate, completed);
    }
}
