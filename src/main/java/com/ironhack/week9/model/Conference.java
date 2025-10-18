package com.ironhack.week9.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Conference extends Event {

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(
            name = "conference_speakers",
            joinColumns = @JoinColumn(name = "conference_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id")
    )
    private List<Speaker> speakers;

    public Conference() {}

    public Conference(String title, java.time.LocalDate date, Integer duration, String location) {
        super(title, date, duration, location);
    }

    public List<Speaker> getSpeakers() { return speakers; }
    public void setSpeakers(List<Speaker> speakers) { this.speakers = speakers; }

    @Override
    public String toString() {
        return "Conference{" +
                "speakers=" + speakers +
                '}';
    }
}
