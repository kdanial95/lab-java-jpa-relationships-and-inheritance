package com.ironhack.week9.demo;

import com.ironhack.week9.enums.GuestStatus;
import com.ironhack.week9.enums.MemberStatus;
import com.ironhack.week9.model.*;
import com.ironhack.week9.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final MemberRepository memberRepo;
    private final DivisionRepository divisionRepo;
    private final AssociationRepository associationRepo;
    private final ContactRepository contactRepo;
    private final GuestRepository guestRepo;
    private final SpeakerRepository speakerRepo;
    private final ConferenceRepository conferenceRepo;
    private final ExhibitionRepository exhibitionRepo;
    private final TaskRepository taskRepo;

    public DataLoader (MemberRepository memberRepo, DivisionRepository divisionRepo, AssociationRepository associationRepo, ContactRepository contactRepo, GuestRepository guestRepo, SpeakerRepository speakerRepo, ConferenceRepository conferenceRepo, ExhibitionRepository exhibitionRepo, TaskRepository taskRepo) {
        this.memberRepo = memberRepo;
        this.divisionRepo = divisionRepo;
        this.associationRepo = associationRepo;
        this.contactRepo = contactRepo;
        this.guestRepo = guestRepo;
        this.speakerRepo = speakerRepo;
        this.conferenceRepo = conferenceRepo;
        this.exhibitionRepo = exhibitionRepo;
        this.taskRepo = taskRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        contactRepo.saveAll(List.of(
                new Contact("OpenAI PR", "PR Manager", new Name("Ms.", "Samantha", "R.", "Lee")),
                new Contact("TechWorld Media", "Comms Lead", new Name("Mr.", "David", "J.", "Grant")),
                new Contact("BrightSpark Agency", "Account Exec", new Name("Dr.", "Nina", null, "Martinez"))
        ));

        Association association = new Association("Nurse Association of Spain");

        association = associationRepo.save(association);

        List<Division> divisions = new ArrayList<>();

        for (int i = 1; i <= 7; i++) {
            Division div = new Division("Division " + i, "District " + i);
            div.setAssociation(association);

            divisionRepo.save(div);

            Member president = new Member("President " + i, MemberStatus.ACTIVE, LocalDate.now());
            president.setDivision(div);
            memberRepo.save(president);
            div.setPresident(president);

            Member member = new Member("Member " + i, MemberStatus.ACTIVE, LocalDate.now().plusYears(1));
            member.setDivision(div);
            memberRepo.save(member);

            div.setMembers(List.of(member));
            divisions.add(div);

            divisionRepo.save(div);
        }

        association.setDivisions(divisions);
        associationRepo.save(association);

        Guest g1 = new Guest("Alice Johnson", GuestStatus.ATTENDING);
        Guest g2 = new Guest("Bob Smith", GuestStatus.NO_RESPONSE);
        Guest g3 = new Guest("Carol White", GuestStatus.NOT_ATTENDING);

        Speaker s1 = new Speaker("Dr. Emily Carter", 45);
        Speaker s2 = new Speaker("Prof. Daniel Kim", 30);
        speakerRepo.saveAll(List.of(s1, s2));

        Conference conf = new Conference("Healthcare Innovations", LocalDate.now(), 2, "Madrid");
        conf.setGuest(g1);
        conf.setGuest(g2);
        conf.setSpeakers(List.of(s1, s2));
        conferenceRepo.save(conf);

        Exhibition ex = new Exhibition();
        ex.setTitle("Medical Equipment Expo");
        ex.setDate(LocalDate.now().plusDays(10));
        ex.setDuration(3);
        ex.setLocation("Barcelona");
        ex.setGuest(g3);
        exhibitionRepo.save(ex);

        Task t1 = new BillableTask("Client Consultation", LocalDate.now().plusDays(3), false, new BigDecimal("120.50"));
        Task t2 = new BillableTask("Report Preparation", LocalDate.now().plusDays(7), false, new BigDecimal("95.00"));
        Task t3 = new InternalTask("Team Meeting", LocalDate.now().plusDays(1), false);
        Task t4 = new InternalTask("Documentation Update", LocalDate.now().plusDays(5), true);
        taskRepo.saveAll(List.of(t1, t2, t3, t4));

        System.out.println("All modules initialized successfully!");

    }
}
