package com.example.demoMicro.model;

public class Instructor {

    private Integer instructorId;


    private String nombre;


    private String apellidos;


    private Double salario;

    public Instructor() {
    }

    public Instructor(Integer instructorId, String nombre, String apellidos, Double salario) {
        this.instructorId = instructorId;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.salario = salario;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
