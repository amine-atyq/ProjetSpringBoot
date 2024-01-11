package ma.ensat.projetspringboot.services;

import ma.ensat.projetspringboot.repositories.DepartementRepository;
import ma.ensat.projetspringboot.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartementRepository departementRepository;

    // Method to calculate total number of employees
    public Long getTotalNumberOfEmployees() {
        return employeeRepository.count();
    }

    // Add other methods for different statistics...
}
