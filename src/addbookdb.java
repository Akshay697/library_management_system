import java.sql.*;
public class addbookdb {
     
    public static boolean addbook(int id, String bookname, String author,String Edition,int num)
   {    
       try{
            Connection con= DB.getConnection();
           
        PreparedStatement ps = con.prepareStatement("insert into book_details(bookid,bookname,edition,bookauthor,quantity) values(?,?,?,?,?)");
       ps.setInt(1, id);
       ps.setString(2, bookname);
       ps.setString(3,Edition );
       ps.setString(4, author);
       ps.setInt(5,num);
       ps.executeUpdate();
       }
       catch(SQLException e)
       {
       e.printStackTrace();
       }
       return true;
       }
}
