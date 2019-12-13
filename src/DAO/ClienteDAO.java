/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Betty
 */
public class ClienteDAO extends ExecuteSQL {

    public ClienteDAO(Connection con) {
        super(con);
    }

    public String Inserir_Cliente(Cliente a) {
        try{
            String sql = "insert into cliente values(0,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setString(2, a.getNascimento());
            ps.setString(3, a.getRG());
            ps.setString(4, a.getCPF());
            ps.setString(5, a.getEmail());
            ps.setString(6, a.getTelefone());
            ps.setString(7, a.getBairro());
            ps.setString(8, a.getRua());
            ps.setInt(9, a.getNumero());
            ps.setString(10, a.getCEP());
            
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

    public List<Cliente> ListarComboCliente() {
        String sql = "select nome from cliente order by nome ";
        List<Cliente> lista = new ArrayList<>();

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
=======
    } 
    public List<Cliente> ListarCliente() { 
        String sql = "select idcliente, nome, rg, cpf, telefone, email, from cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement (sql);
>>>>>>> f9bb64c63430d3e5d1c8c9b624fae198829b240a
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
<<<<<<< HEAD
                    Cliente a = new Cliente();
                    a.setNome(rs.getString(1));
=======
                    Cliente a = new Cliente ();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setRG(rs.getNString(3));
                    a.setCPF(rs.getString(4));
                    a.setTelefone(rs.getString(5));
                    a.setEmail(rs.getString(6));
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

public List<Cliente> ConsultaCodigoCliente(String nome) {
        String sql = "select idcliente from cliente where nome = '"+ nome +"'";
        List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
=======
        } catch (SQLException e) {
            return null;
        }
        }
    
        public List <Cliente> Perquisar_Nome_Cliente(String nome) {
            String sql = "select idcliente, nome, RG, CPF, Telefone, Email "
                    + "from clinte where nome Like '%" +nome + "%'";
            List<Cliente> lista = new ArrayList<>();
            
        try {
            PreparedStatement ps = getCon().prepareStatement (sql);
>>>>>>> f9bb64c63430d3e5d1c8c9b624fae198829b240a
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
<<<<<<< HEAD
                    
                    Cliente a = new Cliente();
                    a.setCodigo(rs.getInt(1));
                    lista.add(a);

=======
                    Cliente a = new Cliente ();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setRG(rs.getNString(3));
                    a.setCPF(rs.getString(4));
                    a.setTelefone(rs.getString(5));
                    a.setEmail(rs.getString(6));
       lista.add(a);
>>>>>>> f9bb64c63430d3e5d1c8c9b624fae198829b240a
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
    public String Excluir_Cliente(Cliente a){
        String sql = "delete from cliente where idcliente = ? and nome = ?";
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
    
      public List<Categoria> ConsultaCodigoCategoria(String nome) {
        
        String sql = "select idcategoria from categoria where nome = '"+ nome +"'";
        List<Categoria> lista = new ArrayList<>();
        
        try {
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Categoria a = new Categoria();
                    a.setCodigo(rs.getInt(1));
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
    
    public String Excluir_Categoria(Categoria a){
        
        String sql = "delete from categoria where idcategoria = ? and nome = ?";
        
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

}
=======
        } catch (SQLException e) {
            return null;
            
                }
        
        
    
        
    }
        public List<Cliente> Pesquisar_Cod_Cliente(int cod)  {
            String sql = "select id cliente, Nome, RG, CPF, telefone, Email "
                    + "from Cliente where idcliente = '" + cod + "'";
         List<Cliente> lista = new ArrayList<>();
            
        try {
            PreparedStatement ps = getCon().prepareStatement (sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Cliente a = new Cliente ();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setRG(rs.getNString(3));
                    a.setCPF(rs.getString(4));
                    a.setTelefone(rs.getString(5));
                    a.setEmail(rs.getString(6));
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

        //alterar
        public boolean Testar_Cliente(int cod) {
            boolean Resultado = false;
            try {
                
                String sql = "select * from cliente where idcliente = " + cod + "";
                PreparedStatement ps = getCon() . prepareStatement(sql);
                ResultSet  rs = ps.executeQuery();
                
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
        
        public List<Cliente> CapturarCliente(int cod) {
                String sql = "select * from cliente where idcliente =" + cod + " ";
        List<Cliente> lista = new ArrayList<>();
        try {
         PreparedStatement ps = getCon().prepareStatement(sql);
         ResultSet rs = ps .executeQuery();
         if (rs != null) {
             while  (rs.next()) {
                 Cliente a = new Cliente();
                 a.setCodigo(rs.getInt(1));
                 a.setNome(rs.getString(2));
                 a.setNascimento(rs.getString(3));
                 a.setRG(rs.getString(4));
                 a.setCPF(rs.getString(5));
                 a.setEmail(rs.getString(6));
                 a.setTelefone(rs.getString(7));
                 a.setBairro(rs.getString(8));
                 a.setRua(rs.getString(9));
                 a.setNumero(rs.getInt(10));
                 a.setCEP(rs.getString(11));
                 lista.add(a);
             }
             return lista;
         }else {
             return null;
             
             }
           } catch (SQLException e) {
    return null;
         }     
        
        
        }
        public String Alterar_Cliente(Cliente a) {
            String sql = "update cliente set nome = ? ,data_nasc = ? ,rg = ? "
                    +",cpf = ? ,email = ? ,telefone = ? ,bairro = ?, rua = ? "
                    + ",numero = ? ,cep = ? where idcliente = ?";
            try {
                PreparedStatement ps =  getCon ().prepareStatement (sql);
                 ps.setString(1, a.getNome());
                 ps.setString(2, a.getNascimento());
                 ps.setString(3, a.getRG());
                 ps.setString(4, a.getCPF());
                 ps.setString(5, a.getEmail());
                 ps.setString(6, a.getTelefone());
                 ps.setString(7, a.getBairro());
                 ps.setString(8, a.getRua());
                 ps.setInt(9, a.getNumero());
                 ps.setString(10, a.getCEP());
                 ps.setInt(11, a.getCodigo()); 
                 if (ps.executeUpdate() > 0){
                     return "Atualizado com Sucesso.";
                 } else{ 
                     return "Erro ao Atualizar";
                 }
            } catch (SQLException e) {
                return e.getMessage();
                 }
                     
                
            
        }
        
       
        
}


        
    
   



 
>>>>>>> f9bb64c63430d3e5d1c8c9b624fae198829b240a
