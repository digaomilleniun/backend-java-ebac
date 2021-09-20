package br.com.rpires.lambdas;

import java.util.function.IntBinaryOperator;

/**
 * @author rodrigo.pires
 */
public class IntBinaryOperatorClass implements IntBinaryOperator {
    @Override
    public int applyAsInt(int a, int b) {
        return a + b;
    }
}
