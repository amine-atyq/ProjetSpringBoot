package ma.ensat.projetspringboot;

import ma.ensat.projetspringboot.entities.Departement;
import ma.ensat.projetspringboot.entities.Employee;
import ma.ensat.projetspringboot.repositories.DepartementRepository;
import ma.ensat.projetspringboot.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetSpringBootApplication  {

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

//    private final String[] realNames = {"Ethan", "Ava", "Noah", "Sophia", "Liam", "Olivia", "Mason", "Emma", "Lucas", "Isabella"};

    public static void main(String[] args) {
        SpringApplication.run(ProjetSpringBootApplication.class, args);
    }



//    public void run(String... args) throws Exception {
//        // Retrieve the "Research and Development" department from the database
//        Departement rAndDDepartment = departementRepository.findByNomDept("Research and Development");
//
//        if (rAndDDepartment == null) {
//            System.out.println("Error: The 'Research and Development' department not found.");
//            return;
//        }
//
//        // Add 10 employees to "Research and Development" with real names
//        for (int i = 0; i < realNames.length; i++) {
//            Employee employee = new Employee();
//            employee.setNomEmp(realNames[i] + " - Research and Development");
//            employee.setSalaire(Float.valueOf((float)(75000.0 + i * 1000)));
//            employee.setAge(32 + i); // Incrementing age for each employee
//            employee.setDepartement(rAndDDepartment);
//            employeeRepository.save(employee);
//        }
//
//        System.out.println("Added 10 employees with real names to the 'Research and Development' department.");
//    }
}
