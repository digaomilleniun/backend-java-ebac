package Exercise_module7;

import java.util.Locale;
import java.util.Scanner;

import util.racingParticles_mod7;

public class racingParticles_application {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		racingParticles_mod7 values = new  racingParticles_mod7();
		
		System.out.println("Digite a velocidade da primeira partícula (em metros por segundo m/s): ");
		values.particleVelocity1 = sc.nextDouble();	
		
		System.out.println("Digite a velocidade da segunda partícula (em metros por segundo m/s):");
		
		values.particleVelocity2 = sc.nextDouble();
		
	    System.out.println("Informe o tempo da primeira particula em (metros por segundo m/s): ");
				
       	values.time1 = sc.nextDouble();
       	
       	System.out.println("Informe o tempo da segunda particula em (metros por segundo m/s): ");
       	values.time2 = sc.nextDouble();
       	
       	values.particle1Ofdistance = values.particleVelocity1 * values.time1; 
    	values.particle2Ofdistance = values.particleVelocity2 * values.time2; 
    	
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
