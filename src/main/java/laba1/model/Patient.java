package laba1.model;

import java.util.Objects;

public class Patient extends Entity{
    private String name;
    private Integer roomId;
    private Integer doctorId;
    private String diagnosis;

    public String getDiagnosis() {
        return diagnosis;
    }

    public Patient(Integer id, String name,Integer doctorId,
                   Integer roomId, String diagnosis) {
        this.id = id;
        this.name = name;
        this.roomId = roomId;
        this.diagnosis = diagnosis;
        this.doctorId = doctorId;
    }

    public Patient() {
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", roomId=" + roomId +
                ", doctorId=" + doctorId +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }
}
