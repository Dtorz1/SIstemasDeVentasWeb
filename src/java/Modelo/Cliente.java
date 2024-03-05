/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author DIDIER
 */
public class Cliente {

    Integer id;
    String dni;
    String Nom;
    String Dir;
    String Est;

    public Cliente() {

    }

    public Cliente(Integer id, String dni, String Nom, String Dir, String Est) {
        this.id = id;
        this.dni = dni;
        this.Nom = Nom;
        this.Dir = Dir;
        this.Est = Est;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getDir() {
        return Dir;
    }

    public void setDir(String Dir) {
        this.Dir = Dir;
    }

    public String getEst() {
        return Est;
    }

    public void setEst(String Est) {
        this.Est = Est;
    }

}
