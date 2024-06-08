package odk.apprenent.demoEntityBD.repository;

import odk.apprenent.demoEntityBD.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {
    // Vous pouvez ajouter des méthodes de requête personnalisées ici
}
