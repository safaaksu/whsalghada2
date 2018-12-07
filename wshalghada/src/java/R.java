
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abodi
 */


public class R implements Serializable {

        private static final long serialVersionUID = 1L;
    String Rname;
    int Rid;
    byte[] Rimage;

    public R(String Rname, int Rid, byte[] Rimage) {
        this.Rname = Rname;
        this.Rid = Rid;
        this.Rimage = Rimage;
    }
    
    public R() {
    }

    public void setRname(String Rname) {
        this.Rname = Rname;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getRname() {
        return Rname;
    }

    public int getRid() {
        return Rid;
    }

    public byte[] getRimage() {
        return Rimage;
    }

    public void setRid(int Rid) {
        this.Rid = Rid;
    }

    public void setRimage(byte[] Rimage) {
        this.Rimage = Rimage;
    }

   
public static ArrayList<Integer> SearchByIng(Set<Integer> Ingset, boolean only_This_ing) throws SQLException, ClassNotFoundException{
      Class.forName("com.mysql.jdbc.Driver");
     Connection     con = DriverManager.getConnection(DBConnection.urlstring, DBConnection.username, DBConnection.password);
     Statement  statement = con.createStatement();
     Set<Integer> staticIng=new HashSet<>();
      ResultSet resultSet;
      String Ingset1="";
       String sqlQuery="";
     if(only_This_ing){
         staticIng.addAll(Arrays.asList(2,3,4,6,7,9,10,20,21,24,26,27,28,35,36,41,50,48,49,53,41));
     Ingset.addAll(staticIng);
          Ingset1=Ingset.toString();
     Ingset1=Ingset1.replace('[', '(');
     Ingset1=Ingset1.replace(']', ')');
     sqlQuery="SELECT contain.RecipeID FROM contain WHERE contain.IngredientID IN "+Ingset1+" GROUP BY contain.RecipeID HAVING COUNT(DISTINCT contain.IngredientID) >="+Ingset.size();
     }
     else {
     Ingset1=Ingset.toString();
     Ingset1=Ingset1.replace('[', '(');
     Ingset1=Ingset1.replace(']', ')');
    sqlQuery="SELECT DISTINCT contain.RecipeID FROM `contain` WHERE contain.IngredientID IN "+Ingset1;
     }
     //SELECT contain.RecipeID FROM contain WHERE contain.IngredientID IN (1,2,3,4,5,6,7,8,9,10,11,12) GROUP BY contain.RecipeID HAVING COUNT(DISTINCT contain.IngredientID) >= 7
 resultSet= statement.executeQuery(sqlQuery);
 ArrayList<Integer> RID=new  ArrayList<>();
  while (resultSet.next()) // Until next row is present otherwise it return false
            {
              RID.add(resultSet.getInt("RecipeID"));
           }

return RID;
}
    
    
    
}
