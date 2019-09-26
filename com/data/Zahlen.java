package data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class Zahlen {

    public int tmp;
    List<Integer> liste = new ArrayList<>();
    public int quersumme(int number) {
        String numberString = numberToString(number);
        int sum = 0;
        int squareNumber = 1;
        for ( int i = 0 ; i < numberString.length( ) ; i++ ) {
            squareNumber = square(Integer.parseInt(numberString.substring(i, i + 1)));
            sum += squareNumber;
        }
        return sum;
    }


    public void test3(int von, int bis) {

            for ( int i = von; i < bis; i++) {
                test(i);
                if (tmp == 1)
                   liste.add(i);
            }
        System.out.println("Liste der gefundenen fröhlichen Zahlen: ");
        System.out.println(liste);
    }


    public void test2() {
        IntStream.range(10, 21)
                .forEach(e -> test(e));
    }

    public int test(int number) {
        int tmp = 0;
        int counter = 0;
        while ((counter < 9) & (tmp != 1)  ) {
            tmp = erstelleQuersumme(number, numberToString(number));
            for (int i = 0; (i < 9) & (tmp > 1) ; i++)
                tmp = erstelleQuersumme(tmp, numberToString(tmp));
            counter++;
        }
        if (tmp != 1)
            System.out.println("\nAuf die Dauer ergibt die Summe der Quadrate Ihrer Ziffer nicht 1." +
                               "\nDas ist leider keine fröhliche Zahl\n");
        else {

            liste.add(number);
            System.out.println("\nDas ist eine fröhliche Zahl\n");
        }
        return tmp;
    }

    public int erstelleQuersumme(int number, String numberString) {
        for ( int i = 0 ; i < numberString.length( ) ; i++ ) {
            System.out.print ( numberString.substring( i , i + 1 ) ) ;
            System.out.print("^2");
            if ( i == numberString.length( ) - 1 ) {
               System.out.print( " = " ) ;
               System.out.println( quersumme( number ) ) ;
            }
            else {
               System.out.print( " + " ) ;
            }
        }
        return quersumme(number);
    }

    public String numberToString(int number) {
        String numberstring = String.valueOf(number);
        return numberstring;
    }

    public int square(int number) {
        int squareNumber = (int) Math.pow(number, 2);
        return squareNumber;
    }
}
