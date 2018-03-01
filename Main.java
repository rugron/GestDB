package database;

import java.sql.*;
import java.sql.Connection;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// getConnection(); //prima parte prima del CreateTable
		//CreateTable(); // seconda parte 
		insert(); //terza parte
	}
	
	public static void CreateTable() throws Exception {
		try{
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS peppe(idimpiegati int NOT NULL AUTO_INCREMENT,nome varchar(45),cognome varchar(45),città varchar(45),PRIMARY KEY(idimpiegati))"); 
			create.executeUpdate();
		}//aggiungo un'altra tabella nell'elenco dei database
		catch(Exception e){System.out.println(e);}
		finally{
			System.out.println("Function completed");
		};
	}
	
	public static void insert() {
		String nome = "peppe";
		String cognome = "ruggio";
		String città = "rrreggio";
		try {
			Connection c = getConnection();
			PreparedStatement obj = c.prepareStatement("INSERT INTO peppe (nome,cognome,città) VALUES ('"+nome+"','"+cognome+"','"+città+"')");
			obj.executeUpdate();
			}catch(Exception e) {System.out.println(e);}
			finally {System.out.println("Inserted!");}
		
	}
	
	public static Connection getConnection() throws Exception{ //Connection da "java.sql"!!!
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/aaa";
			String usrname = "qwerty";
			String pw = "12345678";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,usrname,pw);
			
			System.out.println("Connected");
			return conn;
		}catch(Exception e) {System.out.println(e);}
		return null;
	}
}
