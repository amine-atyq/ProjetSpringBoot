package ma.ensat.projetspringboot.services;

import ma.ensat.projetspringboot.entities.Departement;
import ma.ensat.projetspringboot.repositories.DepartementRepository;
import ma.ensat.projetspringboot.services.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementServiceImpl implements DepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Departement getDepartementById(Long id) {
        return departementRepository.findById(id).orElse(null);
    }
    @Override
    public void updateDepartement(Departement departement) {
        departementRepository.save(departement);
    }

    @Override
    public void saveDepartement(Departement departement) {
        departementRepository.save(departement);
    }

    @Override
    public void deleteDepartement(Long id) {
        departementRepository.deleteById(id);
    }

    @Override
    public Departement findByNomDept(String nomDept) {
        return departementRepository.findByNomDept(nomDept);
    }
    @Override
    public List<Departement> searchDepartements(String keyword) {
        return departementRepository.findByNomDeptContainingIgnoreCase(keyword);
    }
}
