package com.btcag.bootcamp;

import java.util.Scanner;

public class RobotWars {


    public static void main(String[] args) {
        //Greetings and user Name
        Scanner scanner = new Scanner(System.in);

        System.out.print("please insert your user name:");
        String userName = scanner.nextLine();

        System.out.println("          ________        ");
        System.out.println("         /  _____/_______  ");
        System.out.println("        /   \\  __\\_  __ \\ ");
        System.out.println("        \\    \\_\\  \\  | \\/ ");
        System.out.println("         \\______  /__|    ");
        System.out.println("                \\/        ");
        System.out.println("     ____     ____      ");
        System.out.println("    |    |   |    |    ");
        System.out.println("    |____|___|____|____");
        System.out.println("      \\=============/");
        System.out.println("       \\___________/");
        System.out.println("        / /     \\ \\");
        System.out.println("       /_/       \\_\\");
        System.out.println();
        System.out.printf("   Welcome, %s, to the Ultimate Robot Clash!\n", userName);
        System.out.println();

        //Create robot avatar

        System.out.println("Please insert your robot name:");
        String robotName = scanner.nextLine();
        System.out.printf("Prepare to fight, %s\n", robotName);

        //Generate battlemap

        int rows = 0;
        int columns = 1;
        String map = "";

        int robotRow = 2;
        int robotColumn = 3;
        int robotTicker = 0;

        while (rows < 6) {            //generates number of [] as rows
            map = "[]";
            rows++;
            columns = 1;

            if (robotRow == rows) {    //checks for same Robot position
                robotTicker = 1;
            }
            while (columns < 4) {          //generates number of [] as columns
                if (robotColumn == columns-1 && robotTicker == 1) {
                    map = map + "[R]";
                    robotTicker = 2;
                    columns++;
                } else {
                    map = map + "[]";
                    columns++;
                }

            }
            System.out.println(map);
        }

    }
