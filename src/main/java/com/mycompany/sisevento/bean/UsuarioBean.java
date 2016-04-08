/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sisevento.bean;

import com.mycompany.sisevento.controller.TipoUsuarioController;
import com.mycompany.sisevento.controller.UsuarioController;
import com.mycompany.sisevento.entity.TipoUsuario;
import com.mycompany.sisevento.entity.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author fpcarlos
 */
@Named
@SessionScoped
public class UsuarioBean extends AbstractBean implements Serializable {

    @EJB
    private UsuarioController usuarioController;

    @EJB
    private TipoUsuarioController tipoUsuarioController;

    private Usuario usuario;

    private List<Usuario> listUsuario = new ArrayList<Usuario>();

    private List<TipoUsuario> listTipoUsuario = new ArrayList<TipoUsuario>();

    public UsuarioBean() {
    }

    public String abrirListaUsuarios() {
        try {
            listUsuario = new ArrayList<>();
            listUsuario = usuarioController.findAll();
            return redirect("/sistema/usuario/listaUsuarios.xhtml");
        } catch (Exception e) {
            return null;
        }

    }

    public void salvarUsuario() {
        try {
            usuarioController.salvar(usuario);
            showFacesMessage("salvo com sucesso!!!", 2);
            listUsuario = new ArrayList<>();
            listUsuario = usuarioController.findAll();
        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
        }
    }

    public String prepararEditaUsuario(Usuario aux) {
        try {
            usuario = usuarioController.pegaUsuarioId(aux.getId());
            listUsuario = new ArrayList<>();
            listUsuario = usuarioController.findAll();
            listTipoUsuario = new ArrayList<>();
            listTipoUsuario = tipoUsuarioController.findAll();
            return redirect("/sistema/usuario/formUsuario.xhtml");

        } catch (Exception e) {
            return null;
        }
    }

    public String prepararCadastroUsuario() {
        try {
            usuario = new Usuario();
            listUsuario = new ArrayList<>();
            listUsuario = usuarioController.findAll();
            listTipoUsuario = new ArrayList<>();
            listTipoUsuario = tipoUsuarioController.findAll();
            return redirect("/sistema/usuario/formUsuario.xhtml");
        } catch (Exception e) {
            return null;
        }
    }

    public String removeUsuario(Usuario aux) {
        try {
            
            usuarioController.remove(aux);
            showFacesMessage("Usuário deletado com sucesso!!!", 2);
            usuario = new Usuario();
            listUsuario = new ArrayList<>();
            listUsuario = usuarioController.findAll();
            listTipoUsuario = new ArrayList<>();
            listTipoUsuario = tipoUsuarioController.findAll();
            return redirect("/sistema/usuario/formUsuario.xhtml");

        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            return null;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }

    public List<TipoUsuario> getListTipoUsuario() {
        return listTipoUsuario;
    }

    public void setListTipoUsuario(List<TipoUsuario> listTipoUsuario) {
        this.listTipoUsuario = listTipoUsuario;
    }

}
