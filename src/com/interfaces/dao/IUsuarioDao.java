package com.interfaces.dao;

import java.util.List;

import com.entitie.Usuario;

public interface IUsuarioDao {
	public List<Usuario> listaUsuario(int pagInicio, int pagFin, Usuario Usuario);
	public List<Usuario>  login(String usuario, String pass);

}
