package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/calc"})
public class Calc extends HttpServlet {
    
    private static final long serialVersionUID = 8112602998560095428L;

	@Override
	public void doGet(  HttpServletRequest req, 
						HttpServletResponse res){
		try{
			req.getRequestDispatcher("/views/calc.jsp").forward(req, res);
		} catch (Exception e){
			System.out.println("Erro em IO ou no Servlet");
		}
	}
	
	@Override
	public void doPost( HttpServletRequest req, 
						HttpServletResponse res){

		try{

			

		}catch (Exception e){
			System.out.println("Erro em IO ou no Servlet");
		}				
	}
}

