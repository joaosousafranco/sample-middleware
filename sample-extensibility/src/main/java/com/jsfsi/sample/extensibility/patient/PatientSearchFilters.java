package com.jsfsi.sample.extensibility.patient;

import com.jsfsi.sample.extensibility.BaseModel;

public class PatientSearchFilters extends BaseModel {
    private String clientName;
    private String clientNumber;
    private String pacientName;
    private String pacientNumber;
    private String pacientState;
    private String specie;
    private String cardNumber;
    private String chip;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getPacientName() {
        return pacientName;
    }

    public void setPacientName(String pacientName) {
        this.pacientName = pacientName;
    }

    public String getPacientNumber() {
        return pacientNumber;
    }

    public void setPacientNumber(String pacientNumber) {
        this.pacientNumber = pacientNumber;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getPacientState() {
        return pacientState;
    }

    public void setPacientState(String pacientState) {
        this.pacientState = pacientState;
    }
}
