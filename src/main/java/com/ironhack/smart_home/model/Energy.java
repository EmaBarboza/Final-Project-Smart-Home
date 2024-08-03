package com.ironhack.smart_home.model;

import java.util.Scanner;

public class Energy {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        double usageHoursPerDay = sc.nextDouble();

        double usageHoursPerYear = usageHoursPerDay * 365;
        double wattsPerHour = 1500;
        double usageWattHoursPerYear = wattsPerHour * 8760;
        double usageKWHPerYear = usageWattHoursPerYear / 1000;
        double costPerYear = usageKWHPerYear * 0.145;


        System.out.println("Computer Energy Audit");
        System.out.println("You use your computer for " + usageHoursPerYear + " hours per year.");
        System.out.println("It will use " + usageWattHoursPerYear + " KWH/year.");
        System.out.println("Which will cost $" + costPerYear + "111 for electricity.");






    }

}
