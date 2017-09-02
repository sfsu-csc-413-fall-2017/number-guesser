import java.util.*;

public class NumberGuesser {

  public static final int MAX_GUESS = 100;
  public static final int CORRECT = 0;
  public static final int TOO_LOW = 1;
  public static final int TOO_HIGH = 2;

  public static void main( String[] args ) {
    boolean keepGuessing = true;
    int number = generateRandomNumber();

    while( keepGuessing ) {
      int guess = requestInput();

      switch( compareGuess( number, guess )) {
        case CORRECT:
          keepGuessing = false;
          System.out.println( "You got it." );
          break;
        case TOO_LOW:
          System.out.println( "Too low." );
          break;
        case TOO_HIGH:
          System.out.println( "Too high." );
          break;
      }
    }
  }

  private static int generateRandomNumber() {
    return ( new Random() ).nextInt( MAX_GUESS ) + 1;
  }

  private static int requestInput() throws InputMismatchException {
    Scanner scanner = new Scanner( System.in );
    System.out.println( "Guess: " );

    return scanner.nextInt();
  }

  private static int compareGuess( int number, int guess ) {
    if( number == guess ) {
      return CORRECT;
    } else if( guess < number ) {
      return TOO_LOW;
    } else {
      return TOO_HIGH;
    }
  }
}