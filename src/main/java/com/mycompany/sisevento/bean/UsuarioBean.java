/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sisevento.bean;

import com.mycompany.sisevento.controller.UsuarioController;
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

    private Usuario usuario;

    private List<Usuario> listUsuario = new ArrayList<Usuario>();

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
    
    

}
