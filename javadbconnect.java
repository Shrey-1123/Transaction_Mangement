/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Soma
 */
import java.sql.*;
import javax.swing.JOptionPane;
public class javadbconnect
{
    Connection conn=null;
    
    public static Connection ConnectDb()
    {
        try
        {
            //class.forName("org.MySql.JDBC");
            Connection conn;
            conn=java.sql.DriverManager.getConnection("jdbc:mysql://127.0.0.1/banking", "root" , "");
            return conn;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
}

    

