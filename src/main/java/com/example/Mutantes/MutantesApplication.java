package com.example.Mutantes;

import com.example.Mutantes.services.DnaService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MutantesApplication {



	// Las letras de los Strings solo pueden ser: (A,T,C,G)
	static String[] dnaString = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	static String[] dnaString1 = {"ATCG","ATGC","ATGC","ATCG"};

	public static void main(String[] args) {
	//	SpringApplication.run(MutantesApplication.class, args);

		// Capturamos el tiempo antes de ejecutar el algoritmo
		long startTime = System.nanoTime();


		if (DnaService.isMutant(dnaString)){
			System.out.println("Es mutante");
		} else {
			System.out.println("No es mutante");
		}


		// Capturamos el tiempo después de ejecutar el algoritmo
		long endTime = System.nanoTime();

		// Calculamos la diferencia en nanosegundos
		long duration = (endTime - startTime);

		System.out.println("El tiempo de ejecución es: " + duration + " nanosegundos.");


	}
}
