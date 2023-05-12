package com.tobi.PetClinicManagementSystem.DTO;

import lombok.Data;

@Data
public class ClinicRequest {

    private String ownersName;
    private String address;
    private String city;
    private String phoneNumber;
    private String petName;
    private String petId;

}
