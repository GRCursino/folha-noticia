package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet(urlPatterns={"/login"})
public class Login extends HttpServlet{	
	/**
	 *
	 */
	private static final long serialVersionUID = 8112602998560095427L;

	@Override
	public void doGet(  HttpServletRequest req, 
						HttpServletResponse res){
		try{
			req.getRequestDispatcher("/views/login.jsp").forward(req, res);
		} catch (Exception e){
			System.out.println("Erro em IO ou no Servlet");
		}
	}	
}