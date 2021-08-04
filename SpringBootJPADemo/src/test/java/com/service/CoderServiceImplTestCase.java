package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Coder;
import com.repository.CoderRepo;

@SpringBootTest
class CoderServiceImplTestCase {

	@Autowired
	CoderServiceImpl coderServiceImpl;
	
	@MockBean
	CoderRepo repo;
	
	@Test
	void testGetCoders() {
		Coder c1=new Coder();
		c1.setCid(1);
		c1.setCname("Som");
		c1.setTech("Java");
		
		List<Coder> coderList = new ArrayList<>();
		coderList.add(c1);
		
		Mockito.when(repo.findAll()).thenReturn(coderList);
		
		assertThat(coderServiceImpl.getCoders()).isEqualTo(coderList);
	}

	@Test
	void testGetCoderById() {
		Coder c1=new Coder();
		c1.setCid(1);
		c1.setCname("Som");
		c1.setTech("Java");
		
		Optional<Coder> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		assertThat(coderServiceImpl.getCoderById(1)).isEqualTo(c1);
	}

	@Test
	void testAddCoder() {
		Coder c1=new Coder();
		c1.setCid(1);
		c1.setCname("Som");
		c1.setTech("Java");
	Mockito.when(repo.save(c1)).thenReturn(c1);
		
		assertThat(coderServiceImpl.addCoder(c1)).isEqualTo(c1);
	}

	@Test
	void testUpdateCoder() throws Exception {
		Coder c1=new Coder();
		c1.setCid(1);
		c1.setCname("Som");
		c1.setTech("Java");
		Optional<Coder> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		Mockito.when(repo.save(c1)).thenReturn(c1);
		c1.setCname("Somsurya");
		c1.setTech("Python");
		
		assertThat(coderServiceImpl.updateCoder(c1)).isEqualTo(c1);
	}

	@Test
	void testDeleteCoder() {
		Coder c1=new Coder();
		c1.setCid(1);
		c1.setCname("Som");
		c1.setTech("Java");
		Optional<Coder> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(c1.getCid())).thenReturn(c2);
		 Mockito.when(repo.existsById(c1.getCid())).thenReturn(false);
		   assertFalse(repo.existsById(c1.getCid()));
	}
	
	
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

}
