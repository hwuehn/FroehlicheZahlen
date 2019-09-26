package data;

public class Zahlen {

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

    public void test(int number) {
        int tmp = 0;
        while (tmp != 1) {
            tmp = erstelleQuersumme(number, numberToString(number));
            for (int i = 0; tmp > 1; i++)
                tmp = erstelleQuersumme(tmp, numberToString(tmp));
        }
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
