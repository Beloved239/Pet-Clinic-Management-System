package com.tobi.PetClinicManagementSystem.Service;

import com.tobi.PetClinicManagementSystem.DTO.ClinicRequest;
import com.tobi.PetClinicManagementSystem.Entity.Client;
import com.tobi.PetClinicManagementSystem.Exceptions.RecordNotFoundException;

import java.util.List;

public interface ServiceUtil {
    public ClinicRequest createPet(ClinicRequest petRequest);
    public List<Client> getAllPetClient();
    public Client getPetById(Long id) throws RecordNotFoundException;
    public Client updateRecord(Long id, ClinicRequest petRequest) throws RecordNotFoundException;
    public Client getRecordByName(String petName) throws RecordNotFoundException;
    public String deleteRecord(Long id) throws RecordNotFoundException;
}
