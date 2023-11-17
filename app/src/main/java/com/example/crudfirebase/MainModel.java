package com.example.crudfirebase;
public class MainModel {
    String Nombre, Apellido, Email, ImgURL;
    public MainModel(){

    }

    public MainModel(String nombre, String apellido, String email, String imgURL) {
        Nombre = nombre;
        Apellido = apellido;
        this.Email = email;
        this.ImgURL = imgURL;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getImgURL() {
        return ImgURL;
    }

    public void setImgURL(String imgURL) {
        ImgURL = imgURL;
    }
}