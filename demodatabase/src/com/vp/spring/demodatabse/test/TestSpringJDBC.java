package com.vp.spring.demodatabse.test;

import com.vp.spring.demodatabase.SpringJDBC;

import domaine.Employe;
import junit.framework.TestCase;

public class TestSpringJDBC extends TestCase {

private Employe emp, emp2 ;
private String beanDataSource;
private SpringJDBC springjdbc ;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		emp = new Employe(4,"morad","mdpobjis","Morad","HANAFI","morad.hanafi@objis.com","employe");
		emp2 = new Employe(5,"morad","mdpobjis","Morad","HANAFI","morad.hanafi@objis.com","employe");
		beanDataSource = "datasource2";
        springjdbc = new SpringJDBC();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		emp = null;
	}

	public  void testSaveEmploye(){
		springjdbc.saveEmploye(emp, beanDataSource);
	}
	
//	public void testSaveEmployeJdbcTemplate(){
//		Employe empTest;
//		springjdbc.saveEmployeJdbcTemplate(emp2);
//		empTest = springjdbc.getEmployebyId(5);
//		assertNotNull(empTest);
//		
//	}
	public void testGetEmployeById(){
		Employe employe = springjdbc.getEmployebyId(2);
		assertNotNull(employe);
	}
}
