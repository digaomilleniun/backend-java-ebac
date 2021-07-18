package br.com.rpires;

/**
 * @author rodrigo.pires
 */
public class Exemplo2 {

    public static void main(String args[]) {
        int num1 = 10;
        short num2 = (short) num1;

        long numL = 1111111111111111111l;
        System.out.println(numL);
        int numI = (int) numL;
        System.out.println(numI);

        int idade = 10;
        long idadeL = idade;

        byte b = 1;
        short s = b;

        byte b1 = (byte) s;
        int i = b1;

        int i1 = 1;
        byte s1 = (byte) i1;
        long l = i1;

        long l1 = 1010101;
        short l2 = (short) l1;
        double d = l1;

        double d1 = 1.0;
        long l3 = (long) d1;
    }
}
