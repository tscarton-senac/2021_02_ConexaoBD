/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.conexaobd.dao;

import br.senac.conexaobd.Conexao;
import br.senac.conexaobd.entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tiago Scarton
 */
public class ClienteDAO {

   public List<Cliente> getClientes() {
       List<Cliente> clientes = new ArrayList<>();
       String query = "select * from cliente";
       
       Connection con = Conexao.getConexao();
       try {
           PreparedStatement ps = con.prepareStatement(query);
           ResultSet rs = ps.executeQuery();
           while (rs.next()) {
               Cliente cliente = new Cliente();
               String nome = rs.getString("nome");
               String email = rs.getString("email");
               String cpf = rs.getString("cpf");
               cliente.setNome(nome);
               cliente.setEmail(email);
               cliente.setCpf(cpf);
               clientes.add(cliente);
           }
       } catch (SQLException ex) {
           Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
       return clientes;
       
   }
   

}
