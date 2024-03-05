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
public class Producto {

    Integer Id;
    String Nom;
    String Pre;
    Integer Stock;
    String Estado;

    public Producto() {
    }

    public Producto(Integer Id, String Nom, String Pre, Integer Stock, String Estado) {
        this.Id = Id;
        this.Nom = Nom;
        this.Pre = Pre;
        this.Stock = Stock;
        this.Estado = Estado;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPre() {
        return Pre;
    }

    public void setPre(String Pre) {
        this.Pre = Pre;
    }

    public Integer getStock() {
        return Stock;
    }

    public void setStock(Integer Stock) {
        this.Stock = Stock;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    
}
