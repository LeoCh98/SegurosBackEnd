/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.segurosbackend.logic;

import java.util.Objects;

/**
 *
 * @author leoch
 */
public class User {

    private String cedula;
    private String clave;
    private int tipo;

    public User() {
    }

    public User(String cedula, String clave, int tipo) {
        this.cedula = cedula;
        this.clave = clave;
        this.tipo = tipo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getRol() {
        switch(this.tipo) {
            case 0:
                return "ADM";
            case 1:
                return "CLI";
        }
        return "";// Default
    }

    @Override
    public String toString() {
        return "Username=" + cedula + " Password=" + clave;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.cedula);
        hash = 37 * hash + Objects.hashCode(this.clave);
        hash = 37 * hash + this.tipo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User other = (User) obj;
        return Objects.equals(this.cedula, other.cedula)
                && Objects.equals(this.clave, other.clave);
    }

}
