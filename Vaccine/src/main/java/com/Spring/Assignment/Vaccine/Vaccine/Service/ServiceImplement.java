package com.Spring.Assignment.Vaccine.Vaccine.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Spring.Assignment.Vaccine.Vaccine.DAO.DAOImplement;
import com.Spring.Assignment.Vaccine.Vaccine.Entity.Citizen;
import com.Spring.Assignment.Vaccine.Vaccine.Entity.CountDose;
import com.Spring.Assignment.Vaccine.Vaccine.Entity.PERSON;

@Service
public class ServiceImplement implements ServiceInter {

	public DAOImplement daoImplement;
	
	public ServiceImplement(DAOImplement theDAOImplement) {
		daoImplement  = theDAOImplement;
	}

	@Override
	@Transactional
	public List<Citizen> findByAll() {
	      
		return daoImplement.findByAll();
	}
	@Override
	@Transactional
	public List<Citizen> findByType(String type) {
	      
		return daoImplement.findByType(type);
	}

	@Override
	@Transactional
	public Citizen findById(int id) {
		return daoImplement.findById(id);
	}

	@Override
	@Transactional
	public void save(Citizen person) {
		daoImplement.save(person);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		daoImplement.deleteById(id);
		
	}
@Override
@Transactional
public List<CountDose> countByType() {
	
	return daoImplement.countByType();
} 
}
