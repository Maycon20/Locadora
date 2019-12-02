/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.*;
import DAO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Betty
 */
public class AlugelDAO extends ExecuteSQL {
    
    public AlugelDAO(Connection con) {
        super(con);
    }
    public String Inserir_Alugel(Aluguel a) {
        try{
           
            String sql = "insert into aluguel values(0,?,?,?,?,?)";
            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setInt(1, a.getCoddvd());
            ps.setDouble(2, a.getCodcliente());
            ps.setString(3, a.getHorario());
            ps.setString(4, a.getData_aluguel());
            ps.setString(5, a.getData_devolucao());

            if (ps.executeUpdate() > 0) {

                return "Inserido com sucesso!";

            } else {

                return "Erro ao inserir";

            }

        } catch (SQLException e) {

            return e.getMessage();

        }

    }     
}
