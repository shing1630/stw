package main.java.com.stw.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import main.java.com.stw.jpa.CUser;
import main.java.com.stw.service.CTF0002Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "ctf0002Service")
public class CTF0002ServiceImpl implements CTF0002Service, Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	public List<CUser> getAllUserList() {
		List<CUser> list = em.createNamedQuery("CUser.findAll", CUser.class).getResultList();

		return list;
	}

	public void refresh(CUser c) {
		em.refresh(c);
	}
	

	public CUser find(Object id) {
		CUser c = em.find(CUser.class, id);
		return c;
	}

	@Transactional
	public void createUser(CUser c) {
		em.persist(c);
	}

	public void updateUser(CUser c) {
		em.merge(c);
	}

}
