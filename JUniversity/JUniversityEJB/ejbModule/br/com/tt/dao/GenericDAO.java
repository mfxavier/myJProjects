package br.com.tt.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class GenericDAO<T> {
    private final static String UNIT_NAME = "juniversity";

    @PersistenceContext(unitName = UNIT_NAME)
    private EntityManager em;

    private Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
    	this.entityClass = entityClass;
    }

    public void save(T entity) {
	em.persist(entity);
	em.flush();
    }

    protected void delete(Object id, Class<T> classe) {
	T entityToBeRemoved = em.getReference(classe, id);

	em.remove(entityToBeRemoved);
	em.flush();
    }

    public T update(T entity) {
	return em.merge(entity);
	
    }

    public T find(int entityID) {
	return em.find(entityClass, entityID);
    }

      @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> findAll() {
    	Query q = em.createNamedQuery("Documento.findAll");
    	return q.getResultList();
    }

    // Using the unchecked because JPA does not have a
    // ery.getSingleResult()<T> method
    @SuppressWarnings("unchecked")
    protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
	T result = null;

	try {
	    Query query = em.createNamedQuery(namedQuery);

	    // Method that will populate parameters if they are passed not null and empty
	    if (parameters != null && !parameters.isEmpty()) {
		populateQueryParameters(query, parameters);
	    }

	    result = (T) query.getSingleResult();

	} catch (Exception e) {
	    System.out.println("Error while running query: " + e.getMessage());
	    e.printStackTrace();
	}

	return result;
    }

    private void populateQueryParameters(Query query, Map<String, Object> parameters) {

	for (Entry<String, Object> entry : parameters.entrySet()) {
	    query.setParameter(entry.getKey(), entry.getValue());
	}
    }
}
