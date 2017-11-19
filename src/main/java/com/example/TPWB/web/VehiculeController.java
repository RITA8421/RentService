package com.example.TPWB.web;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.w3c.dom.stylesheets.LinkStyle;

import com.example.TPWB.domain.*;
import com.example.TPWB.service.GetCar;
import com.example.TPWB.service.RentCar;
import com.example.TPWB.service.ReturnCar;
import com.example.TPWB.service.ShowCars;

@Controller
public class VehiculeController {
	EntityManagerFactory emf;
	EntityManager entityManager;
	EntityTransaction tx;
	
	@RequestMapping(value = "/cars", method = RequestMethod.GET) @ResponseStatus(HttpStatus.OK)//显示全部未租车
	@ResponseBody
	public List<Vehicule> listOfCars(){
		ShowCars sCar = new ShowCars();
		return sCar.display();
	}
	
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)//获取一辆特定的车
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Vehicule aCar(@PathVariable("plateNumber") String plateNumber) throws Exception{
		GetCar gCar = new GetCar();
		return gCar.getacar(plateNumber); 
	}
	
	@RequestMapping(value = "/rcars/{plateNumber}", method = RequestMethod.PUT)//租车
	@ResponseStatus(HttpStatus.OK)
	public void rent(@PathVariable("plateNumber") String plateNumber) throws Exception {
		RentCar rCar = new RentCar();
		rCar.rentcar(plateNumber);
	}
	
	@RequestMapping(value = "/bcars/{plateNumber}", method = RequestMethod.DELETE)//还车
	@ResponseStatus(HttpStatus.OK)
	public void getBack(@PathVariable("plateNumber") String plateNumber) throws Exception {
		ReturnCar bCar = new ReturnCar();
		bCar.returncar(plateNumber);
	}
		public VehiculeController() {//构造函数，用于数据库交互
		emf = Persistence.createEntityManagerFactory("manager1");
		entityManager = emf.createEntityManager();
		tx = entityManager.getTransaction();
	}

}
