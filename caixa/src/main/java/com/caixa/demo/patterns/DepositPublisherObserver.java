package com.caixa.demo.patterns;

import java.util.ArrayList;
import java.util.List;

import com.caixa.demo.dto.PhysicalDTO;

public class DepositPublisherObserver {
	
	List<String> notifyMeBalance = new ArrayList<>();
	
	public void subscribe(PhysicalDTO physical) {
		String name = physical.getAddressPerson();
		notifyMeBalance.add(name);
	}
	
	public void unsubscribe(PhysicalDTO physical) {
		notifyMeBalance.remove(physical.getNamePerson());
	}
	
	public void notifyMe() {
		for (String name : notifyMeBalance) {
			System.out.printf("notificar: " + name);
		}
	}

}
