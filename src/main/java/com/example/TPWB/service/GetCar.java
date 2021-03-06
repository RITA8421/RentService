package com.example.TPWB.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.example.TPWB.domain.Vehicule;

public class GetCar {//显示特定车辆信息
	EntityManagerFactory emf;
	EntityManager entityManager;
	EntityTransaction tx;
	
	public GetCar(){
		this.emf = Persistence.createEntityManagerFactory("manager1");
		this.entityManager = emf.createEntityManager();
		this.tx = entityManager.getTransaction();
		}
	
	public Vehicule getacar(String plateNumber) {
		List Vehiculelist = entityManager.createNativeQuery("Select V_ID from Vehicule where platnumber = ?1").setParameter(1,plateNumber).getResultList();
		long id = (long)Vehiculelist.iterator().next();
		Vehicule vehicule = new Vehicule();
        vehicule = entityManager.find(Vehicule.class,id);
        return vehicule;
	}

}
