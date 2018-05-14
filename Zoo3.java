package com.task;

import java.util.*;

public class Zoo3 {
    private  static  String numElephants;
    private static String mass;
    private static String defaultOrder;
    private static String desiredOrder;
    private static ArrayList<Integer> intMasses = new ArrayList<>();
    private static ArrayList<Integer> intDefaultOrder = new ArrayList<>();
    private static ArrayList<Integer> intDesiredOrder = new ArrayList<>();
    private static ArrayList<Integer> originalIntMasses = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        calculateEffort();
    }

    private static void readData()
    {
        System.out.println("Enter the number of elephants");
        numElephants = scanner.nextLine();

        System.out.println("Enter " + numElephants + " masses of elephants");
        mass = scanner.nextLine();
        String [] massArray = mass.split(" ");

        System.out.println("Enter default order: ");
        defaultOrder = scanner.nextLine();
        String [] defaultArray = defaultOrder.split(" ");

        System.out.println("Enter desired order: ");
        desiredOrder = scanner.nextLine();
        String [] desiredArray = desiredOrder.split(" ");

        try{
            for (int i = 0; i < massArray.length; i++)
            {
                if (massArray.length == 0)
                {
                    break;
                }else {
                    intMasses.add(Integer.parseInt(massArray[i]));
                }
            }

            for (int i = 0; i < defaultArray.length; i++)
            {
                if (defaultArray.length == 0)
                {
                    break;
                }else {
                    intDefaultOrder.add(Integer.parseInt(defaultArray[i]));
                }
            }
            for (int i = 0; i < desiredArray.length; i++)
            {
                if (desiredArray.length == 0)
                {
                    break;
                }else {
                    intDesiredOrder.add(Integer.parseInt(desiredArray[i]));
                }
            }

        }catch (NumberFormatException | NullPointerException e){}
        System.out.println(intMasses);
        System.out.println(intDefaultOrder);
        System.out.println(intDesiredOrder);

        originalIntMasses.addAll(intMasses);
    }

  
}