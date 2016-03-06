/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author thusha
 */
public class InsertImages {

     static String URL = "jdbc:mysql://localhost:3306/thusha";
     static String userName = "root";
     static String password = "1234";
     public static void main(String[] args) {
          try {
              // Loads the MySQL Driver
              Class.forName("org.gjt.mm.mysql.Driver");

              // get's Connection by using DriverManager class
              Connection con = DriverManager.getConnection(
                        URL, userName, password);

              // images directory path
              String filePath = "D:\\images";

              // Creating File object with directory path
              File path = new File(filePath);

              /*
               * getting the list of files path under
                * directory and saving into
               * String type of array
               */
              String[] pathList = path.list();
               String query = "insert into img(Image) values(?)";
              // Loading each file using for loop
              for (int i = 0; i < pathList.length; i++) {
                String filepath =filePath+"/"+ pathList[i];
                 System.out.println(filePath+"/"+ pathList[i]);
                FileInputStream inputStream = new FileInputStream (new File(filepath));

                   // creating prepared statement
                   PreparedStatement ps = con.prepareStatement(query);
                   ps.setBinaryStream(1, (InputStream) inputStream, filepath.length());

                   // Executing the prepared Statement
                   int rows = ps.executeUpdate();
                   if (rows > 0) {
                        System.out.println("Image Inserted to Database Successfully!");
                   }
              }
          } catch (FileNotFoundException e) {
              e.printStackTrace();
          } catch (ClassNotFoundException e) {
              e.printStackTrace();
          } catch (SQLException e) {
              e.printStackTrace();
          }
     }
}
