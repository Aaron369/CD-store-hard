package com.qa.cdstore.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

//import org.apache.log4j.Logger;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;

@Stateless
@Default
public class DBCDServiceImp implements CDService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	//private static final Logger LOGGER = Logger.getLogger(DBCDServiceImp.class);

	@Inject
	private JSONUtil util;

	@Override
	public String getAllCds() {
		Query query = em.createQuery("SELECT e FROM CD e");
		//LOGGER.info("About to get a query from the DB");
		Collection<CD> cds = (Collection<CD>) query.getResultList();
		return util.getJSONForObject(cds);
	}

	@Override
	public String addNewCd(String cdJson) {
		CD newCd = util.getObjectForJSON(cdJson, CD.class);
		em.persist(newCd);
		return cdJson;
	}

	@Override
	public String replaceCd(Integer cdId, String updatedCd) {
		CD updateCd = util.getObjectForJSON(updatedCd, CD.class);
		CD cd = findCd(new Long(cdId));
		if (cd != null) {
			cd = updateCd;
			em.merge(cd);
		}
		return "{\"message\": \"cd updated\"}";
	}

	@Override
	public String deleteCd(Integer cdId) {
		CD cd = findCd(new Long(cdId));
		if (cd != null) {
			em.remove(cd);
		}
		return "{\"message\": \"cd removed\"}";
	}

	private CD findCd(Long id) {
		return em.find(CD.class, id);
	}

}
