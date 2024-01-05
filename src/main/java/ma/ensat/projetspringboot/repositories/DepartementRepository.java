package ma.ensat.projetspringboot.repositories;

import ma.ensat.projetspringboot.entities.Departement;
import ma.ensat.projetspringboot.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Long> {
    Departement findByNomDept(String nomDept);
    List<Departement> findByNomDeptContainingIgnoreCase(String keyword);
}
