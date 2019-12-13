/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import Modelo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Betty
 */
public class FuncionarioDAO extends ExecuteSQL {
    
    public FuncionarioDAO(Connection con) {
        super(con);
    }
    
     public String Inserir_Funcionario(Funcionario a) {
        try {
            String sql = "insert into funcionario values(0,?,?,?)";
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setString(2, a.getLogin());
            ps.setString(3, a.getSenha());
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso!";
            } else {
                return "Erro ao inserir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
     
    public boolean Logar (String login, String senha) {
      boolean finalResult = false;
      try {
          
          String consulta = "select login, senha from funcionario" 
         +" where login = '" + login + "' and senha = '" + senha + "'";
          PreparedStatement ps = getCon().prepareStatement(consulta);
          ResultSet rs = ps.executeQuery();
          
          if (rs != null) {
              while (rs.next()) {
                  Funcionario a = new Funcionario();
                  a.setLogin(rs.getString(1));
                  a.setSenha(rs.getString(2));
                  finalResult = true;
              }
          }
      } catch (SQLException ex) {
      
          ex.getMessage();
      
      }
      return finalResult;
    }
    
            public boolean Testar_Funcionario(int cod) {
                    boolean Resultado = false;

                try {
                    String sql = "select * from funcionario where idfuncionario = "+ cod +"";
                    PreparedStatement ps = getCon().prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();

                    if (rs != null) {
                        while (rs.next()) {

                            Resultado = true;

                        }
                    }

                } catch (SQLException ex) {
                    ex.getMessage();
                }
                return Resultado;
            
            
            }
    
    public List<Funcionario> CapturarFuncionario(int cod){
        String sql = "select * from funcionario where idfuncionario = "+ cod +"";
        List<Funcionario> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    
                    Funcionario a = new Funcionario();
                    
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setLogin(rs.getString(3));
                    a.setSenha(rs.getString(4));
                    
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
    
    public String Alterar_Funcionario(Funcionario a) {
        String sql = "update funcionario set nome = ? ,login = ? ,senha = ? where idfuncionario = ? ";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getLogin());
            ps.setString(3, a.getSenha());
            ps.setInt(4, a.getCod());
            
            if (ps.executeUpdate() > 0) {
                return "Atualizado com sucesso!";
            } else {
                return "Erro ao Atualizar!";
            }
            
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
    public List<Funcionario> ListarFuncionario() {
        String sql = "select idfuncionario,nome,login,senha from funcionario";
        List<Funcionario> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    
                    Funcionario a = new Funcionario();
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setLogin(rs.getString(3));
                    a.setSenha(rs.getString(4));
                
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
    
    public List<Funcionario> Pesquisar_Nome_Cliente(String nome) {
        String sql = "select idcliente,nome,rg,cpf,telefone,email from cliente where nome like '%"+ nome +"%'";
        List<Funcionario> Lista = new ArrayList<>();
           
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    
                    Funcionario a = new Funcionario();
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setLogin(rs.getString(3));
                    a.setSenha(rs.getString(4));
                
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
    
    public List<Funcionario> Pesquisar_Cod_Cliente(int cod) {
        String sql = "select idcliente,nome,rg,cpf,telefone,email from cliente where idcliente like '%"+ cod +"%'";
        List<Funcionario> Lista = new ArrayList<>();
           
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    
                    Funcionario a = new Funcionario();
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setLogin(rs.getString(3));
                    a.setSenha(rs.getString(4));
                
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

}

    
    
    

