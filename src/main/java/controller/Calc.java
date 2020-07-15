package controller;

import model.Resultado;
import model.ResultadoDAO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/calc"})
public class Calc extends HttpServlet {
    
	private static final long serialVersionUID = 8112602998560095428L;
	

	@Override
	public void doGet(  final HttpServletRequest req, final HttpServletResponse res) {
		try {
			req.getRequestDispatcher("/views/calc.jsp").forward(req, res);
		} catch (final Exception e) {
			System.out.println("Erro em IO ou no Servlet");
		}
	}

	@Override
	public void doPost(final HttpServletRequest req, final HttpServletResponse res) {

		try {

			final String operando1 = req.getParameter("operando1");
			final String operando2 = req.getParameter("operando2");
			final String operador = req.getParameter("operador");

			String operadorReal = "";

			switch (operador) {
				case "1":
					operadorReal = operando1 + " + " + operando2;
					break;
				case "2":
					operadorReal = operando1 + " - " + operando2;
					break;
				case "3":
					operadorReal = operando1 + " * " + operando2;
					break;
				case "4":
					operadorReal = operando1 + " / " + operando2;
					break;
				case "5":
					operadorReal = "Math.pow( " + operando1 + " , 1/" + operando2 + ")";
					break;
				case "6":
					operadorReal = "Math.pow( " + operando1 + " , " + operando2 + ")";
					break;
			}

			final ScriptEngineManager manager = new ScriptEngineManager();
			final ScriptEngine engine = manager.getEngineByName("js");
			final Object result = engine.eval(operadorReal);

			Resultado resultado = new Resultado();

			resultado.setOperacao(operadorReal);
			resultado.setResultado(result.toString());

			resultado.setId_user(1);

			ResultadoDAO.getInstance().persist(resultado);

			

			PrintWriter pw = res.getWriter();
			pw.print(result.toString());
			pw.close();

		} catch (final Exception e) {
			//System.out.println("Erro em IO ou no Servlet");
			e.printStackTrace();
		}				
	}
}

