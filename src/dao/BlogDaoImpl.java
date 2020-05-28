package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Blog;
import utility.ConnectionManager;

public class BlogDaoImpl implements BlogDaoInterface{

	
	public void insertBlog(Blog blog) throws SQLException {
	     if(ConnectionManager.getConnection()!=null) {
	    	 System.out.println("established");
	    	
	    	Statement stmt = ConnectionManager.getConnection().createStatement();
	    	String sql = "INSERT INTO BLOG VALUES("+blog.getBlogId()+","+"'"+blog.getBlogTitle()+"'"+","+"'"+blog.getBlogDescription()+"'"+","+"DATE"+" "+"'"+blog.getPostedOn()+"'"+")"; 
            int i = stmt.executeUpdate(sql);
            if(i>0) {
            	System.out.println("Blog Inserted");
            }
	    	
	    	
	     }
	     else
	    	 System.out.println("not");
	}

	
	public List<Blog> selectAllBlogs() throws SQLException {
		
		List<Blog> blogList = null;
		  if(ConnectionManager.getConnection()!=null) {
		    	 System.out.println("established");
		    	blogList =new ArrayList<>();
		    	Statement stmt = ConnectionManager.getConnection().createStatement();
		    	String sql = "SELECT * FROM BLOG"; 
	            ResultSet rs  = stmt.executeQuery(sql);
	            while(rs.next()) {
	            	Blog blog = new Blog();
	            	blog.setBlogId(rs.getInt(1));
	            	blog.setBlogTitle(rs.getString(2));
	            	blog.setBlogDescription(rs.getString(3));
	            	//blog.setPostedOn();
	            	blogList.add(blog);
	            }
	         
		    	
		    	return blogList;
		     }
		     else
		    	 {System.out.println("no data presnet");
		    	 
		    	 return blogList;
		    	 }
		
	}
	
}