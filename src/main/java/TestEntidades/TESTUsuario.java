package TestEntidades;

import DAOImplements.DAOUsuario;
import model.TblUsuariocl2;

public class TESTUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TblUsuariocl2 usu=new TblUsuariocl2();
		DAOUsuario daoim=new DAOUsuario();
		
		usu.setUsuariocl2("EFRAIN");
		usu.setPasswordcl2("123");
		daoim.RegistrarUsuario(usu);
	}

}
