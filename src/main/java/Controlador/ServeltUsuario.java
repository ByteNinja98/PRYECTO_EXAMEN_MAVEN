package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOImplements.DAOUsuario;
import model.TblUsuariocl2;

/**
 * Servlet implementation class ServeltUsuario
 */
public class ServeltUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	TblUsuariocl2 usu=new TblUsuariocl2();
	DAOUsuario daoim=new DAOUsuario();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeltUsuario() {
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
		request.getRequestDispatcher("RegistrarProveedor.jsp").forward(request, response);
		doGet(request, response);
	}

}
