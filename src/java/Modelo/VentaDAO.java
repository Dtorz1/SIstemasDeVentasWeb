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

/**
 *
 * @author DIDIER
 */
public class VentaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public String GenerarSerie() {
        String numeroserie = "";
        String sql = "select max(NumeroSerie) from ventas";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                numeroserie = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("error generar serie venta"+e.getMessage());
        }
        return numeroserie;
    }

    public String IdVentas() {
        String idventas = "";
        String sql = "select max (IdVentas) from ventas";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                idventas = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("error select max=" +e.getMessage());
        }
        return idventas;
    }

    public int guardarVenta(Venta ve) {
        String sql = "insert into ventas (IdCliente,IdEmpleado,NumeroSerie,FechaVentas,Monto,Estado) values(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ve.getIdcliente());
            ps.setInt(2, ve.getIdempleado());
            ps.setString(3, ve.getNumserie());
            ps.setString(4, ve.getFecha());
            ps.setDouble(5, ve.getPrecio());
            ps.setString(6, ve.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error guardar venta ="+e.getMessage());
        }
        return r;
    }

    public int guardarDetalleVentas(Venta venta) {
        String sql = "insert into detalle_ventas (IdVentas,IdProducto,Cantidad,PrecioVenta) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, venta.getId());
            ps.setInt(2, venta.getIdproducto());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecio());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error guardar detalle venta "+e.getMessage());
        }
        return r;
    }

}
