package odk.apprenent.demoEntityBD.repository;

import odk.apprenent.demoEntityBD.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées ici
}
