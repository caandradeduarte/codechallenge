package com.caioduarte.brasilct.codechallenge.dao.hsql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.caioduarte.brasilct.codechallenge.dao.RouteDao;
import com.caioduarte.brasilct.codechallenge.models.Route;

@Repository
public class RouteDaoHsql implements RouteDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void saveAll(List<Route> routes) {
		routes.forEach(r -> em.persist(r));
	}

	@Override
	public List<Route> list() {
		TypedQuery<Route> query = em.createQuery("from Route", Route.class);
		return query.getResultList();
	}

}
