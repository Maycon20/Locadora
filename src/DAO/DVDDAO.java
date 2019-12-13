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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Betty
 */
public class DVDDAO extends ExecuteSQL {
    
    public DVDDAO(Connection con) {
        super(con);
    }
     public String Inserir_DVD(DVD a) {
        try{
            String sql = "insert into dvd values(0,?,?,?,?)";
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setInt(1, a.getCod_filme());
            ps.setDouble(2, a.getPreco());
            ps.setString(3, a.getData_compra());           
            ps.setString(4, a.getSituacao());
                            
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            } else {
                return "Erro ao inserir!";
            }
        } catch (Exception e){
            return e.getMessage();
        }
    }     
<<<<<<< HEAD
     public List<DVD> ListarComboDVD() {
        String sql = "select nome from dvd order by nome";
        List<DVD> lista = new ArrayList<>();

        try {
=======

     public boolean Testar_DVD(int cod) {
        boolean Resultado = false;
        
        try {
            String sql = "select * from dvd where iddvd = "+ cod +"";
>>>>>>> f9bb64c63430d3e5d1c8c9b624fae198829b240a
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
<<<<<<< HEAD
                while (rs.next()) {
                    DVD a = new DVD();
                    a.setSituacao(rs.getString(1));
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
     
         public String Excluir_DVD(DVD a){
        String sql = "delete from dvd where idfilme = ?";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCod_filme());
            
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso";
            } else {
                return "Erro ao excluir";
            }
        } catch (SQLException e) {

            return e.getMessage();

        }
    }
  public boolean Teste_DVD(int cod) {
        boolean teste = false;
        try {
            String sql = "select iddvd from dvd where iddvd = "+ cod +"";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();   
            
            if (rs != null) {
                
                while (rs.next()) {
                    teste = true;
                }
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return teste;
  }  
  
    public boolean Testar_Situacao(int cod) {
        boolean teste = false;
        try {
            String sql = "select iddvd from dvd where iddvd = "+ cod +" and situacao = 'Disponivel'";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();   
            
            if (rs != null) {
                
                while (rs.next()) {
                    teste = true;
                }
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return teste;
    }
=======
                
                while (rs.next()) {
                    Resultado = true;
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return Resultado;
    }
    
    public List<DVD> CapturarDVD(int cod){
        String sql = "select * from dvd where iddvd = "+ cod +"";
        List<DVD> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    DVD a = new DVD();
                    
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setPreco(rs.getDouble(3));
                    a.setData_compra(rs.getString(4));
                    a.setSituacao(rs.getString(5));
                    
                    lista.add(a);
                }
                
                return lista;
                
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }
    
    public String Alterar_DVD(DVD a) {
        String sql = "update dvd set idfilme = ? ,preco_compra = ? ,data_compra = ? ,situacao = ? where iddvd = ? ";
        
                try {
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCod_filme());
            ps.setDouble(2, a.getPreco());
            ps.setString(3, a.getData_compra());
            ps.setString(4, a.getSituacao());
                ps.setInt(5, a.getCodigo());
            
            if (ps.executeUpdate() > 0) {
                return "Atualizado com sucesso!";
            } else {
                return "Erro ao Atualizar!";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
     
>>>>>>> f9bb64c63430d3e5d1c8c9b624fae198829b240a
}
