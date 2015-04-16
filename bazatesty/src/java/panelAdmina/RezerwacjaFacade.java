/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panelAdmina;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bartosz
 */
@Stateless
public class RezerwacjaFacade extends AbstractFacade<Rezerwacja> {
    @PersistenceContext(unitName = "bazatestyPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RezerwacjaFacade() {
        super(Rezerwacja.class);
    }
    
}
