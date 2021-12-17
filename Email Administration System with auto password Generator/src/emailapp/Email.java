package emailapp;

import java.util.*;

public class Email {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

         // user info
        System.out.print("Enter first name : ");
        String fName=sc.next();
        System.out.print("Enter last name : ");
        String lName=sc.next();

        emailSystem mail=new emailSystem(fName,lName);

        int choice=-1;
        do {
            System.out.println("\n---------\nChoose Option\n1. Show Info\n2. Change Password\n" +
                    "3. Change mail Capacity\n4. Set Alternate mail\n5. Store Data in File\n6. Display Data from file \n0. Exit");

            System.out.print("Enter option code : ");

            choice =sc.nextInt();

            switch (choice){
                case 1:
                    mail.getInfo();
                    break;

                case 2:
                    mail.changePassword();
                    break;

                case 3:
                    mail.changeMailCapacity();
                    break;

                case 4:
                    mail.setAlterEmail();
                    break;

                case 5:
                    mail.storeFile();
                    break;

                case 6:
                    mail.readFile();
                    break;

                case 0:
                    System.out.println("Thank you for using Application");
                    break;

                default:
                    System.out.println("Invalid Choice \n Enter the choice again");

            }


        }while (choice!=0);


    }
}
