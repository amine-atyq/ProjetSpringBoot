package ma.ensat.projetspringboot.services;

import lombok.AllArgsConstructor;
import ma.ensat.projetspringboot.entities.Departement;
import ma.ensat.projetspringboot.entities.Employee;
import ma.ensat.projetspringboot.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeService {


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private final EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Page<Employee> findEmployeesByKeyword(String keyword, Pageable pageable) {
        return employeeRepository.findByNomEmpContains(keyword, pageable);
    }
    public List<Employee> getEmployeesByDepartment(Departement department) {
        // Assuming Employee entity has a reference to the department
        return employeeRepository.findByDepartement(department);
    }
}
