package com.vp.spring.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import domaine.Employe;

public class EmployeJdbcDaoTemplate implements IEmployeDao {

	private JdbcTemplate jdbcTemplate;

	public EmployeJdbcDaoTemplate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Employe getEmployeById(int id) {
		return this.jdbcTemplate.queryForObject("select id, nom, prenom from employe where id = ?",
				new Object[] { Long.valueOf(id) }, new RowMapper<Employe>() {
					public Employe mapRow(ResultSet rs, int rowNum) throws SQLException {
						Employe employe = new Employe();
						employe.setId((int) rs.getLong("id"));
						employe.setNom(rs.getString("nom"));
						employe.setPrenom(rs.getString("prenom"));
						return employe;
					}
				});
	}

	@Override
	public Employe getEmployeByLogin(String login) {
//		return this.jdbcTemplate.queryForObject("select id, nom, prenom from employe where login = ?",
//				new Object[] { Long.valueOf(id) }, new RowMapper<Employe>() {
//					public Employe mapRow(ResultSet rs, int rowNum) throws SQLException {
//						Employe employe = new Employe();
//						employe.setId((int) rs.getLong("id"));
//						employe.setNom(rs.getString("nom"));
//						employe.setPrenom(rs.getString("prenom"));
//						return employe;
//					}
//				});
		return null;
	}

	@Override
	public void saveEmploye(Employe employe) {
		final String EMPLOYE_INSERT = "insert into employe (id,login, password, prenom, nom, email, role) "
				+ "values (?,?,?,?,?,?,?)";

		/*
		 * On récupère et on utilisera directement le jdbcTemplate
		 */
		jdbcTemplate.update(EMPLOYE_INSERT, new Object[] { employe.getId(), employe.getLogin(), employe.getPassword(),
				employe.getPrenom(), employe.getNom(), employe.getEmail(), employe.getRole() });

	}

	@Override
	public List<Employe> getAllEmployes() {
		return this.jdbcTemplate.query("select id, nom, prenom from employe", new EmployeMapper());
	}

	private static final class EmployeMapper implements RowMapper<Employe> {

		public Employe mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employe employe = new Employe();
			employe.setId((int) rs.getLong("id"));
			employe.setNom(rs.getString("nom"));
			employe.setPrenom(rs.getString("prenom"));
			return employe;
		}
	}

	@Override
	public int getEmployesCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
