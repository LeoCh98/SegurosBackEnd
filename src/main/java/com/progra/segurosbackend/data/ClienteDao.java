/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.segurosbackend.data;

import com.progra.segurosbackend.logic.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leoch
 */
public class ClienteDao {

    RelDatabase db;

    public ClienteDao(RelDatabase db) {
        this.db = db;
    }

    public Client read(String cedula) throws Exception {
        String sql = "select "
                + "* "
                + "from Cliente c inner join Usuario u on c.usuario=u.cedula "
                + "where c.cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cedula);
        ResultSet rs = db.executeQuery(stm);
        UsuarioDao usuarioDao = new UsuarioDao(db);
        Client c;
        if (rs.next()) {
            c = from(rs, "c");
            c.setUsuario(usuarioDao.from(rs, "u"));
            return c;
        } else {
            throw new Exception("Cliente no existe");
        }
    }

    public Client from(ResultSet rs, String alias) {
        try {
            Client c = new Client();
            c.setNombre(rs.getString(alias + ".nombre"));
            c.setCedula(rs.getString(alias + ".cedula"));
            c.setTarjeta(rs.getInt(alias + ".tarjeta"));
            c.setTelefono(rs.getString(alias + ".telefono"));
            c.setCorreo(rs.getString(alias + ".correo"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void update(Client e) throws Exception {
        String sql = "update "
                + "Cliente "
                + "set nombre=?, "
                + "telefono=?, "
                + "correo=? "
                + "where cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, e.getNombre());
        stm.setString(2, e.getTelefono());
        stm.setString(3, e.getCorreo());
        stm.setString(4, e.getCedula());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cliente no existe");
        }
    }

    public void write(Client c) throws Exception {
        String sql = "insert into Cliente (nombre, cedula, tarjeta, telefono, correo, usuario) "
                + "values (?, ?, ?, ?, ?, ?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getNombre());
        stm.setString(2, c.getCedula());
        stm.setInt(3, c.getTarjeta());
        stm.setString(4, c.getTelefono());
        stm.setString(5, c.getCorreo());
        stm.setString(6, c.getCedula());
        int count = stm.executeUpdate();
        if (count == 0) {
            throw new Exception("Cliente no insertado");
        }
    }

    public List<Client> findAll() throws Exception {
        List<Client> clients = new ArrayList<>();
        try {
            String sql = "select * from Cliente c inner join Usuario u on c.usuario=u.cedula";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            UsuarioDao usuarioDao = new UsuarioDao(db);
            while (rs.next()) {
                Client c = from(rs, "c");
                c.setUsuario(usuarioDao.from(rs, "u"));
                clients.add(c);
            }
        } catch (SQLException ex) {
            throw new Exception("Clientes no insertados", ex);
        }
        return clients;
    }

}
