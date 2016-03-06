/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_Layer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author thusha
 */
public class DB_Login {
    
    private static DB_Login inst=new DB_Login();
    private Connection con;
    private ResultSet set;
    private Statement stment;
    
    private DB_Login(){}
    
    public static DB_Login getInstance(){
        return inst;
    }
    
    private Connection getConnect(){
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/Employee_Attendance", "root", "1234");	
	}
	catch(ClassNotFoundException e){
		JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	}
	catch(SQLException e){
		JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	}		
	return(con);
    }
    
    public ResultSet searchRecord(String query) {
        try{
            stment=getConnect().createStatement();
            set=stment.executeQuery(query);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	}
        return set;
    }
    
    public void insertRecord(String query)
    {
		try{
			stment=getConnect().createStatement();
			stment.executeUpdate(query);
                }
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
    
    public void updateRecord(String qu)
    {
	try{
            stment=getConnect().createStatement();
            stment.executeUpdate(qu);
            JOptionPane.showMessageDialog(null,"Updated done !","Updated",JOptionPane.INFORMATION_MESSAGE);
	}
	catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error","Error",JOptionPane.ERROR_MESSAGE);
	}
    }

}
