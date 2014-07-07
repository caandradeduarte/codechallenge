package com.caioduarte.brasilct.codechallenge.dao.hsql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.caioduarte.brasilct.codechallenge.dao.LineDao;
import com.caioduarte.brasilct.codechallenge.models.Line;

@Repository
public class LineDaoHsql implements LineDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void saveAll(List<Line> lines) {
		lines.forEach(l -> em.persist(l));
		em.flush();
	}

	@Override
	public List<Line> list() {
		TypedQuery<Line> query = em.createQuery("from Line", Line.class);
		return query.getResultList();
	}

}
