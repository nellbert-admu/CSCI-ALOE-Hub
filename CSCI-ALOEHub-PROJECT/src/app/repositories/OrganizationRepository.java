package app.repositories;

import app.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    // You can add custom query methods if needed
    Organization findByName(String name);  // Example: Find Organization by name
}