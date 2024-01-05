package ma.ensat.projetspringboot.controller;

import ma.ensat.projetspringboot.entities.Departement;
import ma.ensat.projetspringboot.entities.Employee;
import ma.ensat.projetspringboot.services.DepartementService;
import ma.ensat.projetspringboot.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/departements")
public class DepartementController {

    @Autowired
    private DepartementService departementService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String listDepartements(Model model) {
        List<Departement> departements = departementService.getAllDepartements();
        model.addAttribute("departements", departements);
        return "departements/list";
    }

    @GetMapping("/view/{id}")
    public String viewDepartment(@PathVariable Long id, Model model) {
        Departement department = departementService.getDepartementById(id);
        List<Employee> employees = employeeService.getEmployeesByDepartment(department);
        model.addAttribute("department", department);
        model.addAttribute("employees", employees);
        return "departements/view-employees";
    }


    @GetMapping("/add")
    public String addDepartementForm(Model model) {
        model.addAttribute("departement", new Departement());
        return "departements/add";
    }

    @PostMapping("/add")
    public String addDepartement(@ModelAttribute Departement departement) {
        departementService.saveDepartement(departement);
        return "redirect:/departements";
    }

    @GetMapping("/edit/{id}")
    public String editDepartementForm(@PathVariable Long id, Model model) {
        Departement departement = departementService.getDepartementById(id);
        model.addAttribute("departement", departement);
        return "departements/edit";
    }


    @PostMapping("/edit")
    public String editDepartement(@ModelAttribute Departement departement, Model model) {
        // Logic to update the departement
        departementService.updateDepartement(departement);
        return "redirect:/departements"; // Redirect to the departements list after editing
    }


    @GetMapping("/delete/{id}")
    public String deleteDepartement(@PathVariable Long id) {
        departementService.deleteDepartement(id);
        return "redirect:/departements";
    }
    /*

    @GetMapping("/search")
    public String searchDepartementsForm(Model model) {
        model.addAttribute("departement", new Departement());
        return "departements/search";
    }

    @PostMapping("/search")
    public String searchDepartements(@ModelAttribute Departement departement, Model model) {
        List<Departement> result = departementService.searchDepartements(departement.getNomDept());
        model.addAttribute("result", result);
        return "departements/search-result";
    }
    */

}
