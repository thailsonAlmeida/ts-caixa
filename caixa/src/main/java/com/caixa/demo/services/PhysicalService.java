package com.caixa.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caixa.demo.dto.PhysicalDTO;
import com.caixa.demo.entities.Physical;
import com.caixa.demo.repositories.PhysicalRepository;
import com.caixa.demo.services.exceptions.DataBaseException;
import com.caixa.demo.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;



@Service
public class PhysicalService {
	
	@Autowired
	private PhysicalRepository repository;	
	
	@Transactional(readOnly = true)
	public Page<PhysicalDTO> findAllPaged(PageRequest pageRequest){
		Page<Physical> list = repository.findAll(pageRequest);
		return list.map(x -> new PhysicalDTO(x));
	}

	@Transactional(readOnly = true)
	public PhysicalDTO findById(long id) {
		Optional<Physical> obj = repository.findById(id);
		Physical entity = obj.get();
		return new PhysicalDTO(entity);
	}

	@Transactional
	public PhysicalDTO insert(PhysicalDTO dto) {
		Physical entity = new Physical();
		
		entity.setAddressPerson(dto.getAddressPerson());
		entity.setCpf(dto.getCpf());
		entity.setIcomePerson(dto.getIncomePerson());
		entity.setNamePerson(dto.getNamePerson());
		entity.setpType(dto.ispType());
		entity.setSituationPerson(dto.isSituationPerson());
		
		entity = repository.save(entity);
		
		return new PhysicalDTO(entity);
	}

	@Transactional
	public PhysicalDTO update(Long id, PhysicalDTO dto) {
		try {
			Physical entity = repository.getReferenceById(id);
	
			entity.setAddressPerson(dto.getAddressPerson());
			entity.setCpf(dto.getCpf());
			entity.setIcomePerson(dto.getIncomePerson());
			entity.setNamePerson(dto.getNamePerson());
			entity.setpType(dto.ispType());
			entity.setSituationPerson(dto.isSituationPerson());
			
			entity = repository.save(entity);
			
			return new PhysicalDTO(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} 
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity violatio");
		}
	}	
}
