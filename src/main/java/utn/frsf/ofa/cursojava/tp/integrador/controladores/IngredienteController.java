package utn.frsf.ofa.cursojava.tp.integrador.controladores;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import utn.frsf.ofa.cursojava.tp.integrador.modelo.Ingrediente;
import utn.frsf.ofa.cursojava.tp.integrador.servicio.IngredienteService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mdominguez
 */
@SessionScoped
@Named("ingredienteController")
public class IngredienteController implements Serializable{
    @Inject 
    private IngredienteService servicioIngrediente;
    
    private Ingrediente ingredienteSeleccionado;
    private List<Ingrediente> listaIngredientes;

    @PostConstruct
    public void init(){
        System.out.println(" POS CONTRUCT ");
        this.ingredienteSeleccionado = null;
        this.listaIngredientes = servicioIngrediente.listar();
    }

    public Ingrediente getIngredienteSeleccionado() {
        return ingredienteSeleccionado;
    }

    public void setIngredienteSeleccionado(Ingrediente ingredienteSeleccionado) {
        this.ingredienteSeleccionado = ingredienteSeleccionado;
    }

    public List<Ingrediente> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(List<Ingrediente> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }
    
    
    
    public String guardar(){
        Ingrediente tmp = this.servicioIngrediente.guardar(ingredienteSeleccionado);
        this.listaIngredientes.add(tmp);
        this.ingredienteSeleccionado = null;
        return "listaIngrediente";
    }

    public String nuevo(){
        System.out.println(" POS NUEVO => => => =>=> =>=");
        this.ingredienteSeleccionado = new Ingrediente();
        return null;
    }    
}
