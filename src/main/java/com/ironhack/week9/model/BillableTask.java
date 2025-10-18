package com.ironhack.week9.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("BILLABLE")
public class BillableTask extends Task {
    private BigDecimal hourlyRate;

    public BillableTask() {}
    public BillableTask(String title, LocalDate dueDate, boolean completed, BigDecimal hourlyRate) {
        super(title, dueDate, completed);
        this.hourlyRate = hourlyRate;
    }

}

