package cz.o2.stb.dm;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "STBFacade", mappedName = "CreateDBObj_STB-Model_STB-STBFacade")
public class STBFacadeBean implements STBFacade, STBFacadeLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Model_STB")
    private EntityManager em;

    public STBFacadeBean() {
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
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
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }

    public HistoryEven persistHistoryEven(HistoryEven historyEven) {
        em.persist(historyEven);
        return historyEven;
    }

    public HistoryEven mergeHistoryEven(HistoryEven historyEven) {
        return em.merge(historyEven);
    }

    public void removeHistoryEven(HistoryEven historyEven) {
        historyEven = em.find(HistoryEven.class, historyEven.getId());
        em.remove(historyEven);
    }

    /** <code>select o from HistoryEven o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<HistoryEven> getHistoryEvenFindAll() {
        return em.createNamedQuery("HistoryEven.findAll", HistoryEven.class).getResultList();
    }

    public HistoryOdd persistHistoryOdd(HistoryOdd historyOdd) {
        em.persist(historyOdd);
        return historyOdd;
    }

    public HistoryOdd mergeHistoryOdd(HistoryOdd historyOdd) {
        return em.merge(historyOdd);
    }

    public void removeHistoryOdd(HistoryOdd historyOdd) {
        historyOdd = em.find(HistoryOdd.class, historyOdd.getId());
        em.remove(historyOdd);
    }

    /** <code>select o from HistoryOdd o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<HistoryOdd> getHistoryOddFindAll() {
        return em.createNamedQuery("HistoryOdd.findAll", HistoryOdd.class).getResultList();
    }

    public ImageStb persistImageStb(ImageStb imageStb) {
        em.persist(imageStb);
        return imageStb;
    }

    public ImageStb mergeImageStb(ImageStb imageStb) {
        return em.merge(imageStb);
    }

    public void removeImageStb(ImageStb imageStb) {
        imageStb = em.find(ImageStb.class, imageStb.getId());
        em.remove(imageStb);
    }

    /** <code>select o from ImageStb o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ImageStb> getImageStbFindAll() {
        return em.createNamedQuery("ImageStb.findAll", ImageStb.class).getResultList();
    }

    public Stb persistStb(Stb stb) {
        em.persist(stb);
        return stb;
    }

    public Stb mergeStb(Stb stb) {
        return em.merge(stb);
    }

    public void removeStb(Stb stb) {
        stb = em.find(Stb.class, stb.getId());
        em.remove(stb);
    }

    /** <code>select o from Stb o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Stb> getStbFindAll() {
        return em.createNamedQuery("Stb.findAll", Stb.class).getResultList();
    }

    public Category persistCategory(Category category) {
        em.persist(category);
        return category;
    }

    public Category mergeCategory(Category category) {
        return em.merge(category);
    }

    public void removeCategory(Category category) {
        category = em.find(Category.class, category.getId());
        em.remove(category);
    }

    /** <code>select o from Category o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Category> getCategoryFindAll() {
        return em.createNamedQuery("Category.findAll", Category.class).getResultList();
    }

    public RegisterFw persistRegisterFw(RegisterFw registerFw) {
        em.persist(registerFw);
        return registerFw;
    }

    public RegisterFw mergeRegisterFw(RegisterFw registerFw) {
        return em.merge(registerFw);
    }

    public void removeRegisterFw(RegisterFw registerFw) {
        registerFw = em.find(RegisterFw.class, registerFw.getId());
        em.remove(registerFw);
    }

    /** <code>select o from RegisterFw o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<RegisterFw> getRegisterFwFindAll() {
        return em.createNamedQuery("RegisterFw.findAll", RegisterFw.class).getResultList();
    }
}
