package com.example.demo;

import static org.assertj.core.api.Assertions.entry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;


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


