/*
 *  Name:            Rutvik Patel
 *  Student Number:        040915445
 *  Class Name:     SpriteFacade
 */
package cst8218.pate0635.entity;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tgk
 */
@DeclareRoles({"JsfGroup"})
@RolesAllowed({"JsfGroup"})
@Stateless
public class SpriteFacade extends AbstractFacade<Sprite> {
    @PersistenceContext(unitName = "SpriteRutvik-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SpriteFacade() {
        super(Sprite.class);
    }
    
}
