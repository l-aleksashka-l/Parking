import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Autos {
    static final String filename = "Autos.dat";

    public Autos() {
    }

    public static void main(String[] strings) throws IOException, ClassNotFoundException {
        ArrayList<Auto> arrayList = new ArrayList<>();
        e(arrayList);
    }

    static void e(ArrayList<Auto> arrayList) throws IOException, ClassNotFoundException {
        System.out.print("\nEnter number between 1 and 4 : \n\t 1) Add\n\t 2) Print\n\t 3) Print with sort by number\n\t " +
                "4) Print witn reverse sort by number\n\t 5) Find by number\n\t 6) Print autos, which number bigger than this number\n\t " +
                "7) Print autos, which number less than this number\n\t 8) Delete full file \n\t 9) Delete by index \n\t 10) Close \n");
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int q = in.nextInt();
            switch (q) {
                case 1:
                    append_file(arrayList);
                    e(arrayList);
                    break;
                case 2:
                    print_file(arrayList);
                    e(arrayList);
                    break;
                case 3:
                    print_by_index(arrayList);
                    e(arrayList);
                    break;
                case 4:
                    print_by_rev_index(arrayList);
                    e(arrayList);
                    break;
                case 5:
                    this_number(arrayList);
                    e(arrayList);
                    break;
                case 6:
                    more_than_a(arrayList);
                    e(arrayList);
                    break;
                case 7:
                    less_than_a(arrayList);
                    e(arrayList);
                    break;
                case 8:
                    delete_file(arrayList);
                    e(arrayList);
                    break;
                case 9:
                    del_by_ind(arrayList);
                    e(arrayList);
                    break;
                case 10:
                    System.exit(1);
                default:
                    e(arrayList);
                    break;
            }


        }
    }

    static void delete_file(ArrayList<Auto> arrayList) {
        File file = new File("Autos.dat");
        file.delete();
        arrayList.clear();

    }

    static void this_number(ArrayList<Auto> arrayList) throws FileNotFoundException {
        System.out.print("\nEnter number: ");
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int a = in.nextInt();
            Auto auto;
            if ((auto = find_by_number(arrayList, a)) != null) {
                System.out.println(auto);
            } else {
                System.out.println("Number not found!");
            }
        } else {
            System.out.println("Bad enter!");
        }
    }

    static void append_file(ArrayList<Auto> arrayList) throws FileNotFoundException, IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile("Autos.dat", "rw");
        Throwable throwable = null;
        Auto auto;
        if ((auto = Auto.read()) != null) {
            arrayList.add(auto);

        } else {
            append_file(arrayList);
        }

    }

    static Auto find_by_number(ArrayList<Auto> arrayList, int a) throws FileNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("Autos.dat", "rw");
        Throwable throwable = null;
        for (Auto auto : arrayList) {
            if (auto.Number == a) {
                return auto;
            }
        }
        return null;
    }

    static void more_than_a(ArrayList<Auto> arrayList) throws FileNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("Autos.dat", "rw");
        Throwable throwable = null;

        System.out.print("\nEnter number: ");
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int a = in.nextInt();
            for (Auto auto : arrayList) {
                if (auto.Number > a) {
                    System.out.println(auto);
                }
            }
        } else {
            System.out.println("Bad enter!");
        }
    }

    static void less_than_a(ArrayList<Auto> arrayList) throws FileNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("Autos.dat", "rw");
        Throwable throwable = null;
        System.out.print("\nEnter number: ");
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int a = in.nextInt();
            for (Auto auto : arrayList) {
                if (auto.Number < a) {
                    System.out.println(auto);
                }
            }
        } else {
            System.out.println("Bad enter!");
        }


    }


    static void print_by_index(ArrayList<Auto> arrayList) {
        Collections.sort(arrayList);
        System.out.println(arrayList);
    }

    static void print_by_rev_index(ArrayList<Auto> arrayList) {
        Collections.reverse(arrayList);
        System.out.println(arrayList);
    }


    static void del_by_ind(ArrayList<Auto> arrayList) throws FileNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("Autos.dat", "rw");
        Throwable throwable = null;
        System.out.print("\nEnter number: ");
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int a = in.nextInt();
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).Number == a) {
                    arrayList.remove(i);
                }
            }
        } else {
            System.out.println("Bad enter!");
        }

    }

    static void print_file(ArrayList arrayList) {
        System.out.println(arrayList);
    }
}

