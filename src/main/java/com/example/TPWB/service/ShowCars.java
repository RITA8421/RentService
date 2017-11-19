package com.example.TPWB.service;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.example.TPWB.domain.Vehicule;

public class ShowCars {//显示所有未租车辆
	EntityManagerFactory emf;
	EntityManager entityManager;
	EntityTransaction tx;
	
	public ShowCars(){
	this.emf = Persistence.createEntityManagerFactory("manager1");
	this.entityManager = emf.createEntityManager();
	this.tx = entityManager.getTransaction();
	}
	
	public List<Vehicule> display() {
		List<Vehicule> Vehiculelist = entityManager.createNativeQuery("Select * from Vehicule WHERE IFRENTED IS NULL", Vehicule.class).getResultList();
		return Vehiculelist;
	}

}
