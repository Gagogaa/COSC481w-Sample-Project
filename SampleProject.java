import java.util.Scanner; // java date/scanner objects
import java.time.LocalDate;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;

public class SampleProject {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in).useDelimiter("(\\s*/\\s*)| |\n");
    System.out.print("Enter date of birth (mm/dd/yyyy): ");
    LocalDate dateOfBirth = null;

    try {
      int month = keyboard.nextInt();
      int day = keyboard.nextInt();
      int year = keyboard.nextInt();
      dateOfBirth = LocalDate.of(year, month, day);
    } catch (DateTimeException e) {
      System.out.println("The date entered is invalid.");
      System.exit(1);
    }

    output(isEligible(dateOfBirth), getEligibleDate(dateOfBirth));
  }

  private static LocalDate getEligibleDate(LocalDate dateOfBirth) {
    return dateOfBirth.plusYears(14).plusMonths(9);
  }

  private static boolean isEligible(LocalDate dateOfBirth) {
    return LocalDate.now().compareTo(getEligibleDate(dateOfBirth)) > 0;
  }

  private static void output(boolean isEligible, LocalDate dateEligible){
    if (isEligible){
      System.out.println("User is eligible for Level 1 license.");
    } else {
      System.out.println("User is ineligible for Level 1 license. The user will be eligible "
                         + dateEligible.format(DateTimeFormatter.ofPattern("MMMM yyyy")) + ".");
    }
  }
}
