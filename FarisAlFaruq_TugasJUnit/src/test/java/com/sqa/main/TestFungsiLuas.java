package com.sqa.main;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sqa.main.function.LuasFunction;

public class TestFungsiLuas {
	
	LuasFunction function;

	@Before
	public void setUp() throws Exception {
		function = new LuasFunction();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLuasPersegi() {
		for (String isi : readfile("persegi.csv")) {
			String [] data = isi.split(",");
			String sisi = data[0];
			String jawab = data[1];
			System.out.println(sisi + jawab);
			assertEquals(Double.parseDouble(jawab), function.luasPersegi(Double.parseDouble(sisi)), 0.0);
		}
		
	}
	
	public List<String> readfile(String namefile) {
		List<String> penampung = new ArrayList<String>();
		try {
			InputStream myFile = getClass().getClassLoader().getResourceAsStream(namefile);
			Scanner reader = new Scanner(myFile);
			while(reader.hasNextLine()) {
				penampung.add(reader.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return penampung;
	}

}
