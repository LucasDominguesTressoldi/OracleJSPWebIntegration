package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.RegisterDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		String name = request.getParameter("fullname");
		String pswd = request.getParameter("pswd");
		String birth = request.getParameter("birth");
		String email = request.getParameter("email");
		String cel = request.getParameter("cel");

		String res = new RegisterDAO().verifyUser(cpf, name, pswd, birth, email, cel);

		if ("".equals(res)) {
			response.sendRedirect("index.jsp");
		} else {
			System.out.println(res);
			response.sendRedirect("error.jsp");
		}
	}
}
