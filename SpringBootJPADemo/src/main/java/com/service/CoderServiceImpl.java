package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.entity.Coder;
import com.repository.CoderRepo;

@Service
public class CoderServiceImpl implements CoderService {

	@Autowired
	CoderRepo coderRepo;
	
	@Override
	public  List<Coder> getCoders() {
		List<Coder> coderList=coderRepo.findAll();
		return coderList;
	}

	@Override
	public Coder getCoderById(int id) {
		Coder c=coderRepo.findById(id).orElseThrow();
		return c;
	}

	@Override
	public Coder addCoder(Coder coder) {
		Coder c=coderRepo.save(coder);
		return c;
	}
	
	public List<Coder> addBatchCoder(List<Coder> coders){
		List<Coder> listCoder=coderRepo.saveAll(coders);
		return listCoder;
	}
	public Coder updateCoder(Coder coder) throws Exception {
		Supplier<Exception> s1=()->new ResourceNotFoundException("Coder Id is not present in the Database");
		Coder c=coderRepo.findById(coder.getCid()).orElseThrow(s1);
		c.setCname(coder.getCname());
		c.setTech(coder.getTech());
		coderRepo.save(c);
		return c;
	}
	
	public String deleteCoder(Coder coder) {
		coderRepo.delete(coder);
		return "deleted";
	}
	
	public String deleteCoderById(int cid) {
		coderRepo.deleteById(cid);
		return "deleted";
	}

	public Coder getCoderByCname(String cname) {
		Coder c=coderRepo.findByCname(cname);
		return c;
	}
	
	public List<Coder> getCoderByTechSorted(String tech){
		List<Coder> sortedCoders=coderRepo.findByTechSorted(tech);
		return sortedCoders;
	}
	
}
