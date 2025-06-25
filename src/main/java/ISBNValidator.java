public class ISBNValidator {

  public static boolean isValidISBN(String isbn) {
    if (isbn == null) return false;

    isbn = isbn.replaceAll("[-\\s]", "");

    if (isbn.length() == 10) {
      return isValidISBN10(isbn);
    } else if (isbn.length() == 13) {
      return isValidISBN13(isbn);
    } else {
      return false;
    }
  }

  private static boolean isValidISBN10(String isbn10) {
    if (!isbn10.matches("\\d{9}[\\dXx]")) return false;

    int sum = 0;
    for (int i = 0; i < 9; i++) {
      sum += (isbn10.charAt(i) - '0') * (10 - i);
    }

    char lastChar = isbn10.charAt(9);
    sum += (lastChar == 'X' || lastChar == 'x') ? 10 : (lastChar - '0');

    return sum % 11 == 0;
  }

  private static boolean isValidISBN13(String isbn13) {
    if (!isbn13.matches("\\d{13}")) return false;

    int sum = 0;
    for (int i = 0; i < 13; i++) {
      int digit = isbn13.charAt(i) - '0';
      sum += (i % 2 == 0) ? digit : digit * 3;
    }

    return sum % 10 == 0;
  }
}
