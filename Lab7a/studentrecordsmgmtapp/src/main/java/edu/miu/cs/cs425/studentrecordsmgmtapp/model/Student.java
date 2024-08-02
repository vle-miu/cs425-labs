package edu.miu.cs.cs425.studentrecordsmgmtapp.model;

import java.time.LocalDate;

public class Student {

    private Long studentId;

    private String name;

    private LocalDate dateOfAdmission;

    public Student(Long studentId, String name, LocalDate dateOfAdmission) {
        this.studentId = studentId;
        this.name = name;
        this.dateOfAdmission = dateOfAdmission;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(LocalDate dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    @Override
    public String toString() {
        return "[ studentId = " + studentId + ", name = " + name + ", dateOfAdmission = " + dateOfAdmission + "]";
    }
}
