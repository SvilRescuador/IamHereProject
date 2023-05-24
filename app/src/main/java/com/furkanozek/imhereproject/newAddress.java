package com.furkanozek.imhereproject;

public class newAddress {

    private static final String[] cities = {"Ankara","Manisa","Tokat"};
    private static final String[][] districs = {{"Çankaya", "Gölbaşı", "Beypazarı"} , {"Akhisar", "Saruhanlı", "Şehzadeler"}, {"Niksar", "Turhal", "Erbaa"}};
    private static final String[][] neighborhoods = {{"Atatürk Mahallesi", "Cumhuriyet Mahallesi", "Karşıyaka Mahallesi"},
            {"Kazım Karabekir Mahallesi", "Hürriyet Mahallesi", "Milliyet Mahallesi"},
            {"Ulucami Mahallesi","Yıldırım Mahallesi","Fevzi Çakmak Mahallesi"}};

    public boolean checkCityAtIndex(int index, String stringToCheck) {
        if(cities[index].equals(stringToCheck)){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkDistrictAtIndex (int cityIndex, int districtIndex, String stringToCheck) {
        if (districs[cityIndex][districtIndex].equals(stringToCheck)){
            return true;
        }
        else{
            return false;
        }
    }

    public int findIndexOfCity(String city) {
        for(int n = 0; n < cities.length; n++){
            if (city.equals(cities[n])){
                return n;
            }
        }
        return -1;
    }

    public int findIndexOfDistrict(int indexOfCity, String district) {
        for(int n = 0; n < cities.length; n++){
            if (district.equals(districs[indexOfCity][n])){
                return n;
            }
        }
        return -1;
    }

    public int neighborhoodCode(int cityIndex, int districtIndex, int neighborhoodCode){
        return (cityIndex + 10) * 10000 + (districtIndex + 1) * 100 + (neighborhoodCode + 1);
    }

    public static String findNeighborhoodByCode (int nCode) {
        int n = nCode / 100;
        return neighborhoods[(n % 10) - 1][(nCode % 10) - 1];
    }

    public static String findDistrictByCode (int nCode) {
        int a = nCode / 10000;
        int b = nCode / 100;
        return districs[a - 10][b - 1];
    }

    public static String findCityByCode (int nCode) {
        int a = nCode / 10000;
        return cities[a - 10];
    }
}