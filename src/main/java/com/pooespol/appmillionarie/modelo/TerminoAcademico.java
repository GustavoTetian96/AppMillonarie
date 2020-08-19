/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.appmillionarie.modelo;

import java.io.Serializable;

/**
 *
 * @author Gustavo
 */
public class TerminoAcademico implements Serializable  {
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
    
    
}
