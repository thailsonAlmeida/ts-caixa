package com.caixa.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.caixa.demo.entities.Deposit;
import com.caixa.demo.entities.Physical;
import com.caixa.demo.patterns.DepositSubscriberObserver;

public class DepositDTO implements Serializable, DepositSubscriberObserver {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long agency;
	private String account;
	private Long bank;
	private Double balance;
	
	private List<PhysicalDTO> physicalsPerson = new ArrayList<>();
	
	public DepositDTO() {}

	public DepositDTO(Long id, Long agency, String account, Long bank, Double balance) {
		super();
		this.id = id;
		this.agency = agency;
		this.account = account;
		this.bank = bank;
		this.balance = balance;
	}
	
	public DepositDTO(Deposit entity) {
		this.id = entity.getId();
		this.agency = entity.getAgency();
		this.account = entity.getAccount();
		this.bank = entity.getBank();
		this.balance = entity.getBalance();
	}
	
	public DepositDTO(Deposit entity, Set<Physical> physicals) {
		this(entity);
		physicals.forEach(physic -> this.physicalsPerson.add(new PhysicalDTO(physic)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAgency() {
		return agency;
	}

	public void setAgency(Long agency) {
		this.agency = agency;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Long getBank() {
		return bank;
	}

	public void setBank(Long bank) {
		this.bank = bank;
	}

	public Double getBalance() {		
		return balance;
	}
	
	

	public void setBalance(Double balance) {
		if(this.balance != balance) {
			update();
		}
		this.balance = balance;
	}

	public List<PhysicalDTO> getPhysicalsPerson() {
		return physicalsPerson;
	}

	public void setPhysicalsPerson(List<PhysicalDTO> physicalsPerson) {
		this.physicalsPerson = physicalsPerson;
	}
	
	@Override
	public void update(){
		depositPublisherObserver.notifyMe();
	}
}
