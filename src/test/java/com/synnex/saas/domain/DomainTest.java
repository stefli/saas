package com.synnex.saas.domain;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.synnex.saas.platform.domain.CodeType;

public class DomainTest {

	private static final String PERSISTENCE_UNIT_NAME = "defaultPU";
	private static EntityManagerFactory factory;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		HashMap<String, String> properties = new HashMap<String, String>();
		properties.put("tenant_id", "STEVEN");
		properties.put("eclipselink.session-name", "multi-tenant-dev");
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, properties);
		EntityManager em = factory.createEntityManager();

		// create new Domain
		em.getTransaction().begin();
		CodeType domain = new CodeType();
		domain.setName("This is a test");
		em.persist(domain);
		em.getTransaction().commit();

		// read the existing entries and write to console
		Query q = em.createQuery("select t from Domain t");
		List<CodeType> domainList = q.getResultList();
		for (CodeType dom : domainList) {
			System.out.println(dom);
		}
		System.out.println("Size: " + domainList.size());

		em.close();
	}

}
