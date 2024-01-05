package ma.ensat.projetspringboot.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDept;

    @NotEmpty(message = "Department name must not be empty")
    private String nomDept;

    @OneToMany(mappedBy = "departement", fetch = FetchType.LAZY)
    private List<Employee> employees;



}
