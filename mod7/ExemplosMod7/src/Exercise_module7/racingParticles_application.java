package Exercise_module7;

import java.util.Locale;
import java.util.Scanner;

import util.racingParticles_mod7;

/*
* Author: Steve Vaz
*/

public class racingParticles_application {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		racingParticles_mod7 values = new  racingParticles_mod7();

		// Informing the user to enter the particle velocity value.
		System.out.println("Digite a velocidade da primeira partícula (em metros por segundo m/s): "); 

		// The user enters the value of particleVelocity1
		values.particleVelocity1 = Double.valueOf(sc.nextDouble());	
		
		// Another instruction.
		System.out.println("Digite a velocidade da segunda partícula (em metros por segundo m/s):");
		
		// The user enters the value of the velocity of the particle2.
		values.particleVelocity2 = Double.valueOf(sc.nextDouble());

		// Another instruction.
	    System.out.println("Informe o tempo da primeira particula em (metros por segundo m/s): ");

		// The user enters the value of the time in which the velocity of particle1 travels		
       	values.time1 = Double.valueOf(sc.nextDouble());
       	
		// Another instruction.
       	System.out.println("Informe o tempo da segunda particula em (metros por segundo m/s): ");

		// The user enters the value of the time in which the velocity of particle2 travels	
       	values.time2 = Double.valueOf(sc.nextDouble());
       	
		// To find out which travels the greatest distance, multiply the speed * time, which gives you the distance between the two.
       	values.particle1Ofdistance = values.particleVelocity1 * values.time1; 
    	values.particle2Ofdistance = values.particleVelocity2 * values.time2; 
    	
		// Condition to know which travels the greatest distance.
    	if (values.particleVelocity1 > values.particleVelocity2) {
    		System.out.println("A primeira percorrerá uma distância maior que a segunda.");
    	} else if (values.particleVelocity2 > values.particleVelocity1) {
    		System.out.println("A segunda percorrerá uma distância maior que a primeira.");
    	} else if(values.time1 > values.time2){
    		System.out.println("A primeira percorrerá uma distância maior eu um curto espaço de tempo.");
    	} else if (values.time2 > values.time1) {
    		System.out.println("A segunda percorrerá uma distância maior em um curto espaço de tempo.");
        } else {
    	    System.out.println("Ambos estão percorrendo a mesma distância lado a lado.");
    	}
       	
	    sc.close();
	}

}
