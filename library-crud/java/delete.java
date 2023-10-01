

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
//		out.println("Helloworld");
		response.setContentType("text/html");
		
		int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment5", "root","rutu@1602");
            String query = "DELETE FROM book WHERE bookNo = ?";
            PreparedStatement st = con.prepareStatement(query);
            
            st.setInt(1, bookNo);
            
         int i = st.executeUpdate();
            if(i>0) {
			out.println("Deleted Successfully");
			out.println("<br><br><br> It will redirect to Library");
            response.setHeader("refresh","10;main");
            }else {
            	out.println("Delete Failed");
            }
		}catch(Exception e) {
//			out.println(e.printStackTrace());
			e.printStackTrace();
			out.println("Error :"+e.getMessage());
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
