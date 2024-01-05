package ma.ensat.projetspringboot.services;

import lombok.AllArgsConstructor;
import ma.ensat.projetspringboot.entities.Departement;
import ma.ensat.projetspringboot.repositories.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface DepartementService {

    List<Departement> getAllDepartements();

    Departement getDepartementById(Long id);

    void updateDepartement(Departement departement);

    void saveDepartement(Departement departement);

    void deleteDepartement(Long id);

    Departement findByNomDept(String nomDept);
    List<Departement> searchDepartements(String keyword);




}
