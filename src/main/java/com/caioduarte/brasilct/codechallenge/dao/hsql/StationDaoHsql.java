package com.caioduarte.brasilct.codechallenge.dao.hsql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.caioduarte.brasilct.codechallenge.dao.StationDao;
import com.caioduarte.brasilct.codechallenge.models.Station;

@Repository
@Component
public class StationDaoHsql implements StationDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void saveAll(List<Station> stations) {
		for(Station station : stations) em.persist(station);
	}

	@Override
	public List<Station> list() {
		TypedQuery<Station> query = em.createQuery("from Station", Station.class);
		return (List<Station>) query.getResultList();
	}

}
