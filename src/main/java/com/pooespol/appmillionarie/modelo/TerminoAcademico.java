/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.appmillionarie.modelo;

import java.io.Serializable;
import java.util.Objects;
import java.io.*;

/**
 *
 * @author Gustavo
 */
public class TerminoAcademico implements Serializable  {
    private static final long serialVersionUID = 2778396492389753943L;
    private String year;
    private String numeroTermino;
    
    public TerminoAcademico(String year, String numeroTermino){
        this.year=year;
        this.numeroTermino=numeroTermino;
    }
    
    public String getYear(){
        return this.year;
    }
    public String getNumeroTermino(){
        return this.numeroTermino;
    }
    public String toSting(){
        return "Termino Academico {"+"Año"+year+", numero de Termino "+numeroTermino+" }";
    }
    
    public String escribirLinea() {
        return  year + ";" + numeroTermino ;
    }

    /*public int compareTo(TerminoAcademico o) {
        
        return year.compareToIgnoreCase(o.year);
    }
    */
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.year);
        return hash;
    }
    
    /*@Override
    public boolean equals(Object obj){
        if(this==obj){
        return true;
        }
        if(obj!=null && getClass()==obj.getClass()){
            TerminoAcademico other = (TerminoAcademico)obj;
            return year.equalsIgnoreCase(other.year);
        }
        if(obj!=null && getClass()==obj.getClass()){
            TerminoAcademico other = (TerminoAcademico)obj;
            return numeroTermino.equalsIgnoreCase(other.numeroTermino);
        }
        return false;
    }
   
    */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TerminoAcademico other = (TerminoAcademico) obj;
        if (!Objects.equals(this.year, other.year)) {
            return false;
        }
        if (!Objects.equals(this.numeroTermino, other.numeroTermino)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
