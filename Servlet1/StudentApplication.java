
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class StudentApplication extends HttpServlet
{
  public void service(HttpServletRequest  req, HttpServletResponse res)
 {
       try{
                int  a =Integer.parseInt(req.getParameter("i"));
                String b = req.getParameter("n");
                String c =req.getParameter("c");
                int d =  Integer.parseInt(req.getParameter("f"));
                String e = req.getParameter("p");
  
     //jdbc code
         String driver ="com.mysql.cj.jdbc.Driver";
         String  url ="jdbc:mysql://localhost:3306/rohith";
          String name ="root";
           String pwd ="root";
       Class.forName( driver);
     Connection con = DriverManager.getConnection(url,name ,pwd);
      String qry ="insert into tech values(?,?,?,?,?)";
      PreparedStatement smt = con.prepareStatement(qry);
         smt.setInt(1,a);
         smt.setString(2,b);
         smt.setString(3,c);
        smt.setInt(4,d);
        smt.setString(5,e);
             
        smt.executeUpdate( );
        con.close( );
 PrintWriter out =res.getWriter( );
               out.println( "the student id is:"+a);
               out.println("the student name is:"+b);
              out.println("the student course is:"+c);
              out.println("the student fee is:"+d);
              out.println("the student phn number is:"+e);
        



             }
   catch(Exception e)
  {
        System.out.println(e);
    }
}
}