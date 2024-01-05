package ma.ensat.projetspringboot.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.ensat.projetspringboot.entities.Departement;
import ma.ensat.projetspringboot.entities.Employee;
import ma.ensat.projetspringboot.repositories.EmployeeRepository;
import ma.ensat.projetspringboot.services.DepartementService;
import ma.ensat.projetspringboot.services.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final DepartementService departementService;
    private EmployeeRepository employeeRepository;

    @GetMapping()
    public String listEmployees(Model model,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "8") int size,
                                @RequestParam(name = "keyword", defaultValue = "") String keyword,
                                @RequestParam(name = "departmentId", required = false) Long departmentId) {
        Page<Employee> listEmployees;
        List<Departement> departments = departementService.getAllDepartements();

        if (departmentId != null) {
            Departement selectedDepartment = departementService.getDepartementById(departmentId);
            listEmployees = new PageImpl<>(employeeService.getEmployeesByDepartment(selectedDepartment));
        } else {
            listEmployees = employeeRepository.findByNomEmpContains(keyword, PageRequest.of(page, size));
        }

        model.addAttribute("listEmployees", listEmployees.getContent());
        model.addAttribute("pages", new int[listEmployees.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        model.addAttribute("departments", departments);
        model.addAttribute("selectedDepartmentId", departmentId);

        return "employees/index";
    }


    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        employeeService.deleteEmployee(id);
        redirectAttrs.addFlashAttribute("message", "Employee deleted successfully");
        return "redirect:/employees/index";
    }


    @GetMapping("/")
    public String home() {
        return "redirect:/employees/list";
    }
}
