package com.vp.spring.dao.jdbc;

import java.util.List;

import domaine.Employe;

public interface IEmployeDao {
	
	public Employe getEmployeById(int id);
	public Employe getEmployeByLogin(String login);
	public void saveEmploye(Employe employe);
	public List<Employe> getAllEmployes();
	public int getEmployesCount() ;
}
