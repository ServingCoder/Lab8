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

    /**
    * get the size of the list
    * increase the list by adding a new city
    * check if our current size matches the initial size
    plus one
    */
    @Test
    public void AddCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void HasCityTest(){
        list = MockCityList();
        City newCity = new City("Charlottetown", "Prince Edward Island");
        //Test if the city is not in the list
        assertFalse(list.hasCity(newCity));
        //add city to the list
        list.addCity(newCity);
        //Test if the city is in the list
        assertTrue(list.hasCity(newCity));

    }

    @Test
    public void DeleteCity(){

        list = MockCityList();
        City newCity = new City("Charlottetown", "Prince Edward Island");
        //add city to the list
        list.addCity(newCity);
        //Test if the city is in the list
        assertTrue(list.hasCity(newCity));
        //Remove the city from the list
        list.deleteCity(newCity);
        //Test again that the city is not in the list
        assertFalse(list.hasCity(newCity));

    }

    @Test
    public void CountCities(){
        list = MockCityList();
        assertEquals(0, list.countCities());
        //add city to the list
        City newCity = new City("Charlottetown", "Prince Edward Island");
        list.addCity(newCity);
        assertEquals(1, list.countCities());
        //delete the city
        list.deleteCity(newCity);
        assertEquals(0, list.countCities());

    }

};

