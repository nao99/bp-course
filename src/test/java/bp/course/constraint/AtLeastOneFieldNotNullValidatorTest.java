package bp.course.constraint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.*;

/**
 * AtLeastOneFieldNotNullValidatorTest class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2020-12-20
 */
public class AtLeastOneFieldNotNullValidatorTest {
    /**
     * AtLeastOneFieldNotNullValidator
     */
    private AtLeastOneFieldNotNullValidator validator;

    /**
     * Some class for test
     */
    private static class Customer {
        private final String username;
        private final String email;

        public Customer(String username, String email) {
            this.username = username;
            this.email = email;
        }
    }

    /**
     * Set up
     */
    @BeforeEach
    public void setUp() throws Exception {
        validator = new AtLeastOneFieldNotNullValidator();
    }

    /**
     * Test for {@link AtLeastOneFieldNotNullValidator#isValid(Object, ConstraintValidatorContext)}
     */
    @Test
    public void testIsValid() throws Exception {
        // given
        String[] fields = {"username", "email"};

        ReflectionTestUtils.setField(validator, "fields", fields);

        Customer customer1 = new Customer(null, null);
        Customer customer2 = new Customer("Arah", null);
        Customer customer3 = new Customer(null, "Green");
        Customer customer4 = new Customer("Arah", "Green");

        // when
        boolean result1 = validator.isValid(customer1, null);
        boolean result2 = validator.isValid(customer2, null);
        boolean result3 = validator.isValid(customer3, null);
        boolean result4 = validator.isValid(customer4, null);

        // then
        assertFalse(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertTrue(result4);
    }
}
