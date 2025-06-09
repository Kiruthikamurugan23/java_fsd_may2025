package com.comp.cus.dto;



public class PatientMedicalHistoryDto {
    private String illness;
    private int numOfYears;
    private String currentMedication;

    public PatientMedicalHistoryDto() {}

    public PatientMedicalHistoryDto(String illness, int numOfYears, String currentMedication) {
        this.illness = illness;
        this.numOfYears = numOfYears;
        this.currentMedication = currentMedication;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public int getNumOfYears() {
        return numOfYears;
    }

    public void setNumOfYears(int numOfYears) {
        this.numOfYears = numOfYears;
    }

    public String getCurrentMedication() {
        return currentMedication;
    }

    public void setCurrentMedication(String currentMedication) {
        this.currentMedication = currentMedication;
    }
}
