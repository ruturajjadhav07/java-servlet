

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class create
 */
@WebServlet("/create")
public class create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public create() {
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
//		out.println("HelloWolrd");
		response.setContentType("text/html");
		
		String bookName = request.getParameter("bookName");
		String bookPrice = request.getParameter("bookPrice");
		RequestDispatcher dispatcher = null;
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment5", "root","rutu@1602");
				
				PreparedStatement st = con.prepareStatement(" insert into book (bookName,bookPrice) values (?,?)");
				
				st.setString(1, bookName);
				st.setString(2, bookPrice);
				
				int i = st.executeUpdate();
				if (i > 0) {
				    out.println("<h1>Added Successfully</h1>");
				    out.println("After Adding it will redirect to library");
				    response.setHeader("refresh", "5;main");
//				    response.sendRedirect("main.java");
				    
				    
				} else {
				    response.sendRedirect("create.html");
				}

			}catch(Exception e) {
				e.printStackTrace();
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
