package br.com.rpires.queue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Possuí ordenação natural
 *
 * @author rodrigo.pires
 */
public class ExemploPriorityQueue {

    public static void main(String args[]) {
        //Ordenação Natural
        Queue<String> queue = new PriorityQueue<String>();
        queue.add("short");
        queue.add("very long indeed");
        queue.add("medium");
        while (queue.size() != 0) {
            System.out.println(queue.remove());
        }
    }
}
