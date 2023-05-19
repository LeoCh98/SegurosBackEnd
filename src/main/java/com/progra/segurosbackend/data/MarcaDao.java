/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.segurosbackend.data;

import com.progra.segurosbackend.logic.Marca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author leoch
 */
public class MarcaDao {

    RelDatabase db;

    public MarcaDao(RelDatabase db) {
        this.db = db;
    }

    public Marca read(String id) throws Exception {
        String sql = "select "
                + "* "
                + "from  Marca b "
                + "where b.idMarca=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            return from(rs, "b");
        } else {
            throw new Exception("Marca no existe");
        }
    }

    public Marca from(ResultSet rs, String alias) {
        try {
            Marca b = new Marca();
            b.setNombre(rs.getString(alias + ".nombre"));
            b.setId(rs.getInt(alias + ".idMarca"));
            return b;
        } catch (SQLException ex) {
            return null;
        }
    }
}
