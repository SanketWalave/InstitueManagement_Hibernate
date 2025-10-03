package org.springjdbc.exception;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class HandleException {

    public int getIntegerInput(Scanner sc,String message){
       while (true){
           try{
               System.out.println(message);
               int num=sc.nextInt();
               sc.nextLine();
               return num;
           } catch (Exception e) {
               System.out.println("Wrong input 🚫 enter again");
               sc.nextLine();
           }
       }
    }
}
