package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));assertEquals(list.getCount(),listSize + 1);
    }
    @Test
    public void hasCityTest() {
        list = MockCityList();
        list.addCity(new City("Edmonton", "AB"));
        list.addCity(new City("Calgary", "AB"));
        list.addCity(new City("Vancouver", "BC"));
        list.addCity(new City("Toronto", "ON"));
        list.addCity(new City("Montreal", "QC"));

        assertTrue(list.hasCity(new City("Calgary", "AB")));
        assertFalse(list.hasCity(new City("Winnipeg", "MB")));
    }

    @Test
    public void deleteCityTest() {
        list = MockCityList();
        list.addCity(new City("Edmonton", "AB"));
        list.addCity(new City("Calgary", "AB"));
        list.addCity(new City("Vancouver", "BC"));
        list.addCity(new City("Toronto", "ON"));
        list.addCity(new City("Montreal", "QC"));

        // Delete a city that exists in the list
        int listSize = list.getCount();
        list.deleteCity(new City("Calgary", "AB"));
        assertEquals(list.getCount(), listSize);

        // Delete a city that does not exist in the list
        listSize = list.getCount();
        list.deleteCity(new City("Winnipeg", "MB"));
        assertEquals(list.getCount(), listSize);
    }

//    @Test
//    public void countCitiesTest() {
//        list = MockCityList();
//        list.addCity(new City("Edmonton", "AB"));
//        list.addCity(new City("Calgary", "AB"));
//        list.addCity(new City("Vancouver", "BC"));
//        list.addCity(new City("Toronto", "ON"));
//        list.addCity(new City("Montreal", "QC"));
//
//        assertEquals(list.countCities(), 5);
//    }

}
