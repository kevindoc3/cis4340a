
public final class InputLibrary {
    private static BufferedInputStream in =
        new BufferedInputStream(System.in);
   
    public static char getChar() throws EOFException, IOException {
      int input = in.read();
      if (input == -1) {
        throw new EOFException();
      }
      in.skip(1); // This statement is to advance to the next line.
                  // The noncompliant code example deceptively
                  // appeared to work without it (in some cases).
      return (char) input;
    }
   
    public static void main(String[] args) {
      try {
        System.out.print("Enter first initial: ");
        char first = getChar();
        System.out.println("Your first initial is " + first);
        System.out.print("Enter last initial: ");
        char last = getChar();
        System.out.println("Your last initial is " + last);
      } catch (EOFException e) {
        System.err.println("ERROR");
        // Forward to handler
      } catch (IOException e) {
         System.err.println("ERROR");
         // Forward to handler
      }
    }
  }