package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class Controller {
	
	private static Map<String,String> model1 = new HashMap<String,String>();
	private static Map<String,String> model2 = new HashMap<String,String>(); 
	private static Map<String,String> model3 = new HashMap<String,String>();
	private static Map<String,String> model4 = new HashMap<String,String>();
	Collection<Map<String,String>> maListe = new ArrayList<Map<String,String>>();

	@GetMapping()
	@ResponseBody
	  public Collection<Map<String,String>> home() { 
		Collection<Map<String,String>> result = new ArrayList<Map<String,String>>();

	    //TODO ABO : formatage du code
		model1.put("firstName", "issa");
	    model1.put("content", "Hello");
	    model1.put("email", "issa@sodi.fr");
	    model1.put("lastName", "sousou");

	    model2.put("firstName", "abdou");
	    model2.put("content", "world");
	    model2.put("email", "abdou@sodi.fr");
	    model2.put("lastName", "fall");

	    model3.put("firstName", "michel");
	    model3.put("content", "edoua");
	    model3.put("email", "michel@sodi.fr");
	    model3.put("lastName", "bousse");

	    model4.put("firstName", "charles");
	    model4.put("content", "london");
	    model4.put("email", "chadou@sodi.fr");
	    model4.put("lastName", "amichia");

	    result.add(model1);
	    result.add(model2);
	    result.add(model3);
	    result.add(model4);
	    maListe = result;
	    return result;
	  }
	
	@PostMapping("/create")
	@ResponseBody
	public String CreateUser() {
		
		return "User create";
		
	}
	
	
	@DeleteMapping("/del/{id}/{name}")
	@ResponseBody
	public Collection<Map<String,String>> deleteUser(@PathVariable("id") Integer id, @PathVariable ("name") String name) {
		Collection<Map<String,String>> result = new ArrayList<Map<String,String>>(); 
		if (id!=null) {		
			Iterator it =  maListe.iterator();
			while(it.hasNext()) {
				Map<String,String> user = (Map<String, String>) it.next();
				if(user.containsValue(name)) {
					it.remove();
				}
			}
			
//			for (Map<String,String> user : maListe) {
//				if(user.containsValue(name)) {
//					maListe.remove(user);
//					}
//				}
			}
			result = maListe;
			System.out.println(result);
		
		return maListe;
		
	}
	  

	

	}


