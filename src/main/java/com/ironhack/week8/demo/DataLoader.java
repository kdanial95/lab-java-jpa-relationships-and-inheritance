package com.ironhack.week8.demo;

import com.ironhack.week8.model.Employee;
import com.ironhack.week8.model.Engineer;
import com.ironhack.week8.model.Manager;
import com.ironhack.week8.repository.EmployeeRepository;
import com.ironhack.week8.repository.EngineerRepository;
import com.ironhack.week8.repository.ManagerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final EmployeeRepository employeeRepository;
    private final ManagerRepository managerRepository;
    private final EngineerRepository engineerRepository;

    public DataLoader(EmployeeRepository employeeRepository, ManagerRepository managerRepository, EngineerRepository engineerRepository) {
        this.employeeRepository = employeeRepository;
        this.managerRepository = managerRepository;
        this.engineerRepository = engineerRepository;
    }

    @Override
    public void run(String... args){
        System.out.println("Loading data...");

        if (employeeRepository.count() == 0) {
            var Employee1 = new Employee("Juan", "Perez", "", "123456789");
            var Employee2 = new Employee("Maria", "Garcia", "", "987654321");
            var Employee3 = new Employee("Pedro", "Lopez", "", "567890123");

            employeeRepository.saveAll(List.of(Employee1, Employee2, Employee3));

            var Manager1 = new Manager("John", "Doe", "john@gmail.com", "123123123", "CS", "manager", 20000, 2000, "50");
            
            managerRepository.saveAll(List.of(Manager1));

            var Engineer1 = new Engineer("James", "Smith", "james@gmail.com", "111222333", "Backend", "5 years", "Java, Spring", "English, Spanish", "Gaming", "BS Computer Science");
            var Engineer2 = new Engineer("Sarah", "Johnson", "sarah@gmail.com", "444555666", "Frontend", "3 years", "JavaScript, React", "English, French", "Reading", "MS Software Engineering");
            var Engineer3 = new Engineer("Michael", "Brown", "michael@gmail.com", "777888999", "DevOps", "7 years", "Docker, Kubernetes", "English, German", "Photography", "BS Information Technology");

            engineerRepository.saveAll(List.of(Engineer1, Engineer2, Engineer3));
        } else {
            System.out.println("Data already loaded...");
        }
    }
}
