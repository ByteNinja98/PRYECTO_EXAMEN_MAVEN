package Interfaces;

import java.util.List;

import model.TblUsuariocl2;

public interface IUsuario {
	void RegistrarUsuario(TblUsuariocl2 usu);
	void ActualizarUsuario(TblUsuariocl2 usu);
	void EliminarUsuario(TblUsuariocl2 usu);
	List<TblUsuariocl2> ListarUsuario();
	TblUsuariocl2 BuscarUsuario(TblUsuariocl2 usu);
}
