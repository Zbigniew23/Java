package com.task;

import java.util.*;

public class Zoo2 {
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

            System.out.println("Enter " + numElephants + " mass of elephants");
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

        private static int calculateEffort()
        {
            readData();

            ArrayList<Integer> sortedMasses = new ArrayList<>();
            int effort = 0;

            sortedMasses.addAll(intMasses);
            Collections.sort(sortedMasses);
            System.out.println("sorted masses " + sortedMasses);


            while (intDefaultOrder.size() > 0)
            {

            for (int i = 0; i<intDefaultOrder.size(); i++)
            {
                if (intDefaultOrder.get(i) == intDesiredOrder.get(i))
                {

                    int toRemove = intMasses.get((intDefaultOrder.get(i)) -1 );
                    System.out.println("to remove " + toRemove);

                    intDefaultOrder.remove(i);
                    System.out.println("def order " + intDefaultOrder);
                    intDesiredOrder.remove(i);
                    System.out.println("des order " + intDesiredOrder);

                    int a = intMasses.indexOf(toRemove);
                    System.out.println("index 4000 " + a);

                    int b = sortedMasses.indexOf(toRemove);

                    sortedMasses.remove(b);
                    System.out.println("sorted " + sortedMasses);
                    intMasses.remove(a);
                    System.out.println("masses " + intMasses);

                }
            } // for

                if (intDefaultOrder.size() <=1)
                {
                    System.out.println("effort in if " + effort);
                    return effort;
                }

                int highestMass = sortedMasses.get(sortedMasses.size() - 1);
                int lowestMass = sortedMasses.get(0);

                System.out.println("sorted masses in for loop " + sortedMasses);
                System.out.println("The highest mass is " + highestMass);
                System.out.println("The lowest mass is " + lowestMass);

                System.out.println("original" + originalIntMasses);

                int x = originalIntMasses.indexOf(highestMass);
                int y = originalIntMasses.indexOf(lowestMass);
                x = intDefaultOrder.get(x);
                y = intDefaultOrder.get(y);
                System.out.println("x " + x);
                System.out.println("y " + y);

                Collections.swap(intDefaultOrder, x, y);
                System.out.println("swaped def " + intDefaultOrder);
                if ( !(intDefaultOrder.indexOf(x) == intDesiredOrder.indexOf(x)) )
                {
                    Collections.swap(intDefaultOrder, y, x);
                    System.out.println("Swaped " + intDefaultOrder);

                }else {

                    System.out.println(highestMass);
                    System.out.println(lowestMass);
                    effort += highestMass;
                    effort += lowestMass;
                }

            }// while

            System.out.println(intDefaultOrder);

            System.out.println(effort);
            return effort;
        }
    }