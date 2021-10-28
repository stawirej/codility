package coursera.assignments;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

final class Assignment_01 {

    @Test
    void multiply() {
        // Given
        var a = new BigDecimal("3141592653589793238462643383279502884197169399375105820974944592");
        var b = new BigDecimal("2718281828459045235360287471352662497757247093699959574966967627");

        // When
        BigDecimal product = a.multiply(b);

        // Then
        then(product)
            .isEqualTo(
                new BigDecimal(
                    "8539734222673567065463550869546574495034888535765114961879601127067743044893204848617875072216249073013374895871952806582723184"));
    }

    @Test
    void karatsuba_simple() {
        // Given
        var a = new BigDecimal("5678");
        var b = new BigDecimal("1234");

        // When
        BigDecimal product = Multiplication.karatsuba(a, b);

        // Then
        then(product).isEqualTo(new BigDecimal("7006652"));
    }

    @Disabled("Invalid implementation")
    @Test
    void karatsuba() {
        // Given
        var a = new BigDecimal("3141592653589793238462643383279502884197169399375105820974944592");
        var b = new BigDecimal("2718281828459045235360287471352662497757247093699959574966967627");

        // When
        BigDecimal product = Multiplication.karatsuba(a, b);

        // Then
        then(product).isEqualTo(new BigDecimal(
            "8539734222673567065463550869546574495034888535765114961879601127067743044893204848617875072216249073013374895871952806582723184"));
    }
}
