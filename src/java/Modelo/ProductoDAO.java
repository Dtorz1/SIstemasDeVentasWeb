/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DIDIER
 */
public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Producto buscar(int id) {
        Producto p = new Producto();
        String sql = "select * from producto where IdProducto= " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPre(rs.getString(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));

            }
        } catch (Exception e) {
            System.out.println("error buscar producto: "+e.getMessage());
        }
        return p;
    }

    public int actualizarstock(int id, int stock) {
        String sql = "update producto set Stock=? where idproducto=?" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
             System.out.println("error actualizar producto: "+e.getMessage());
        }
        return r;
    }
//    CRUD

    public List<Producto> listar() {
        String sql = "select * from producto";
        List<Producto> lista = new ArrayList<Producto>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPre(rs.getString(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
                lista.add(p);
            }
        } catch (Exception e) {
             System.out.println("error listar producto: "+e.getMessage());
        }
        return lista;
    }

    public int agregar(Producto p) {
        String sql = "insert into producto(Nombres, Precio, Stock, Estado)values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPre());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.executeUpdate();

        } catch (Exception e) {
             System.out.println("error agregar producto: "+e.getMessage());
        }
        return r;
    }

    public Producto ListarId(int id) {
        Producto p = new Producto();
        String sql = "select * from producto where IdProducto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setNom(rs.getString(2));
                p.setPre(rs.getString(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));

            }
        } catch (Exception e) {
             System.out.println("error listr id producto: "+e.getMessage());
        }
        return p;
    }

    public int actualizar(Producto p) {

        String sql = "update producto set Nombres=?, Precio=?, Stock=?, Estado=? where IdProducto=?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPre());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.setInt(5, p.getId());
            ps.executeUpdate();

        } catch (Exception e) {
             System.out.println("error actualizar p producto: "+e.getMessage());
        }
        return r;
    }

    public void delete(int id) {
        String sql = "delete from producto where IdProducto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
             System.out.println("error borrar producto: "+e.getMessage());
        }
    }
}
