package cz.o2.tvs.db;


import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class NG_STB_ServiceFacade {
    private final EntityManager em;

    public NG_STB_ServiceFacade() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PrjServletRequestSTB-1");
        em = emf.createEntityManager();
    }

    /**
     * All changes that have been made to the managed entities in the
     * persistence context are applied to the database and committed.
     */
    public void commitTransaction() {
        final EntityTransaction entityTransaction = em.getTransaction();
        if (!entityTransaction.isActive()) {
            entityTransaction.begin();
        }
        entityTransaction.commit();
    }

    public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    public <T> T persistEntity(T entity) {
        em.persist(entity);
        commitTransaction();
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        entity = em.merge(entity);
        commitTransaction();
        return entity;
    }

    public CurrentStbVersionFw persistCurrentStbVersionFw(CurrentStbVersionFw currentStbVersionFw) {
        em.persist(currentStbVersionFw);
        commitTransaction();
        return currentStbVersionFw;
    }
    
    public RegisterFw persistRegisterFw(RegisterFw registerFw) {
        em.persist(registerFw);
        commitTransaction();
        return registerFw;
    }

    /** <code>select o from CurrentStbVersionFw o</code> */
    public List<CurrentStbVersionFw> getCurrentStbVersionFwFindAll() {
        return em.createNamedQuery("CurrentStbVersionFw.findAll", CurrentStbVersionFw.class).getResultList();
    }
    
    /** <code>select o from RegisterFw o</code> */
    public List<RegisterFw> getRegisterFwFindAll() {
        return em.createNamedQuery("RegisterFw.findAll", RegisterFw.class).getResultList();
    }
    
    /** <code>select o from Model o</code> */
    public List<Model> getModelFindAll() {
        return em.createNamedQuery("Model.findAll", Model.class).getResultList();
    }
    
    /** <code>select o from ImageStb o</code> */
    public List<ImageStb> getImageStbFindAll() {
        return em.createNamedQuery("ImageStb.findAll", ImageStb.class).getResultList();
    }
    
    /** <code>select o from CategoryStb o</code> */
    public List<Category> getCategoryFindAll() {
        return em.createNamedQuery("Category.findAll", Category.class).getResultList();
    }
    
    public int getCountSTBbyMAC(){
        String sqlString = "select count(DISTINCT MAC) from stb;";
        Long result=(Long) em.createNativeQuery(sqlString).getSingleResult();        
        return result.intValue();
    }
    
    
}
