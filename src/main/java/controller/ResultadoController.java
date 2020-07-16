package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import model.ResultadoDAO;
import model.Resultado;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.PrintWriter;


@WebServlet(urlPatterns = { "/resultado" })
public class ResultadoController extends HttpServlet {

    private static final long serialVersionUID = 8112602998560095428L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {

			List<Resultado> resultados = ResultadoDAO.getInstance().findAll();
			JSONArray array = new JSONArray();

			for (Resultado resultado : resultados) {
				JSONObject json = new JSONObject();
				json.put("operacao", resultado.getOperacao());
				json.put("resultado", resultado.getResultado());
				json.put("data", resultado.getData());
				array.put(json);
			}
			res.setContentType("application/json");
			PrintWriter escritorResposta = res.getWriter();
			escritorResposta.write(array.toString());
			escritorResposta.close();  
		} catch (Exception e) {
			System.out.println("Erro em IO ou no Servlet");
		}
    }
    

    
}