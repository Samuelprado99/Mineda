package br.gov.sp.fatec.springboot3app2025.service;

import java.util.List;

import br.gov.sp.fatec.springboot3app2025.entity.Usuario;
public interface UsuarioService {

    public Usuario novo(Usuario usuario);

    public List<Usuario> buscarTodos();

    public Usuario buscarPeloId(Long id);
    

}