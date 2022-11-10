package com.Spring.Assignment.Vaccine.Vaccine.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.Spring.Assignment.Vaccine.Vaccine.Entity.Citizen;
import com.Spring.Assignment.Vaccine.Vaccine.Entity.CountDose;

@Repository
public class DAOImplement implements DAOinter{

	public EntityManager entityManager;
	
	public  DAOImplement(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Citizen> findByAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Citizen> theQuery=currentSession.createQuery("from Citizen",Citizen.class);
		
		return theQuery.getResultList();
	}
	


	@Override
	public Citizen findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Citizen citizen=currentSession.get(Citizen.class, id);
		currentSession.clear();
		return citizen;
	}

	@Override
	public void save(Citizen citizen) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(citizen);
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("DELETE FROM Citizen where panID =: theId");
		theQuery.setParameter("theId", id);
		theQuery.executeUpdate();
	}

	@Override
	public List<Citizen> findByType(String type) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Citizen> theQuery=currentSession.createQuery("from Citizen where vactype =: thetype",Citizen.class);
		theQuery.setParameter("thetype", type);
		return theQuery.getResultList();
		}
	
	public List<CountDose> countByType()  {
		Session currentSession = entityManager.unwrap(Session.class);
	
		Query<CountDose> theQuery = currentSession.createQuery("SELECT vactype, count(dose1) , count(dose2),count (dose3) from Citizen group by vaccinetype");

		return theQuery.getResultList();
		
}

}
