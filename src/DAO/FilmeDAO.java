/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author Betty
 */
public class FilmeDAO extends ExecuteSQL {
    
    public FilmeDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Filme(Filme a) {
        try{
            String sql = "insert into cliente values(0,?,?,?,?,?,?)";
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getTitulo());
            ps.setInt(2, a.getAno());
            ps.setString(3, a.getDuracao());
            ps.setInt(4, a.getCod_categoria());
            ps.setInt(5, a.getCod_classificacao());
            ps.setString(6, a.getCapa());
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            } else {
                return "Erro ao inserir!";
            }
        } catch (Exception e){
            return e.getMessage();
        }
    }
    
    public List<Filme> ConsultaNomeFilme(int cod) {
        String sql = "select titulo, capa from filme where idfilme = "+ cod +"";
        List<Filme> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Filme a = new Filme();
                    a.setTitulo(rs.getString(1));
                    a.setCapa(rs.getString(2));
                    lista.add(a);
                }
                
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    } 
}
