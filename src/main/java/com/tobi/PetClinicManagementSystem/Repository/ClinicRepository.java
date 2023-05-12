package com.tobi.PetClinicManagementSystem.Repository;

import com.tobi.PetClinicManagementSystem.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends JpaRepository<Client, Long> {
    Boolean  existsByPetName(String petName);


    Client findByPetName(String ownersName);

}
