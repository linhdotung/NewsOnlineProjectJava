/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import entityBean.BlackListWords;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Welcome
 */
@Stateless
public class BlackListWordsFacade extends AbstractFacade<BlackListWords> {
    @PersistenceContext(unitName = "ProjectSem4NewsOnline-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public BlackListWordsFacade() {
        super(BlackListWords.class);
    }
    
}
