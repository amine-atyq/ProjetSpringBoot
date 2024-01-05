package ma.ensat.projetspringboot.repositories;

import ma.ensat.projetspringboot.entities.Departement;
import ma.ensat.projetspringboot.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findByNomEmpContains(String kw, Pageable pageable);
    List<Employee> findByDepartement(Departement department);
}
