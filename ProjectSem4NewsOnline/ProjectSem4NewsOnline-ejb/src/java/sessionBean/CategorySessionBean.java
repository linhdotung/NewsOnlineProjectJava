/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import entityBean.Category;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Welcome
 */
@Stateless
@LocalBean
public class CategorySessionBean {
    @EJB
    private CategoryFacade categoryFacade;
    
    
    @PersistenceContext(unitName = "ProjectSem4NewsOnline-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //lay ra category va subcategory
    
    public List<Category> getAllCategoryAndSubCategory(){
        return em.createQuery("select c from Category c ").getResultList();
    }
    
    //lay ra cac category 
    public List<Category> getAllCategory() {
        
        return em.createQuery("select c from Category c where c.fatherID = 0").getResultList();
    }
    
    //lay ra cac subcategory
    public List<Category> getAllSubCategoryByFatherID( int fatherID){
        return em.createQuery("select c from Category c where c.c_fatherID = :cFatherID")
                .setParameter("cFatherID", fatherID)
                .getResultList();
    }
    
    //disable 1 category hoac subcategory 
    public void disableCategory(int c_id)
    {
        //lay ra category can disable
        Query query1 = em.createQuery("select c from Category c where c.c_id = :cID")
                .setParameter("cID", c_id);
        Category c =(Category) query1.getSingleResult();
        c.setCDelete(Boolean.TRUE);//set ve true de disable
        categoryFacade.edit(c);//thuc hien edit category
    }
    
    //edit 1 category 
    public void editCategory(Category c){
        categoryFacade.edit(c);
        
    }
    //them 1 category 
    public void insertCategory(Category c){
        categoryFacade.create(c);
        
    }
            
    
}
