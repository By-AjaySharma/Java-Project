package emailapp;

import java.io.*;
import java.util.*;

public class emailSystem {

    //    Scanner object of taking user input
    Scanner sc = new Scanner(System.in);

    //    Setting varible as private to not give direct access to the user
    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String alterEmail;
    private int mailCapacity = 100;
    private String password;

    //    Creating constructor for reciving fname and lname
    public emailSystem(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;

        System.out.println("\nName : " + this.fname + " " + this.lname);

        //calling method
        this.dept=this.setDept();//department
        this.password=this.generatePassword(8);//generate password
        this.email=this.generateEmail();//generate email address

    }

    //    method for generating email
    private String generateEmail() {
        return this.fname.toLowerCase() + this.lname.toLowerCase() + "@" + this.dept.toLowerCase() + ".company.com";
    }

    //    method for asking for department
    private String setDept() {
        System.out.println("\nDepartment codes \n1 for Sales \n2 for Development \n3 for Account \n4 for Human Resource \n0 for none");
        boolean flag = false;
        do {
            System.out.print("\nEnter the Department Code: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    return "Sales";
                case 2:
                    return "Develpment";
                case 3:
                    return "Account";
                case 4:
                    return "Human Resource";
                case 5:
                    return "None";
                default:
                    System.out.println("Invalid choice please choose it");
            }

        } while (!flag);
        return null;
    }

//    method for generating password

    private String generatePassword(int length){
        Random r=new Random(); //Random object
        String capitalChar="ABCDEFGHIJKLMNOVWXYZ";
        String lowerChar="abcdefghijklmnopqrstuvwxyz";
        String number="1234567890";
        String sybmol="!@#$%&*?";
        String value=capitalChar+lowerChar+number+sybmol;

        String password="";

        for(int i=0;i<length;i++){
            password+=value.charAt(r.nextInt(value.length()));
        }

        return password;
    }

//    method for chance password
    public void changePassword(){
        boolean flag= false;
        do {
            System.out.println("Do you want to change your password! (Y/N)");
            char choice = sc.next().charAt(0);

            if (choice == 'Y' || choice == 'y') {

                flag=true;
                System.out.print("Enter the Old Password : ");
                String temp = sc.next();

                if (temp.equals(this.password)) {
                    System.out.print("Enter the New Password : ");
                    this.password = sc.next();
                    System.out.println("\nPassword change Successfully..");
                }
                else {
                    System.out.println("Incorrect Password");
                }

            } else if(choice=='N' || choice=='n') {

                flag = true;
                System.out.println("Change password option cancelled");

            } else {

                System.out.println("Enter Valid Choice ");
            }


        }while (!flag);
    }

//    method for setting mail Capacity
    public void changeMailCapacity() {
        System.out.println("\nCurrent mail Capacity = "+this.mailCapacity+"mb");
        System.out.print("Enter new mail Capacity : ");
        this.mailCapacity=sc.nextInt();
        System.out.println("\nMail capacity has change Successfully.. ");

    }

//    method for setting alternate mail
    public void setAlterEmail() {

        System.out.print("\nEnter alternate mail address : ");
        this.alterEmail=sc.next();
        System.out.println("\nAlternate mail set Successfully..");
    }

//    method for display user info
    public void getInfo(){
        System.out.println("\nName : "+this.fname+" "+this.lname);
        System.out.println("Department : "+this.dept);
        System.out.println("Email : "+this.email);
        System.out.println("Alternate Email : "+this.alterEmail);
        System.out.println("Password : "+this.password);
        System.out.println("Mailbox Capacity : "+this.mailCapacity+" Mb");

    }

    //method to store file
    public void storeFile(){
        try {
            FileWriter write=new FileWriter("C:\\Users\\byaja\\OneDrive\\Email Administration System with auto password Generator\\info.txt");
            write.write(" First Name : "+ this.fname);
            write.append("\n Last Name : "+this.lname);
            write.append("\n Department : "+this.dept);
            write.append("\n Email : "+this.email);
            write.append("\n Alternate Email :"+this.alterEmail);
            write.append("\n Password : "+this.password);
            write.append("\n Mailbox Capacity : "+this.mailCapacity);
            write.close();
            System.out.println("\nData Store Successfully..");



        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }

    //Method for data Retread
    public void readFile(){
        try {
            FileReader read1=new FileReader("C:\\Users\\byaja\\OneDrive\\Email Administration System with auto password Generator\\info.txt");
            System.out.println();
            int i;
            while ((i=read1.read())!=-1){
                System.out.print((char)i);

            }
            System.out.println();
            read1.close();


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }



}