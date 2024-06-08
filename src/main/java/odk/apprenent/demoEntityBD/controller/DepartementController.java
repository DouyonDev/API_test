package odk.apprenent.demoEntityBD.controller;

import odk.apprenent.demoEntityBD.entity.Departement;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import odk.apprenent.demoEntityBD.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@Tag(name = "Department", description = "API for managing departments")
public class DepartementController {

    @Autowired
    private DepartementRepository departementRepository;

    @GetMapping
    @Operation(summary = "Get all departments")
    public List<Departement> getAllDepartments() {
        return departementRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get department by ID")
    public ResponseEntity<Departement> getDepartmentById(@PathVariable Long id) {
        return departementRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new department")
    public Departement createDepartment(@RequestBody Departement departement) {
        return departementRepository.save(departement);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing department")
    public ResponseEntity<Departement> updateDepartment(@PathVariable Long id, @RequestBody Departement departement) {
        return departementRepository.findById(id)
                .map(existingDepartment -> {
                    existingDepartment.setNom(departement.getNom());
                    return ResponseEntity.ok(departementRepository.save(existingDepartment));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a department by ID")
    public ResponseEntity<Object> deleteDepartment(@PathVariable Long id) {
        return departementRepository.findById(id)
                .map(department -> {
                    departementRepository.delete(department);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
