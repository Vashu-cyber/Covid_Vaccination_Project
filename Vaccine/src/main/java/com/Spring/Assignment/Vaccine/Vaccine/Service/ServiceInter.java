package com.Spring.Assignment.Vaccine.Vaccine.Service;

import java.util.List;

import com.Spring.Assignment.Vaccine.Vaccine.Entity.Citizen;
import com.Spring.Assignment.Vaccine.Vaccine.Entity.CountDose;

public interface ServiceInter {

		
		public List<Citizen> findByAll();
		public Citizen findById(int id);
		public void save(Citizen citizen);
		public void deleteById(int id);

		public List<Citizen> findByType(String type);
		public List<CountDose> countByType();

	}

	

