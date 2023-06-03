package com.furkanozek.imhereproject;
//This is the class where we create the addresses
public class newAddress {

    private static final String[] cities = {"Ankara","Manisa","Tokat"};
    private static final String[][] districs = {{"Çankaya", "Gölbaşı", "Beypazarı"} , {"Akhisar", "Saruhanlı", "Şehzadeler"}, {"Niksar", "Turhal", "Erbaa"}};
    private static final String[][] neighborhoods = {{"Atatürk Mahallesi", "Cumhuriyet Mahallesi", "Karşıyaka Mahallesi"},
            {"Kazım Karabekir Mahallesi", "Hürriyet Mahallesi", "Milliyet Mahallesi"},
            {"Ulucami Mahallesi","Yıldırım Mahallesi","Fevzi Çakmak Mahallesi"}};


    //Method for printing a neighborhood by using its code
    public static String printAddress(int nCode){
        int n = nCode / 100;
        String neigborhood = new String(neighborhoods[(n % 10) - 1][(nCode % 10) - 1]);
        int p = n / 100;
        String district = new String(districs[p - 10][(n % 10) - 1]);
        String city = new String(cities[p - 10]);
        String answer = city+ " / " + district + " / " + neigborhood + " / ";
        return answer;
    }
}
