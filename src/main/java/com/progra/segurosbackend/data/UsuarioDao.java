/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.segurosbackend.data;

import com.progra.segurosbackend.logic.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author leoch
 */
public class UsuarioDao {

    RelDatabase db;

    public UsuarioDao(RelDatabase db) {
        this.db = db;
    }

    public User read(String cedula) throws Exception {
        String sql = "select "
                + "* "
                + "from  Usuario u "
                + "where u.cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cedula);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            return from(rs, "u");
        } else {
            throw new Exception("Usuario no existe");
        }
    }

    public User from(ResultSet rs, String alias) {
        try {
            User u = new User();
            u.setCedula(rs.getString(alias + ".cedula"));
            u.setClave(rs.getString(alias + ".clave"));
            u.setTipo(rs.getInt(alias + ".tipo"));
            return u;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void write(User u) throws Exception {
        String sql = "insert into Usuario (cedula, clave, tipo) "
                + "values (?, ?, ?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getCedula());
        stm.setString(2, u.getClave());
        stm.setInt(3, 1); //Solo se ingresaran tipo clientes a la base
        int count = stm.executeUpdate();
        if (count == 0) {
            throw new Exception("Usuario no insertado");
        }
    }
}
