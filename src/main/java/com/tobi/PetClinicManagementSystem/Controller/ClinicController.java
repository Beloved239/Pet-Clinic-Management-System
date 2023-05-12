package com.tobi.PetClinicManagementSystem.Controller;

import com.tobi.PetClinicManagementSystem.DTO.ClinicRequest;
import com.tobi.PetClinicManagementSystem.Entity.Client;
import com.tobi.PetClinicManagementSystem.Exceptions.RecordNotFoundException;
import com.tobi.PetClinicManagementSystem.Service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinic")
public class ClinicController {
    @Autowired
    ClinicService clinicService;

    @PostMapping
    public ClinicRequest createNewClient(@RequestBody ClinicRequest petRequest){
        return clinicService.createPet(petRequest);
    }



    @GetMapping
    public List<Client> getAllClient(){
        return clinicService.getAllPetClient();
    }


    @PutMapping("/{petId}")
    public ResponseEntity<Client> updateRecord(@PathVariable(value = "petId") Long id, @RequestBody ClinicRequest petRequest){
        try {
            return new ResponseEntity<>(clinicService.updateRecord(id, petRequest), HttpStatus.ACCEPTED);
        } catch (RecordNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/{petId}")
    public ResponseEntity<Client> fetchPetById(@PathVariable(value = "petId") Long id){
        try {
            return new ResponseEntity<>(clinicService.getPetById(id), HttpStatus.ACCEPTED);
        }catch (RecordNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/petName")
    public ResponseEntity<Client> fetchRecordByName(@RequestParam(value = "petName", required = true)String petName){
       try {
           return new ResponseEntity<>(clinicService.getRecordByName(petName), HttpStatus.ACCEPTED);
       } catch (RecordNotFoundException ex) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//           return ResponseEntity.badRequest().body("Record not found");
       }
    }

    @DeleteMapping("/{petId}")
    public ResponseEntity<String> deleteRecord(@PathVariable(value = "petId" )Long id){
        try {
            return new ResponseEntity<>(clinicService.deleteRecord(id),HttpStatus.ACCEPTED);
        } catch (RecordNotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return ResponseEntity.badRequest().body("Record not found");
        }
    }


}
