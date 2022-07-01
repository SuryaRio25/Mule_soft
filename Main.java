package mulesoft;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
public static void main(String [] args) {
	createtable.createNewTable();
	insert("  Valimai  ","  Ajithkumar       ","Gurbani Judge    ",2022,"H Vinoth   ");
	insert("  Viswasam ","  Ajith            ","Nayanthara       ",2019,"siva       ");
	insert("  Master   ","  Vijay            ","Vijay sethupathi ",2021,"Loki       ");
	insert("  Don      ","  Siva Karthikeyan ","S J Surya        ",2022,"Cibi       ");
	insert("  Jai bhim ","  Suriya           "," Manikandan      ",2021,"TJ Gnanavel");
	select.selectAll();
	select.selectactormovie();
}
private static void insert(String moviename,String leadactor,String actress,Integer yearofrelease,String director) {
	Connection con=Dbconnection.connect();
	PreparedStatement ps=null;
	try {
		String sql="INSERT INTO movies(moviename,leadactor,actress,yearofrelease,director) VALUES(?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, moviename);
		ps.setString(2, leadactor);
		ps.setString(3, actress);
		ps.setInt(4,yearofrelease);
		ps.setString(5, director);
		ps.execute();
		System.out.println("Data has been inserted");
	}catch(SQLException e) {
		System.out.println(e.toString());
	}
}
}
