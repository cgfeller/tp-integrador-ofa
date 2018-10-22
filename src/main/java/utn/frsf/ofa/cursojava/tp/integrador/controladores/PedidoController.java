/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.tp.integrador.controladores;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import utn.frsf.ofa.cursojava.tp.integrador.modelo.Pedido;
import utn.frsf.ofa.cursojava.tp.integrador.modelo.Receta;
import utn.frsf.ofa.cursojava.tp.integrador.servicio.PedidoService;
import utn.frsf.ofa.cursojava.tp.integrador.servicio.RecetaService;

/**
 *
 * @author cgfeller
 */
@SessionScoped
@Named("pedidoController")
public class PedidoController implements Serializable {

    @Inject
    private PedidoService pedidoService;
    @Inject
    private RecetaService recetaService;
    private Pedido pedidoSeleccionado;
    private List<Receta> listaRecetas;

    @PostConstruct
    public void init() {
        this.pedidoSeleccionado = null;
        this.listaRecetas = recetaService.listar();
    }

    public PedidoService getPedidoService() {
        return pedidoService;
    }

    public void setPedidoService(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }
    
        public List<Receta> getListaRecetas() {
        return listaRecetas;
    }

    public void setListaRecetas(List<Receta> listaRecetas) {
        this.listaRecetas = listaRecetas;
    }

    public String guardar() {
        Pedido tmp = this.pedidoService.guardar(pedidoSeleccionado);
        this.pedidoSeleccionado = null;
        return null;
    }
    
    public String nuevo() {
        this.pedidoSeleccionado = new Pedido();
        return null;
    }

    public Pedido getPedidoSeleccionado() {
        return pedidoSeleccionado;
    }

    public void setPedidoSeleccionado(Pedido pedidoSeleccionado) {
        this.pedidoSeleccionado = pedidoSeleccionado;
    }
    
    
}
