package com.juaracoding.qa.main;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.juaracoding.qa.function.Function;

public class TestKecepatan {

	Function function;




	@Before
	public void setUp() throws Exception {
			function = new Function();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHitungKecepatan() {
		
		for (String isi : readfile("skenario_kecepatan.csv")) {
			String [] data = isi.split(";");
			String jarak = data[0];
			String waktu = data[1];
			String jawab = data[2];
			Function function = null;
			assertEquals(Double.parseDouble(jawab), function.hitungKecepatan(Double.parseDouble(jarak),(Double.parseDouble(waktu))),0.0);
		}
	}
	
	
	
	
	public List<String> readfile(String namefile){
		
		List<String> penampung = new ArrayList<String>();
		
		try {
			InputStream myFile = getClass().getClassLoader().getResourceAsStream(namefile);
			
			Scanner reader = new Scanner(myFile);
			while(reader.hasNext()) {
				penampung.add(reader.nextLine());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return penampung;
	}
	}

