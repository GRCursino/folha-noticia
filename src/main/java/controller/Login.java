package controller;

import model.UsuarioDAO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = { "/login" })
public class Login extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = 8112602998560095427L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.getRequestDispatcher("/views/login.jsp").forward(req, res);
		} catch (Exception e) {
			System.out.println("Erro em IO ou no Servlet");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String email = req.getParameter("campoEmail");
			String senha = req.getParameter("campoSenha");

			if (UsuarioDAO.getInstance().validate(email, senha)) {
				Usuario usuario = UsuarioDAO.getInstance().findByEmail(email);

				HttpSession session = req.getSession();
				session.setAttribute("uname", usuario.getId_user());

				resp.sendRedirect(req.getContextPath() + "/calc");

			} else {
				req.setAttribute("message", "Erro ao realizar logar. Verifique email e senha e tente novamente");
				req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			}

		} catch (Exception e) {
			//System.out.println("Erro em IO ou no Servlet");
			e.printStackTrace();
		}
	}
}