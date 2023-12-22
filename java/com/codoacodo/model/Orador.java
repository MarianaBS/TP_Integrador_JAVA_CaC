/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codoacodo.model;
import java.sql.Timestamp;

/**
 *
 * @author Marian
 */
public class Orador{    
     //Definimos variables
    private int id;
    private String nombre;
    private String apellido;
    private String mail;
    private String tema;
    private Timestamp fechaAlta;
    
    //Constructor Vacío
    public Orador(){}
        
    //orador con id y timestamp para visualizar registros(select)
    public Orador(int i, String n, String a, String m, String t, Timestamp ts ) {
        this.id = i;
        this.nombre = n;
        this.apellido = a;
        this.mail = m;
        this.tema = t;
        this.fechaAlta = ts;
    }
    
    //orador sin id ni timestamp creado para insertar un orador en la db
    public Orador(String n, String a , String m, String t) {
        this.nombre = n;
        this.apellido = a;
        this.mail = m;
        this.tema = t;
    }
        public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Timestamp getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Timestamp fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
   // @Override
   // public String toString() {
   //     return super.toString() + "Orador{" + "tema=" + tema + " - Fecha de Alta=" + fechaAlta +'}';
    //}   
    
}


