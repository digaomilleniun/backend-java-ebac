package br.com.rpires.lambdas;

import java.util.function.IntBinaryOperator;

/**
 * @author Steve Vaz
 */
public class IntBinaryOperatorClass implements IntBinaryOperator {
    @Override
    public int applyAsInt(int a, int b) {
        return a + b;
    }
}
