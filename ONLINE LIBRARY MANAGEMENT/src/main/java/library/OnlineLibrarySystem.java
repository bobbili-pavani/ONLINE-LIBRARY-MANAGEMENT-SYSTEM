package library;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/**
 * Servlet implementation class OnlineLibrarySystem
 */
@WebServlet("/OnlineLibrarySystem")
public class OnlineLibrarySystem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnlineLibrarySystem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String name1=request.getParameter("username");
		String name2=request.getParameter("email");
		String name3=request.getParameter("password");
		
		pw.println("<html><body bgcolor=green>");
		pw.println("entered name is:"+name1);
		pw.println("entered email is:"+name2);
		pw.println("entered password is:"+name3);
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			Statement stmt=con.createStatement();
			//stmt.execute("create table Lib(uname varchar(20),mail varchar(30),pass varchar(8))");
			//pw.println("table created successfully");
			stmt.executeUpdate( "INSERT INTO Lib VALUES ('" + name1 + "', '" + name2 + "', '" + name3 + "')");
			pw.println("Data inserted into Lib table");	
			
		}
		catch(Exception e)
		{
			pw.println(e);
		}
		pw.println("<form action=View method=post>");
		pw.println("<input type=submit name=view value=View><br></form>");
		pw.println("<form action=Update method=post>");
		pw.println("<input type=submit name=Update value=Update><br></form>");
		pw.println("<form action=Delete method=post>");
		pw.println("<input type=submit name=Delete value=Delete><br></form>");
		pw.println("</body></html>");
	}
		
	
}


