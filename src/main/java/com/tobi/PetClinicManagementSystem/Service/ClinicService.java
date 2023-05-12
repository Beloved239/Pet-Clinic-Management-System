package com.tobi.PetClinicManagementSystem.Service;

import com.tobi.PetClinicManagementSystem.DTO.ClinicRequest;
import com.tobi.PetClinicManagementSystem.Entity.Client;
import com.tobi.PetClinicManagementSystem.Exceptions.RecordNotFoundException;
import com.tobi.PetClinicManagementSystem.Repository.ClinicRepository;
import com.tobi.PetClinicManagementSystem.Util.PetIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicService implements ServiceUtil {
    @Autowired
    ClinicRepository clinicRepository;

    public ClinicRequest createPet(ClinicRequest petRequest) {
        Client petClinic = new Client();

        petClinic.setPetName(petRequest.getPetName());
        petClinic.setPetId(PetIdGenerator.generatePetCode());
        petClinic.setCity(petRequest.getCity());
        petClinic.setAddress(petRequest.getAddress());
        petClinic.setPhoneNumber(petRequest.getPhoneNumber());
        petClinic.setOwnersName(petRequest.getOwnersName());

        ClinicRequest response = new ClinicRequest();

        Client savedPet = clinicRepository.save(petClinic);
        response.setPetName(savedPet.getPetName());
        response.setAddress(savedPet.getAddress());
        response.setCity(savedPet.getCity());
        response.setPhoneNumber(savedPet.getPhoneNumber());
        response.setPetId(savedPet.getPetId());
        response.setOwnersName(savedPet.getOwnersName());

        return response;
    }

    public List<Client> getAllPetClient(){
        return clinicRepository.findAll();
    }

    public Client getPetById(Long id) throws RecordNotFoundException {
//        PetClinic response = clinicRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("Record not found"));
//        clinicRepository.findById(id).orElseThrow();
        return clinicRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("Record not found"));
    }

    public Client updateRecord(Long id, ClinicRequest petRequest) throws RecordNotFoundException {

        Client response = clinicRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("Record not found"));
//        Optional<PetClinic> isPresent= clinicRepository.findById(id);

        if (clinicRepository.existsById(id)) {
            response.setOwnersName(petRequest.getOwnersName());
            response.setAddress(petRequest.getAddress());
            response.setCity(petRequest.getCity());
            response.setPhoneNumber(petRequest.getPhoneNumber());
            response.setPetName(petRequest.getPetName());
            return response;
        }else {
            throw new RecordNotFoundException("Record not found");
        }
    }

    public Client getRecordByName(String petName) throws RecordNotFoundException {
        Boolean isExist = clinicRepository.existsByPetName(petName);

        if (isExist){
            return clinicRepository.findByPetName(petName);
        }else
            throw new RecordNotFoundException("Record not found");
    }

    public String deleteRecord(Long id) throws RecordNotFoundException {
        Client petClinic = clinicRepository.findById(id).orElseThrow(()->new RecordNotFoundException("Record not found"));
        clinicRepository.deleteById(id);
        return id + " Deleted Successfully";
    }







}
