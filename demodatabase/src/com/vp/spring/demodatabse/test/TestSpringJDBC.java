package com.vp.spring.demodatabse.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vp.spring.dao.jdbc.IEmployeDao;
import com.vp.spring.demodatabase.SpringJDBC;
import com.vp.spring.service.EmployeService;

import domaine.Employe;
import junit.framework.TestCase;

public class TestSpringJDBC extends TestCase {

private Employe emp, emp2 ;
private String beanDataSource;
private SpringJDBC springjdbc ;
private IEmployeDao springDao;
private ClassPathXmlApplicationContext appContext;
EmployeService empServ;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		emp = new Employe(4,"morad","mdpobjis","Morad","HANAFI","morad.hanafi@objis.com","employe");
		//emp2 = new Employe(5,"morad","mdpobjis","Morad","HANAFI","morad.hanafi@objis.com","employe");
		//beanDataSource = "datasource2";
        //springjdbc = new SpringJDBC();
		
		appContext = new ClassPathXmlApplicationContext("spring-data.xml");

		
		// Recuperation du Bean Dao
		springDao = (IEmployeDao) appContext.getBean("employeDao");
		empServ = (EmployeService) appContext.getBean("empService");
		
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		emp = null;
		appContext = null;
		springDao = null;
	}

	public  void testSaveEmploye(){
		//springjdbc.saveEmploye(emp, beanDataSource);
		springDao.saveEmploye(emp);
	}
	
//	public void testSaveEmployeJdbcTemplate(){
//		Employe empTest;
//		springjdbc.saveEmployeJdbcTemplate(emp2);
//		empTest = springjdbc.getEmployebyId(5);
//		assertNotNull(empTest);
//		
//	}
	public void testGetEmployeById(){
		//Employe employe = springjdbc.getEmployebyId(2);
		Employe employe  = springDao.getEmployeById(2);
		assertNotNull(employe);
	}
	
	public void testSaveEmployeService(){
		
		empServ.sauverEmploye(emp);
		
	}
}
