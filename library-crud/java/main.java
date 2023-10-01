

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class main
 */
@WebServlet("/main")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public main() {
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
//		out.println("<h1>HelloWorld</h1>");
		response.setContentType("text/html");
		
		try {
			
			 Class.forName("com.mysql.cj.jdbc.Driver");
	         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment5", "root","rutu@1602");
	         Statement st = con.createStatement();
	         
	         ResultSet rs = st.executeQuery("select * from book");
	         
	         out.println("<html>");
	         out.println("<head>");
	         
	         out.println("<style>");
	         
	         out.println("body{ background-image: url('img1.png');");
	         out.println("background-attachment: fixed;");
//	         out.println("background-repeat: no-repeat; }");
	         out.println("}");
	         
	         out.println("nav{ display: flex;");
	         out.println("align-items: center;");
	         out.println("justify-content: space-around;");
	         out.println("background-color: grey;");
	         out.println("width : 1500px;");
	         out.println("position: fixed;");
	         out.println("overflow: hidden;");
	         out.println("}");
	         
	         out.println("nav.nav {");
	         out.println("margin-top: -20px;");
	         out.println("padding: 0px 10px 0px 10px;");
	         out.println("margin-left: -8px;");
	         out.println("}");
	         
	         out.println("body{color: navy;}");
	         out.println("table {width: 800px ;");
	         out.println("margin-left:330");
	         out.println("}");
	         
	         out.println("th, td { text-align: center;");
	         out.println("width:170px");
	         out.println("padding: 5px; }");
	         
	         out.println("button{  padding: 5px 5px;");
	         out.println("font-size: 20px;");
	         out.println("border-radius: 7px;");
	         out.println("}");
	         
	         out.println("a.l1{color:black;");
	         out.println("text-decoration:none;");
	         out.println("}");
	         
	         out.println("a.update{color:#EC449B;");
	         out.println("text-decoration:none;");
	         out.println("}");
	         
	         out.println("a.delete{color:red;");
	         out.println("text-decoration:none;");
	         out.println("}");
	         
//	         out.println(" width: 150px;");
//	         out.println("*{color : 'white';}");
	         
	         out.println("input[type='button'] {");
	         out.println("padding: 5px 7px;");
	         out.println("font-size: 15px;");
	         out.println("border-radius: 14px;");
	         out.println("margin-left: 85px;");
	         out.println("margin-top: 47px;");
	         out.println("}");
	         
	         out.println("a.delete{ color : red ;}");
	         out.println("a{color : white ;}");
	         out.println("</style>");
	         out.println("</head>");
	         
	         out.println("<nav class='nav'><h1>MITWPU Library</h1>");
	         out.println("<h1><button><a href='create.html' class='l1'>Add Book</a></button></h1>");
	         out.println("</nav>");
	         
	         out.println("<table border='1' style='margin-top: 20px;'>");
	         out.println("<tbody>");
	         out.println("<tr><th><h1>Book NO</h1></th>");
	         out.println("<th><h1>Book Name</h1></th>");
	         out.println("<th><h1>Book Price</h1></th>");
	         out.println("<th><h1>Update</h1></th>");
	         out.println("<th><h1>Delete</h1></th></tr>");
	         
	         
//	         out.println("</table>");
	         

//	         if(rs.next())
	         
	         while(rs.next()){
//	        	 out.println("<table border>");
		         out.println("<tr><td><h2>"+rs.getString(1) +"</h2></td>");
		         out.println("<td><h2>"+rs.getString(2) +"</h2></td>");
		         out.println("<td><h2>"+rs.getString(3) +"</h2></td>");
		         out.println("<td><h2><a href='update.html' class='update'>Update</a></h2></td>");
		         out.println("<td><h2><a href='delete.html' class='delete'>Delete</a></h2></td></tr>");
//		         out.println("</table>");
		         
	         }
	         out.println("</tbody");
	         out.println("</table>");
//	         out.println("<a href='create.html'><input type='button' value='Add Book'></a>");
	         out.println("<body>");
	         out.println("</html>");
	         
			
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
