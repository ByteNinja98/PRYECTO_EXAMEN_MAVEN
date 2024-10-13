package Interfaces;

import java.util.List;

import model.TblProveedorcl2;

public interface IProveedor {
	void RegistrarProveedor(TblProveedorcl2 pro);
	void ActualizarProveedor(TblProveedorcl2 pro);
	void EliminarProveedor(TblProveedorcl2 pro);
	List<TblProveedorcl2> ListarProveedor();
	TblProveedorcl2 BuscarProveedor(TblProveedorcl2 pro);
}
