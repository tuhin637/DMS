package com.mycompany.dms;

public class Checkup {
    private Doctor dcotor;
    private Patient patient;
    private int Priority;
    private String Recomendation,Date;

    public Checkup() {
    }

    public Checkup(Doctor dcotor, Patient patient, int Priority, String Recomendation, String Date) {
        this.dcotor = dcotor;
        this.patient = patient;
        this.Priority = Priority;
        this.Recomendation = Recomendation;
        this.Date = Date;
    }

    public Doctor getDcotor() {
        return dcotor;
    }

    public void setDcotor(Doctor dcotor) {
        this.dcotor = dcotor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getPriority() {
        return Priority;
    }

    public void setPriority(int Priority) {
        this.Priority = Priority;
    }

    public String getRecomendation() {
        return Recomendation;
    }

    public void setRecomendation(String Recomendation) {
        this.Recomendation = Recomendation;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "Checkup{" + "dcotor=" + dcotor.toString() + ", patient=" + patient.toString() + ", Priority=" + Priority + ", Recomendation=" + Recomendation + ", Date=" + Date + '}';
    }

    
}
