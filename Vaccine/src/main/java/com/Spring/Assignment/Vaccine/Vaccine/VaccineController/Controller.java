package com.Spring.Assignment.Vaccine.Vaccine.VaccineController;
//package com.Spring.Assignment.Vaccine.Vaccine.bootException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Assignment.Vaccine.Vaccine.Entity.Citizen;
import com.Spring.Assignment.Vaccine.Vaccine.Entity.CountDose;
import com.Spring.Assignment.Vaccine.Vaccine.Service.ServiceImplement;
import com.Spring.Assignment.Vaccine.Vaccine.bootException.CitizenNotFound;

@RestController
@RequestMapping("/covid")
public class Controller {
	  public static SimpleDateFormat ddmmyy=new SimpleDateFormat("dd/mm/yyyy");
	public ServiceImplement serviceImplement;
	
	public Controller(ServiceImplement theServiceImplement) {
		serviceImplement = theServiceImplement ;
	}
    
	@GetMapping("/status")
	public List<Citizen> findByAll(){
		return serviceImplement.findByAll();
	}
	@GetMapping("/status/{id}")
	public Citizen findById(@PathVariable int id) {
		Citizen citizen = serviceImplement.findById(id);
	if(citizen==null) {
		throw new CitizenNotFound("PanID :- "+id+"  Is not present in the Table");
	}
	return citizen;
	}
	
	@PostMapping("/status")
	public Citizen add(@RequestBody Citizen citizen) {
		
		int tempId=citizen.getPanID();
		Citizen theCitizen=serviceImplement.findById(tempId);
		if(theCitizen==null) {
		Date dose1=citizen.getDose1();
		Date dose2=citizen.getDose2();
		Date dose3=citizen.getDose3();
			

	if(dose1==null && dose2==null  && dose3==null ) {
		citizen.setReport(0);
		citizen.setVactype(null);
		citizen.setStatus("Not Vaccinated");
		serviceImplement.save(citizen);
		return citizen;
	}else if(dose1!=null && dose2==null && dose3==null) {
		citizen.setReport(1);
		citizen.setStatus("Partial Vaccinated");
		serviceImplement.save(citizen);
		return citizen;
	}else if(dose1!=null && dose2!=null && dose3==null) {
		citizen.setReport(2);
		citizen.setStatus("Full Vaccinated");
		long dose2Dose1 = dose2.getTime()-dose1.getTime();
		dose2Dose1=TimeUnit.MILLISECONDS.toDays(dose2Dose1);
		if(dose2Dose1 > 120) {
			serviceImplement.save(citizen);
			return citizen;
		}
	}else if(dose1!=null && dose2!=null && dose3!=null ) {
		citizen.setReport(3);
		citizen.setStatus("Booster Vaccinated");
		long dose2Dose1 = dose2.getTime()-dose1.getTime();
		dose2Dose1=TimeUnit.MILLISECONDS.toDays(dose2Dose1);
		long dose3Dose2 = dose3.getTime()-dose2.getTime();
		dose3Dose2=TimeUnit.MILLISECONDS.toDays(dose3Dose2);
		
		if(dose2Dose1 > 120 && dose3Dose2 > 270) {
			serviceImplement.save(citizen);
			return citizen;
		}
	}
	throw new RuntimeException("Invalid Exception");
		}else
		{
			throw new CitizenNotFound("Id is already present");
		}
		
	}
	
	@PutMapping("/status")
	public Citizen update(@RequestBody Citizen citizen) {
		int tempId=citizen.getPanID();
		Citizen theCitizen=serviceImplement.findById(tempId);
		if(theCitizen!=null) {
		Date dose1=citizen.getDose1();
		Date dose2=citizen.getDose2();
		Date dose3=citizen.getDose3();
			

	if(dose1==null && dose2==null  && dose3==null ) {
		citizen.setReport(0);
		citizen.setVactype(null);
		citizen.setStatus("Not Vaccinated");
		serviceImplement.save(citizen);
		return citizen;
	}else if(dose1!=null && dose2==null && dose3==null) {
		citizen.setReport(1);
		citizen.setStatus("Partial Vaccinated");
		serviceImplement.save(citizen);
		return citizen;
	}else if(dose1!=null && dose2!=null && dose3==null) {
		citizen.setReport(2);
		citizen.setStatus("Full Vaccinated");
		long dose2Dose1 = dose2.getTime()-dose1.getTime();
		dose2Dose1=TimeUnit.MILLISECONDS.toDays(dose2Dose1);
		if(dose2Dose1 > 120) {
			serviceImplement.save(citizen);
			return citizen;
		}
	}else if(dose1!=null && dose2!=null && dose3!=null ) {
		citizen.setReport(3);
		citizen.setStatus("Booster Vaccinated");
		long dose2Dose1 = dose2.getTime()-dose1.getTime();
		dose2Dose1=TimeUnit.MILLISECONDS.toDays(dose2Dose1);
		long dose3Dose2 = dose3.getTime()-dose2.getTime();
		dose3Dose2=TimeUnit.MILLISECONDS.toDays(dose3Dose2);
		
		if(dose2Dose1 > 120 && dose3Dose2 > 270) {
			serviceImplement.save(citizen);
			return citizen;
		}
	}
	throw new RuntimeException("Invalid Exception");
		}else
		{
			throw new CitizenNotFound("Id is not already present");
		}
		
	}
	
	@DeleteMapping("/status/{id}")
	public String deleteById(@PathVariable int id) {
		Citizen citizen = serviceImplement.findById(id);
	if(citizen==null) {
		return "Citizen ID :- "+id+"  is not present int the Table";
	}
	
	
	if(citizen.getDose3()!=null)
	{serviceImplement.deleteById(id);
	return " Citizen is Delete in the Table";

	}
	return " Citizen is Present But Not Booster Vaccinated ";
	}
	
	
	@GetMapping("/status/vaccine/{type}")
    public List<Citizen> findByType(@PathVariable String type) 
	{
//		List<Citizen> typeCitizen = serviceImplement.findByAll();
	List<Citizen> citizenData = serviceImplement.findByType(type);
//		for(Citizen i : typeCitizen) {
//		if(i.getVactype()==(type)) {
//			citizenData.add(i);
//		}
//	}
		return citizenData;
	
}
	@GetMapping("/status/count")
	public List<CountDose> countByType(){	

return serviceImplement.countByType();
		
	}

}

