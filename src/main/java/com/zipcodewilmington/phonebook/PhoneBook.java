package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private String name;
    //private List<String> phoneNumber1;
    private Map<String,List<String>> map;

    public PhoneBook(Map<String, List<String>> map) {
        this.map = map;

    }

    public PhoneBook() {

        this.map = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {

        List<String> phoneNumbers = (this.map.containsKey(name)) ? this.map.get(name) : new ArrayList<>();
        phoneNumbers.add(phoneNumber);
        this.map.put(name, phoneNumbers);


    }

    public void addAll(String name, String... phoneNumbers) {

        List<String> phoneNumbersFromMap = (this.map.containsKey(name)) ? this.map.get(name) : new ArrayList<>();
        phoneNumbersFromMap.addAll(Arrays.asList(phoneNumbers));
        this.map.put(name, phoneNumbersFromMap);
        //for(String pn : phoneNumbers) {
            //phoneNumber1.addAll(this.name, this.phoneNumber1);
        //}
    }

    public void remove(String name) {

        this.map.remove(name);
    }

    public Boolean hasEntry(String name) {

        return this.map.containsKey(name);
    }

    public List<String> lookup(String name) {
        return this.map.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        Set<Map.Entry<String,List<String>>> entries = this.map.entrySet();
        for(Map.Entry<String, List<String>> entry: entries) {
            if(entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(this.map.keySet());
    }

    public Map<String, List<String>> getMap() {
        return this.map;
    }
}
