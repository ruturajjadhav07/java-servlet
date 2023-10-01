

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
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
		String bookName = request.getParameter("bookName");
		String bookPrice = request.getParameter("bookPrice");
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment5", "root","rutu@1602");
            String query = "UPDATE book SET bookName = ?, bookPrice = ? WHERE bookNo = ?";
			//			UPDATE book SET bookName = 'Ikigai', bookPrice = 190 WHERE bookNo = 1;
            PreparedStatement st = con.prepareStatement(query);
//			
			st.setString(1, bookName);
			st.setString(2, bookPrice);
			st.setInt(3, bookNo);
			
			int i = st.executeUpdate();
			 if (i > 0) {
	                out.println("<h1>Update Successful</h1>");
	                out.println("<h1>Changed Name : </h1>");
	                out.println("<h1>Name : "+bookName+"</h1>");
	                out.println("<h1>Price : "+bookPrice+"</h1>");
	                
	                out.println("<br><br><br> It will redirect to Library");
	                response.setHeader("refresh","10;main");
	                
	            } else {
	                out.println("<h1>Update Failed</h1>");
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
