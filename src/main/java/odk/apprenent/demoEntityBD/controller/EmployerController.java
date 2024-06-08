package odk.apprenent.demoEntityBD.controller;

import odk.apprenent.demoEntityBD.entity.Employer;
import odk.apprenent.demoEntityBD.repository.EmployerRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
@Tag(name = "Employer", description = "API for managing employers")
public class EmployerController {

    @Autowired
    private EmployerRepository employerRepository;

    @GetMapping
    @Operation(summary = "Get all employers")
    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get employer by ID")
    public ResponseEntity<Employer> getEmployerById(@PathVariable int id) {
        return employerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new employer")
    public Employer createEmployer(@RequestBody Employer employer) {
        return employerRepository.save(employer);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing employer")
    public ResponseEntity<Employer> updateEmployer(@PathVariable int id, @RequestBody Employer employer) {
        return employerRepository.findById(id)
                .map(existingEmployer -> {
                    existingEmployer.setName(employer.getName());
                    existingEmployer.setAddress(employer.getAddress());
                    existingEmployer.setPhone(employer.getPhone());
                    existingEmployer.setDepartement(employer.getDepartement());
                    return ResponseEntity.ok(employerRepository.save(existingEmployer));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an employer by ID")
    public ResponseEntity<Object> deleteEmployer(@PathVariable int id) {
        return employerRepository.findById(id)
                .map(employer -> {
                    employerRepository.delete(employer);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
