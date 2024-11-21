package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    // Custom query methods (for example, find by name)
    Organization findByName(String name);
}