package main.java.com.stw.service.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import main.java.com.stw.jpa.CUser;
import main.java.com.stw.service.LoginService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "loginService")
public class LoginServiceImpl implements LoginService, Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	public CUser getLoginUser(String idCode) {

		CUser c = em.find(CUser.class, idCode);

		// StringBuffer sql = new StringBuffer("");
		//
		// sql.append(" SELECT * FROM c_user c ");
		// sql.append(" WHERE c.id_Code = ? ");
		// sql.append(" AND c.pw_Code = ? ");
		//
		// Query query = em.createNativeQuery(sql.toString(), CUser.class);
		//
		// int x = 1;
		//
		// query.setParameter(x++, idCode);
		// query.setParameter(x++, pwCode);
		//
		// CUser resultUser = (CUser) query.getSingleResult();
		//
		// System.out.println("resultUser: " + resultUser);

		return c;
	}

}
