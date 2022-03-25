package com.kea;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
       /* ArrayList<Rateinfo> rateinfos=new ArrayList<Rateinfo>();

        //Instantiating the URL class
        URL url = new URL("https://www.nationalbanken.dk/_vti_bin/DN/DataService.svc/CurrencyRatesXML?lang=da");
        //Retrieving the contents of the specified page
        Scanner sc = new Scanner(url.openStream());
        //Instantiating the StringBuffer class to hold the result
//        StringBuffer sb = new StringBuffer();
        int i=0;
        while(sc.hasNext())
        {
            String input=sc.next();
//            sb.append(input);
            i++;

            if (i>12 && i<181) {
                if(input.contains("code"))
                {
                    System.out.print(input.replaceAll("code=","").replaceAll("\"",""));
                }
                else if(input.contains("desc"))
                {
                    input=input.replaceAll("desc=","").replaceAll("\"","").replaceAll("�","æ");
                    if(input.contains("Euro")) {
                        System.out.print(" " + input);
                    }else {
                        input=input+" "+ sc.next();
                        input=input.replaceAll("\"","");
                        System.out.print(" " + input);
                    }
                }
                else if (input.contains("rate"))
                {
                    input=input.replaceAll("rate=","").replaceAll("\"","");
                    System.out.print(" "+input);
                }
                if(input.contains("/>"))
                {
                    System.out.println();
                }
            }

        }*/
        Main main = new Main();
        main.menu();
        main.getMenu();

        //Retrieving the String from the String Buffer object
//        String result = sb.toString();
//        System.out.println(result);
    }

    public double DanishToAmericanCalculater() {
        double americanFromOneDanish = 0.15;
        double result;

        Scanner sc = new Scanner(System.in);
        System.out.println("Indtast hvor mange DKK  - De vil blive omregnet til amerikanske dollars: ");
        double amount = sc.nextDouble(); //userinput
        result = amount * americanFromOneDanish;
        System.out.println(amount + " DKK er " + result + " amerikanske dollars");
        return result;
    }

    public double americanToDanishCalculater() {
        double danishFromOneAmerican = 6.76;
        double result;

        Scanner sc = new Scanner(System.in);
        System.out.println("Indtast hvor mange USD  - De vil blive omregnet til danske kroner: ");
        double amount = sc.nextDouble(); //userinput
        result = amount * danishFromOneAmerican;
        System.out.println(amount + " USD er " + result + " danske kroner");
        return result;
    }

    public int menu() {
        System.out.println("Hej! Velkommen til valuta omregner menuen" + "\n" +
                "----------------------------------------------------" + "\n" +

                "1) omregn fra danske kroner til amerikanske dollars" + "\n" +
                "2) omregn fra amerikanske dollars til danske kroner" + "\n" +
                "0) afslut programmet");
        return getInt(0,1);
    }

    public int getInt(int lowerLimit, int upperLimit) {
        int choice = getInt();

        if (choice >= lowerLimit && choice <= upperLimit) {
            return choice;
        } else {
            System.out.println("Skriv venligst et tal mellem " + lowerLimit + " og " + upperLimit);
            return getInt(lowerLimit, upperLimit);
        }
    }
    public int getInt() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int choice = sc.nextInt();
            sc.nextLine(); // to prevent scanner bug
            return choice;
        } else {
            System.out.println("Indtast venligst et heltal");
            sc.nextLine();
            return getInt();
        }
    }

    public void  getMenu() {
        switch (getInt(1,3)) {
           case 1 ->{
                DanishToAmericanCalculater();
            }
           case 2 ->{
                americanToDanishCalculater();
            }
           case 3 ->{
               System.exit(0);
            }
        }
    }
}
