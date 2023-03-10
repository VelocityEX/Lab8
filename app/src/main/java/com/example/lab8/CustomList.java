package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this gets size of the list
     * @return
     */
    public int getCount(){
        return cities.size();
    }
    /**
     * this adds a city object to the list
     *the second phase, you can add the city
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }
    /**
     * Checks if the list contains a city object with the given city name and province name.
     *
     * @param city the city object to check
     * @return true if the list contains the city, false otherwise
     */
    public boolean hasCity(City city) {
        for (City c : cities) {
            if (c.getCityName().equals(city.getCityName()) && c.getProvinceName().equals(city.getProvinceName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes the city object with the given city name and province name from the list.
     *
     * @param city the city object to remove
     * @return true if the city was removed, false otherwise
     */
    public boolean deleteCity(City city) {
        int initialSize = cities.size();
        cities.remove(city);
        if (cities.size() < initialSize) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    /**
     * Returns the number of cities in the list.
     *
     * @return the number of cities in the list
     */
//    public int countCities() {
//        return cities.size();
//    }

}
