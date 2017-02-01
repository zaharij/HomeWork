package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        Map<String, String> personMap = getPersonMap();
        System.out.println(getRepearedSurnamesNumber(personMap, "surname" + 11));
        System.out.println(getRepearedNamesNumber(personMap, "name" + 101));


        Map<String, Date> personDateMap = getPeronDateMap();
        deleteSummerPerson(personDateMap);
    }

    private static Map<String, String> getPersonMap() {
        Map<String, String> personMap = new HashMap<>();
        Random random = new Random();
        String surname;
        String name;
        outer:for(int i = 0; i < 10; i++){
            int rsn = random.nextInt(20)+10;
            surname = "surname" + rsn;
            while (personMap.containsKey(surname)){
                i--;
                continue outer;
            }
            int rn = random.nextInt(5) + 100;
            name = "name" + rn;
            personMap.put(surname.toString(), name.toString());
        }
        return personMap;
    }

    public static int getRepearedSurnamesNumber(Map map, String surname){
        Set set = map.keySet();
        int namesCount = 0;
        for (Object o : set){
            String currentName = o.toString();
            if(surname.equals(currentName)){
                namesCount++;
            }
        }
        return namesCount;
    }

    public static int getRepearedNamesNumber(Map map, String name){
        Collection collection = map.values();
        int namesCount = 0;
        for (Object o : collection){
            String currentName = o.toString();
            if(name.equals(currentName)){
                namesCount++;
            }
        }
        return namesCount;
    }




    public static Map<String, Date> getPeronDateMap(){
        Map<String, Date> peronDateMap = new HashMap<>();
        Random random = new Random();
        String surname;
        Date date;
        outer:for(int i = 0; i < 10; i++){
            int rsn = random.nextInt(20)+10;
            surname = "surname" + rsn;
            while (peronDateMap.containsKey(surname)){
                i--;
                continue outer;
            }
            int range = (int) (System.currentTimeMillis()/10000);
            long rdi = random.nextInt(range)*10000;
            date = new Date(rdi);
            peronDateMap.put(surname.toString(), date);
        }
        return peronDateMap;
    }

    public static void deleteSummerPerson (Map<String, Date> map){
        Map<String, Date> mapPers = map;
        Object[] strArr = mapPers.keySet().toArray();

        String curName;
        for (int i = 0; i < strArr.length; i++){
            curName = strArr[i].toString();
            if(mapPers.get(curName).getMonth() >= 6 && mapPers.get(curName).getMonth() <= 8){
                mapPers.remove(curName);
            }
        }
        printMap(mapPers);
    }

    private static void printMap(Map map){
        Object[] strArr = map.keySet().toArray();
        String curName;
        int count = 0;
        for (int i = 0; i < strArr.length; i++){
            curName = strArr[i].toString();
            count++;
            System.out.println("" + count + " : " +  map.get(curName).toString());
        }
    }
}
