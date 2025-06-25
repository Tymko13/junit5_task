import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ISBNValidatorTest {

    @Tag("Quick")
    @Test
    void testValidISBN10() {
        String isbn = "0-306-40615-2";
        assertTrue(ISBNValidator.isValidISBN(isbn), "ISBN-10 should be valid");
    }

    @Tag("Quick")
    @Test
    void testValidISBN10WithX() {
        String isbn = "163774708X";
        assertTrue(ISBNValidator.isValidISBN(isbn), "ISBN-10 with X should be valid");
    }

    @Tag("Quick")
    @Test
    void testValidISBN13() {
        String isbn = "978-0-306-40615-7";
        assertTrue(ISBNValidator.isValidISBN(isbn), "ISBN-13 should be valid");
    }

    @Tag("Quick")
    @Test
    void testInvalidISBN10() {
        String isbn = "0-306-40615-3";
        assertFalse(ISBNValidator.isValidISBN(isbn), "ISBN-10 should be invalid");
    }

    @Tag("Quick")
    @Test
    void testInvalidISBN10WithX() {
        String isbn = "1637747080";
        assertFalse(ISBNValidator.isValidISBN(isbn), "ISBN-10 with X should be invalid");
    }

    @Tag("Quick")
    @Test
    void testInvalidISBN13() {
        String isbn = "978-0-306-40615-8";
        assertFalse(ISBNValidator.isValidISBN(isbn), "ISBN-13 should be invalid");
    }

    @Tag("Quick")
    @Test
    void testInvalidISBN13WithX() {
        String isbn = "978-0-306-40615-X";
        assertFalse(ISBNValidator.isValidISBN(isbn), "ISBN-13 with X should be invalid");
    }

    @Tag("Quick")
    @Test
    void testInvalidShortISBN() {
        String isbn = "123";
        assertFalse(ISBNValidator.isValidISBN(isbn), "ISBN is too short and should be invalid");
    }

    @Tag("Quick")
    @Test
    void testInvalidLongISBN() {
        String isbn = "1234567890123456789";
        assertFalse(ISBNValidator.isValidISBN(isbn), "ISBN is too long and should be invalid");
    }

    @Tag("Long")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "ABCDEFGHIJ",
            "          ",
            ".,?!@$#%^&*"
    })
    void testInvalidISBNs(String isbn) {
        assertFalse(ISBNValidator.isValidISBN(isbn), "Not an ISBN - Should be invalid");
    }
}
