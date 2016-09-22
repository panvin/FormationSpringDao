package com.vp.spring.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import domaine.Employe;

@Repository("employeDao")
public class EmployeJdbcDaoSupport extends JdbcDaoSupport implements IEmployeDao {

	public EmployeJdbcDaoSupport() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Employe getEmployeById(int id) {
		// TODO recupération d'un employé en fonction de son Id

		String sql = "select id, nom, prenom from employe where id = ?";

		// Mapping d'un enregistrement vers un ResultSet
		RowMapper mapper = new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employe employe = new Employe();
				employe.setId((int) rs.getLong("id"));
				employe.setNom(rs.getString("nom"));
				employe.setPrenom(rs.getString("prenom"));
				return employe;
			}

		};

		return (Employe) getJdbcTemplate().queryForObject(sql, new Object[] { Long.valueOf(id) }, mapper);

	}

	@Override
	public Employe getEmployeByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveEmploye(Employe employe) {
		final String EMPLOYE_INSERT = "insert into employe (id,login, password, prenom, nom, email, role) "
				+ "values (?,?,?,?,?,?,?)";

		/*
		 * On récupère et on utilisera directement le jdbcTemplate
		 */
		getJdbcTemplate().update(EMPLOYE_INSERT, new Object[] { employe.getId(), employe.getLogin(),
				employe.getPassword(), employe.getPrenom(), employe.getNom(), employe.getEmail(), employe.getRole() });

	}

	@Override
	public List<Employe> getAllEmployes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getEmployesCount() {
		final String EMPLOYE_COUNT = "select count(*) from employe";

		/*
		 * On récupère et on utilisera directement le jdbcTemplate
		 */

		int i = getJdbcTemplate().queryForInt(EMPLOYE_COUNT);

		return i;
	}

}
