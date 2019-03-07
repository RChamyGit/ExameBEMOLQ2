/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author RICARDO
 */
public class FabricaConexao {
    private static Connection conn;
    public static Connection getConexao() {
		if(conn==null){ //singleton
		String url = "jdbc:mysql://localhost:3306/bancoExameBEMOL";//
		String user = "root";
		String senha = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, senha);
			JOptionPane.showMessageDialog(null, "Conexão ok!" );
		}catch(Exception e) {
			e.getMessage();
			JOptionPane.showMessageDialog(null, "Nao Conectou !" );
		}
                }
		return conn;
	}
    
    //finaliza conexao(){}
}
