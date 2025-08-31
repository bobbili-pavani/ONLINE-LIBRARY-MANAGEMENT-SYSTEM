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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
		PrintWriter pw=response.getWriter();
		pw.println("<html><body bgcolor=#00FFFF>");
		try
		{
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		  Statement stmt=con.createStatement();
		  stmt.executeUpdate("update Lib set uname='sreeha' where uname='saa'");
		  stmt.executeUpdate("update Lib set mail='sre@gmial.com' where mail='b2005@gmail.com'");
		  stmt.executeUpdate("update Lib set pass='sr' where pass='90iut'");
          
		  pw.println("data is updated successfully"); 
		}
		catch(Exception e)
		{
			pw.println(e);
		}
		 //pw.println("<form action=OnlineLibrarySystem method=post>");
		 //pw.println("<br><input type=submit name=back value=Back>");
		 //pw.println("</form></body></html>");
		
	}

	}


