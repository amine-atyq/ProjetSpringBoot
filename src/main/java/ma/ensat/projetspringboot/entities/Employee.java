package ma.ensat.projetspringboot.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.DecimalMin;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmp;

    @Size(min = 4, max = 40, message = "Name must be between 4 and 40 characters")
    private String nomEmp;

    @Min(value = 2970, message = "Salary must be at least 1000")
    private Float salaire;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 65, message = "Age must be less than 66")
    private int age;

    @ManyToOne
    @JoinColumn(name = "departement_id") // This column references the Department
    private Departement departement;
}
