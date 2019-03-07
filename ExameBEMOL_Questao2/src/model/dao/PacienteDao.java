/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Paciente;
import model.conexao.FabricaConexao;
import java.util.List;
import java.time.LocalDate;
/**
 *
 * @author RICARDO
 */
public class PacienteDao{
    Connection conecta = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql ="";

    public void salvar(Paciente pac) {
        conecta = FabricaConexao.getConexao();//conecta ao banco de dados
	sql = "insert into paciente values(?,?,?)";
            try {
                ps = conecta.prepareStatement(sql); //preparando o BD p/ receber um informacao
                //atributos da tabela

                ps.setDouble(1, pac.getCpf());
                ps.setString(2, pac.getNome());
                ps.setDate(3, java.sql.Date.valueOf(pac.getDtnascto()));

                ps.execute(); //executa a acao
                System.out.println("salvo no BD");	
			} catch (SQLException e) {
                            System.out.println("e.getMessage()");
			}
    }

    public void alterar(Paciente pac,long oldCpf){
        conecta = FabricaConexao.getConexao();
			sql = "update paciente set cpf=?, nome=?, dtnascto=? where cpf = ?";
			try {
				ps = conecta.prepareStatement(sql);
				
				ps.setLong(1, pac.getCpf());
				ps.setString(2, pac.getNome());
				ps.setObject(3, pac.getDtnascto());
                                ps.setLong(4, oldCpf);
								
				ps.execute();
                                System.out.println("Row alterada");
				
			} catch (SQLException e) {
                                System.out.println("erro no alterar"+e.getMessage());
			}
    }
    
    public void excluir(Paciente pac){
        conecta = FabricaConexao.getConexao();//conecta ao banco de dados		
            sql = "delete from paciente where cpf="+pac.getCpf();
            
            try {
                    ps = conecta.prepareStatement(sql);
                    ps.execute();
                    System.out.println("Deletado com Sucesso");	
            }catch (SQLException e){
                System.out.println("erro no excluir"+e.getMessage());
            }
    }
    
    public List<Paciente> listar() throws SQLException {
       conecta = FabricaConexao.getConexao();
       sql = "select * from paciente";
       ps = conecta.prepareStatement(sql);
       rs =ps.executeQuery();
       List<Paciente> lista = new ArrayList<>();
       while( rs.next()){
           Paciente pac = new Paciente();
           pac.setCpf(rs.getLong("cpf"));
           pac.setNome(rs.getString("nome"));
           pac.setDtnascto((rs.getDate("dtnascto").toLocalDate())); //conversor sql Date - Local
           lista.add(pac);
           System.out.println("CPF: "+pac.getCpf()+" Nome: "+pac.getNome()+" Data Nasc: "+pac.getDtnascto());
       }
       return lista; //implementacao view
    }
}
