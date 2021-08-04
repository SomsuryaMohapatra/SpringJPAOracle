package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Coder;
import com.service.CoderServiceImpl;

@RestController
@RequestMapping("/api")
public class HomeRestController {
	
	@Autowired
	CoderServiceImpl coderServiceImpl;
	
	@RequestMapping("/helloRest")
	public String hello() {
		return "welcome to spring rest controller";
	}
	
	@GetMapping("/getCoderRest")
	public ResponseEntity<List<Coder>> getCoder() {
		List<Coder> coderList=coderServiceImpl.getCoders();
		ResponseEntity<List<Coder>> re=new ResponseEntity<>(coderList, HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getCoderByIdRest/{cid}")
	public ResponseEntity<Coder> getCoderById(@PathVariable int cid) {
		Coder coder=coderServiceImpl.getCoderById(cid);
		ResponseEntity<Coder> re=new ResponseEntity<>(coder,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getCoderByCnameRest/{cname}")
	public ResponseEntity<Coder> getCoderByCname(@PathVariable String cname) {
		Coder c=coderServiceImpl.getCoderByCname(cname);
		ResponseEntity<Coder> re=new ResponseEntity<>(c,HttpStatus.OK);
		return re;
	}
	
	@PostMapping("/addCoderRest")
	public ResponseEntity<Coder> addCoder(@RequestBody Coder coder) {
		Coder c=coderServiceImpl.addCoder(coder);
		ResponseEntity<Coder> re=new ResponseEntity<>(c,HttpStatus.OK);
		return re;
	}
	
	@PostMapping("/addCoderBatchRest")
	public ResponseEntity<List<Coder>> addCoders(@RequestBody List<Coder> coders){
		List<Coder> coderList=coderServiceImpl.addBatchCoder(coders);
		ResponseEntity<List<Coder>> re=new ResponseEntity<>(coderList,HttpStatus.OK);
		return re;
	}
	@PutMapping("/updateCoderRest")
	public ResponseEntity<Coder> updateCoder(@RequestBody Coder coder) throws Exception {
		Coder c=coderServiceImpl.updateCoder(coder);
		ResponseEntity<Coder> re=new ResponseEntity<>(c,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping("/deleteCoderRest")
	public ResponseEntity<String> deleteCoder(@RequestBody Coder coder) {
		String res=coderServiceImpl.deleteCoder(coder);
		ResponseEntity<String> re=new ResponseEntity<>(res,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping("/deleteCoderByIdRest/{cid}")
	public ResponseEntity<String> deleteCoderById(@PathVariable int cid) {
		String res=coderServiceImpl.deleteCoderById(cid);
		ResponseEntity<String> re=new ResponseEntity<>(res,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getCoderByTechSortedRest/{tech}")
	public ResponseEntity<List<Coder>> getCoderByTechSorted(@PathVariable String tech){
		List<Coder> coderList=coderServiceImpl.getCoderByTechSorted(tech);
		ResponseEntity<List<Coder>> re=new ResponseEntity<>(coderList,HttpStatus.OK);
		return re;
	}
}
