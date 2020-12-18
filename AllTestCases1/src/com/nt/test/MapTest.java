package com.nt.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * @) How to Iterate Map?
 *  A) Map should be converted to Entry Set Format(Set<Entry>)
 *  Then it can be iterated.
 *  
 */
public class MapTest {
public static void main(String[] args) {
	//Adding values in HashMap
	Map<String,String> m=new HashMap<>();
	m.put("p1","ABC");
	m.put("p2", "XYZ");
	m.put("p3","MNO");
	
	//Set Entry Format
	Set<Entry<String,String>> set=m.entrySet();
	
	//iterate
	Iterator<Entry<String, String>> itr=set.iterator();
	
	//loop...multiple values so use loop
	while(itr.hasNext()) {
		Entry<String, String> entry=itr.next();
		//read keys and values from Map
		System.out.println(entry.getKey()+"-"+entry.getValue());
	}
	System.out.println("-----------------------------------------");
	//read only values from Map
	Collection<String> values=m.values();
	System.out.println(values);
	System.out.println("-----------------------------------------");
	//read only keys from Map
	Set<String> keys=m.keySet();
	System.out.println(keys);
	
	
}
}
