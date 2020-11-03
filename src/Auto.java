

import java.io.Serializable;
import java.util.Comparator;
import java.util.Scanner;

public class Auto implements Serializable, Comparable<Auto>, Comparator<Auto> {
    int Number;
    String Man;
    int time;
    int price;

    public static Auto read() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter number: ");

        if (in.hasNextInt() == true) {
            int number = in.nextInt();
            System.out.print("\nEnter surname: ");
            if (in.hasNext() == true) {
                String man = in.next();
                System.out.print("\nEnter stopping time: ");
            if (in.hasNextInt() == true) {
                int time = in.nextInt();
                   System.out.print("\nEnter price: ");
            if (in.hasNextInt() == true) {
                int price = in.nextInt();
                Auto auto = new Auto(number, man, time, price);
                return auto;
            } else {
                System.out.println("Bad enter");
                return null;
            }} else {
                System.out.println("Bad enter");
                return null;
            } } else {
                System.out.println("Bad enter");
                return null;
            }
        } else {
            System.out.println("Bad enter");
            return null;
        }


    }

    @Override
    public int compareTo(Auto auto) {
        int compareage = ((Auto) auto).getNumber();
        /* For Ascending order*/
        return this.Number - compareage;

    }


    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getMan() {
        return Man;
    }

    public void setMan(String man) {
        Man = man;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Auto() {
    }

    public Auto(int Number, String Man, int time, int price) {
        this.Number = Number;
        this.Man = Man;
        this.time = time;
        this.price = price;
    }


    public String toString() {

        return new String("\n" + this.Number + " | " + this.Man + " | " + this.time + " | " + this.price );
    }

    @Override
    public int compare(Auto o1, Auto o2) {
        return 0;
    }

    @Override
    public Comparator<Auto> reversed() {
        return null;
    }
}
