/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.tp.integrador.servicio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utn.frsf.ofa.cursojava.tp.integrador.modelo.Pedido;

/**
 *
 * @author cgfeller
 */
@Stateless
public class PedidoService {

    @PersistenceContext(unitName = "RECETAS_PU")
    private EntityManager em;

    public Pedido guardar(Pedido a) {
        em.persist(a);
        em.flush();
        em.refresh(a);
        return a;

    }

}
