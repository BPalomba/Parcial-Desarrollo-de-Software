package com.example.Mutantes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MutantesApplicationTests {

	@Test
	void testIsMutant() {
		String[] dna = {
				"ATG",
				"CGA",
				"TGC"
		};
		assertEquals(false,Detector.isMutant(dna));
	}

	@Test
	void testIsMutant1(){
		String[] dnaTrue0 = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

		assertEquals(true,Detector.isMutant(dnaTrue0));

	}

	@Test
	void testIsMutant2(){
		String[] dnaTrue1 = {"ATCG","ATGC","ATGC","ATCG"};

		assertEquals(true, Detector.isMutant(dnaTrue1));
	}

	@Test
	void testIsMutant3(){
		String[] dna = {
				"ATGCGATA",
				"CAGTGCTA",
				"TTATGTGG",
				"AGAAGGCT",
				"CCCCTATT",
				"TCACTGGA",
				"TGCATCGG",
				"CGATAGCC"
		};

		assertEquals(true, Detector.isMutant(dna));
	}

	@Test
	void testIsMutant4(){
		String[] dna = {
				"ATGCGATACTGG",
				"CAGTGCATGTGC",
				"TTATGTGGTTAC",
				"AGAAGGCTGCCT",
				"CCACTATTCAAA",
				"TCACTGGATGGG",
				"TGCATCGGACTA",
				"CGATAGCCAGTT",
				"GCTTAGCGTTAC",
				"ATTGCGGTTACC",
				"TGCCTAGGGAAC",
				"TCAAGGGTTTAA"
		};

		assertEquals(true, Detector.isMutant(dna));
	}


	@Test
	void testIsMutant5(){
		String[] dna = {
				"ATGCGATACTGGAAA",
				"CAGTGCATGTGCAAA",
				"TTATGTGGTTACCCC",
				"AGAAGGCTGCCTCCC",
				"CCCCTATTCAAGGGG",
				"TCACTGGATGGGGAA",
				"TGCATCGGAAAAATA",
				"CGATAGCCAGTTAAA",
				"GCTTAGCGTTACAAA",
				"ATTGCGGTTACCGGG",
				"TGCCTAGGGAACAAA",
				"TCAAGGGTTTAAAGA",
				"GATCCTGGAATCAGA",
				"CTAGCCTGAATCGGA",
				"GTCGGCAGTCGGCAT"
		};

		assertEquals(true, Detector.isMutant(dna));
	}

	@Test
	void testIsMutantDiagonal(){
		String[] dna = {
				"AGCC",
				"GACG",
				"ACAG",
				"CCCA"
		};

		assertEquals(true, Detector.isMutant(dna));
	}


	@Test
	void testIsMutantDiagonalJuguete(){
		String[] dna = {
				"AGCCG",
				"ACCGG",
				"AAGGC",
				"CGACA",
				"ACGAA"
		};

		assertEquals(true, Detector.isMutant(dna));
	}
}
