package com.tobi.PetClinicManagementSystem.Util;

import java.util.Random;

public class PetIdGenerator {

    public static String generatePetCode(){

        Random random = new Random();
        int from = 1111;
        int to = 9999;
        int randomNumber = (int)Math.floor(Math.random()*(to-from+1)+from);

        return "PET/" + randomNumber;
    }

    public static void main(String[] args) {
        System.out.println(generatePetCode());
    }


}
