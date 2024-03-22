package com.ust.evaluation;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Date {
    public static  void  main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter date yyyy-mm-dd");
        String input=scanner.next();
        LocalDate localDate=LocalDate.parse(input);

        LocalDate currentdate=LocalDate.now();

        int result=currentdate.compareTo(localDate);
        if (result==0){
            System.out.println("input date equal to current date");
        } else if (result>0) {
            System.out.println("input date is before current date");

        }else {
            System.out.println("input date is after current date");
        }

        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String foramteddate=currentdate.format(dateTimeFormatter);
        System.out.println("formatted date :"+foramteddate);

    }
}
