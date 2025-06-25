import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.net.URL;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ISBNValidatorExtraTest {

  @Tag("Long")
  @ParameterizedTest
  @CsvFileSource(resources = "/isbn_tests.csv", numLinesToSkip = 1)
  void testISBNFromCsv(String isbn, boolean validity) {
    URL resource = ISBNValidatorExtraTest.class.getResource("/isbn_tests.csv");
    assumeTrue(resource != null, "CSV file not found: skipping tests");

    assertEquals(
        validity, ISBNValidator.isValidISBN(isbn), "ISBN " + isbn + " should be " + validity);
  }
}
