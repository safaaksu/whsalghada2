/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Dictionary;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abodi
 */
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {
R[] safa=new R [4]; 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlett Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     String userName=request.getParameter("username");
    String Password=request.getParameter("Password");
    String userNameDB;
    String passwordDB;
    Connection con;
   
     
    PrintWriter pw= response.getWriter(); 
 try {
                        
                         Class.forName("com.mysql.jdbc.Driver");

                        con = DriverManager.getConnection(DBConnection.urlstring, DBConnection.username, DBConnection.password);


                        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        ResultSet resultSet = statement.executeQuery("select * from user where Username='"+userName+"'AND Password='"+Password+"'"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
   
        if(resultSet.next())
    pw.println("successful"); 
                     
                            else  { 
            ObjectMapper objectMapper = new ObjectMapper();

String st=objectMapper.writeValueAsString(safa);
       pw.println("unsuccessful");
//       R[]safa2=new R[4];
//       safa2= objectMapper.readValue(st, R[].class);
//         pw.println(safa2[1].getName());                 
        }
                       
                    } catch (SQLException e) {
                        e.printStackTrace();}
                        catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
    
    
    
    
    
    
     
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       // processRequest(request, response);
//    String userName=request.getParameter("username");
//    String Password=request.getParameter("password");
//    String userNameDB;
//    String passwordDB;
//    Connection con;
//    PrintWriter pw= response.getWriter(); 
// try {
//                        
//                         Class.forName(DBConnection.Driver);
//
//                        con = DriverManager.getConnection(DBConnection.urlstring, DBConnection.username, DBConnection.password);
//
//
//                        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
//        ResultSet resultSet = statement.executeQuery("select Username,Password from user"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
//                        while (resultSet.next()) // Until next row is present otherwise it return false
//                        {
//                            userNameDB = resultSet.getString("Username"); //fetch the values present in database
//                            passwordDB = resultSet.getString("Password");
//                            if (userName.equals(userNameDB) && Password.equals(passwordDB)) {
//                              
//       pw.write("successful");  
//       pw.print("successful"); 
//                         System.out.print("yes");   }
//                            else  {pw.write("unsuccessful");  
//       pw.print("unsuccessful"); 
//                            System.out.print("yes");}
//                        }
//                    } catch (SQLException e) {
//                        e.printStackTrace();}
//                        catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                    }
   
    
    response.setContentType("text/html;charset=UTF-8");
    String userName=request.getParameter("username");
    String Password=request.getParameter("Password");
    String userNameDB;
    String passwordDB;
    Connection con;

    PrintWriter pw= response.getWriter(); 
 try {
                        
                         Class.forName("com.mysql.jdbc.Driver");

                        con = DriverManager.getConnection(DBConnection.urlstring, DBConnection.username, DBConnection.password);


                        Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
        ResultSet resultSet = statement.executeQuery("select * from user where Username='"+userName+"'AND Password='"+Password+"'"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
   
        if(resultSet.next())
    pw.println("successful"); 
                     
                            else  { 
            ObjectMapper objectMapper = new ObjectMapper();

String st=objectMapper.writeValueAsString(safa);
       pw.println("unsuccessful");
//       R[]safa2=new R[4];
//       safa2= objectMapper.readValue(st, R[].class);
//         pw.println(safa2[1].getName());                 
        }
                       
                    } catch (SQLException e) {
                        e.printStackTrace();}
                        catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
    
    
    
    
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
