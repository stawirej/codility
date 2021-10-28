package coursera.assignments;

import java.math.BigDecimal;

final class Multiplication {

    public static BigDecimal karatsuba(BigDecimal x, BigDecimal y) {

        var n = x.toString().length();
        var nHalf = n / 2;

        if (n < 10) {
            return x.multiply(y);
        }

        var a = new BigDecimal(x.toString().substring(0, nHalf));
        var b = new BigDecimal(x.toString().substring(nHalf));
        var c = new BigDecimal(y.toString().substring(0, nHalf));
        var d = new BigDecimal(y.toString().substring(nHalf));

        var X = karatsuba(a, c);
        var Y = karatsuba(b, d);
        var Z = karatsuba(a.add(b), c.add(d)).subtract(X).subtract(Y);

        return X.multiply(new BigDecimal(10).pow(nHalf))
                .add(Z.multiply(new BigDecimal(10).pow(nHalf)))
                .add(Y);
    }
}
