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
public class ClassificacaoDAO extends ExecuteSQL {

    public ClassificacaoDAO(Connection con) {
        super(con);

    }
     public String Inserir_Classificacao(Classificacao a) {
        try{
            String sql = "insert into classificacao values(0,?,?)";
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setDouble(2, a.getPreco());
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            } else {
                return "Erro ao inserir!";
            }
        } catch (Exception e){
            return e.getMessage();
        }
<<<<<<< HEAD
    }  
     
  public List<Classificacao> LisarComboClassificacao() {
        String sql = "select nome from classificacao";
        List<Classificacao> lista = new ArrayList<>();

        try {
=======
    }     

      public boolean Testar_Classificacao(int cod) {
        boolean Resultado = false;
        
        try {
            
            String sql = "select * from classificacao where idclassificacao = "+ cod +"";
>>>>>>> f9bb64c63430d3e5d1c8c9b624fae198829b240a
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
<<<<<<< HEAD
                while (rs.next()) {
                    Classificacao a = new Classificacao();
                    a.setNome(rs.getString(1));
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
        public List<Classificacao> ConsultaCodigoClassificacao(String nome) {
        String sql = "select idclassificacao from classificacao where nome = '"+ nome +"'";
        List<Classificacao> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    Classificacao a = new Classificacao();
                    a.setCodigo(rs.getInt(1));
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
    
            public List<Classificacao> CapturarClassificacao(int cod){
        String sql = "select * from classificacao where idclassificacao = "+ cod +"";
        List<Classificacao> lista = new ArrayList<>();
        
        try {

                PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                        
                
                while (rs.next()) {
                    
                    Classificacao a = new Classificacao();
                    
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setPreco(rs.getDouble(3));
                    
>>>>>>> f9bb64c63430d3e5d1c8c9b624fae198829b240a
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
<<<<<<< HEAD
        } catch (Exception e) {
            return null;
            
        }
        
    }
    
        public String Excluir_Classificacao(Classificacao a){
        String sql = "delete from classificacao where idclassificacao = ? and nome = ?";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCodigo());
            ps.setString(2, a.getNome());
            
            if (ps.executeUpdate() > 0) {
                
                return "Excluido com sucesso";
            } else {
                return "Erro ao excluir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
        public List<Classificacao> ListarPrecoClassificacao(int cod){
        String sql = "select preco from classificacao where idclassificacao = "+ cod +"";
        List<Classificacao> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps .executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    Classificacao a = new Classificacao();
                    a.setCodigo(rs.getInt(1));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
=======
        } catch (SQLException e) {
            return null;
        }
    }
    
    public String Alterar_Classificacao(Classificacao a) {
        String sql = "update classificacao set nome = ? ,preco = ? where idclassificacao = ? ";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
        
            ps.setString(1, a.getNome());
            ps.setDouble(2, a.getPreco());
            ps.setInt(3, a.getCodigo());
            
            if (ps.executeUpdate() > 0) {
                return "Atualizado com sucesso!";
            } else {
                return "Erro ao Atualizar!";
            
            }
        } catch (SQLException e) {
        
            return e.getMessage();
        
        }
    }

     public List<Classificacao> ListarClassificacao() {
        String sql = "select idclassificacao,nome,preco from classificacao";
        List<Classificacao> Lista = new ArrayList<>();
           
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Classificacao a = new Classificacao();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setPreco(rs.getDouble(3));
                    
                    Lista.add(a);
                }
                
                return Lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
        
    }
    
    public List<Classificacao> Pesquisar_Nome_Cliente(String nome) {
        String sql = "select idclassificacao,nome,preco from classificacao where nome like '%"+ nome +"%'";
        List<Classificacao> Lista = new ArrayList<>();
           
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Classificacao a = new Classificacao();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setPreco(rs.getDouble(3));
                
                    Lista.add(a);
                }
                return Lista;
            } else {
                return null;
            }
            
        } catch (SQLException e) {
            return null;
        }
    }
    
    public List<Classificacao> Pesquisar_Cod_Cliente(int cod) {
        String sql = "select idclassificacao,nome,preco from classificacao where idclassificacao like '%"+ cod +"%'";
        List<Classificacao> Lista = new ArrayList<>();
           
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Classificacao a = new Classificacao();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setPreco(rs.getDouble(3));
                
                    Lista.add(a);
                    
                }
                return Lista;
            } else {
                return null;
            }
            
>>>>>>> f9bb64c63430d3e5d1c8c9b624fae198829b240a
        } catch (SQLException e) {
            return null;
        }
    }
<<<<<<< HEAD
=======
    
>>>>>>> f9bb64c63430d3e5d1c8c9b624fae198829b240a
}
