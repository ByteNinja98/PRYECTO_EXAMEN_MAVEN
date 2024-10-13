package TestEntidades;

import DAOImplements.DAOProveedor;
import model.TblProveedorcl2;

public class TESTProveedor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TblProveedorcl2 pro=new TblProveedorcl2();
		DAOProveedor daopro=new DAOProveedor();
		
		pro.setNomproveecl2("RENAN");
		pro.setRucproveecl2("FAST");
		pro.setRsocialproveecl2("FACEBOOK");
		pro.setEmailproveecl2("FAST@GMAIL.COM");
		pro.setFeingproveecl2(null);
		
		daopro.RegistrarProveedor(pro);
	}

}
