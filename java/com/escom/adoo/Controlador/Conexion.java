package com.escom.adoo.Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion
{
  public static Connection getConexion()
  {
    Connection conexion = null;
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      String servidor = "jdbc:mysql://54.184.97.62:3306/Radio?useLegacyDatetimeCode=false&serverTimezone=America/New_York";
      String usuarioDB = "adooUser";
      String passwordDB = "AdooProject1";
      
      conexion = DriverManager.getConnection(servidor, usuarioDB, passwordDB);
      
      return conexion;
    }
    catch (ClassNotFoundException ex)
    {
      ex = 
      
        ex;JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD CLOUD " + ex.getMessage(), 0);conexion = null;return conexion;
    }
    catch (SQLException ex)
    {
      ex = 
      
        ex;JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD CLOUD" + ex.getMessage(), 0);conexion = null;return conexion;
    }
    catch (Exception ex)
    {
      ex = 
      
        ex;JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD " + ex.getMessage(), 0);conexion = null;return conexion;
    }

  }
}
