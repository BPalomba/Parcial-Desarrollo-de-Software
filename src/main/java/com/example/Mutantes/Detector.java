package com.example.Mutantes;

public class Detector {

    public static boolean isMutant(String[] dnaString){
        boolean diagonalinf = false;
        boolean diagonalsup = false;
        boolean horizontal = false;
        boolean vertical = false;

        //Inicializado en o
        char charRepetido = 'o';
        boolean posibleMutante = false;

        char[][] dna = new char[dnaString.length][];






        //Paso el String[] a Char[][]
        for (int i = 0; i < dnaString.length; i++) {
            dna[i] = dnaString[i].toCharArray();
        }



        //Recorro filas
        for ( int i = 0; i < dna.length ; i++ ) {
            //Recorro columnas
            for ( int k = 0 ; k < dna[i].length ; k++) {

                // Columna par y fila par    ||  Columna Impar y fila impar // X
                if ( (k%2 == 0 && i%2 == 0 ) || (k%2 != 0  && i%2 != 0)){

                    // HORIZONTAL
                    // Verifica horizontalmente, si no esta outOfBound y si no se ha
                    // descubierto una secuencia mutante para esa letra
                    if ( k + 2 < dna[i].length && dna[i][k] != charRepetido ){
                        if (dna[i][k] == dna[i][k+2]) {
                            if (dna [i][k] == dna [i][k+1]){
                                if ( k + 3 < dna[i].length ){

                                    if (dna [i][k] == dna [i][k+3]){

                                        charRepetido = dna[i][k];
                                    // Si ya se encontro una coincidencia de 4 letras, devuelve true
                                        if (posibleMutante) {
                                            return true;
                                        }

                                        posibleMutante = true;
                                    }

                                }
                                //Luego de una secuencia horizontal de 3 letras
                                if ( k > 0 && dna [i][k] != charRepetido){
                                    if (dna [i][k] == dna [i][k-1]){
                                        charRepetido = dna[i][k];
                                        // Si ya se encontro una coincidencia de 4 letras, devuelve true
                                        if (posibleMutante) {
                                            return true;
                                        }

                                        posibleMutante = true;
                                    }
                                }
                            }
                        }

                    }


                    // VERTICAL

                    if ( i + 2 < dna.length && dna[i][k] != charRepetido ){
                        if (dna[i][k] == dna[i+2][k]) {
                            if (dna [i][k] == dna [i+1][k]){
                                if ( i + 3 < dna.length ){

                                    if (dna [i][k] == dna [i+3][k]){
                                        charRepetido = dna[i][k];
                                        // Si ya se encontro una coincidencia de 4 letras, devuelve true
                                        if (posibleMutante) {
                                            return true;
                                        }

                                        posibleMutante = true;
                                    }

                                }
                                //Luego de una secuencia vertical de 3 letras
                                if ( dna[i][k] != charRepetido && i > 0){
                                    if (dna [i][k] == dna [i-1][k]){
                                        charRepetido = dna[i][k];
                                        // Si ya se encontro una coincidencia de 4 letras, devuelve true
                                        if (posibleMutante) {
                                            return true;
                                        }

                                        posibleMutante = true;
                                    }
                                }
                            }
                        }

                    }

                    //DIAGONAL SUPERIOR DERECHA

                    if ( dna[i][k] != charRepetido && i - 2 >= 0 && k + 2 < dna[i].length ){


                        if (dna[i][k] == dna[i-2][k+2]) {
                            if (dna [i][k] == dna [i-1][k+1]){
                                if ( k + 3 < dna[i].length && i - 3 <= 0 ){

                                    if (dna [i][k] == dna [i-3][k+3]){

                                        charRepetido = dna[i][k];
                                        // Si ya se encontro una coincidencia de 4 letras, devuelve true
                                        if (posibleMutante) {
                                            return true;
                                        }

                                        posibleMutante = true;
                                    }

                                }
                                //Luego de una secuencia horizontal de 3 letras
                                if ( k > 1 && i > 1 && dna [i][k] != charRepetido){
                                    if (dna [i][k] == dna [i-1][k-1]){
                                        charRepetido = dna[i][k];
                                        // Si ya se encontro una coincidencia de 4 letras, devuelve true
                                        if (posibleMutante) {
                                            return true;
                                        }

                                        posibleMutante = true;
                                    }
                                }
                            }
                        }

                    }

                    // DIAGONAL INFERIOR DERECHA

                    if ( dna[i][k] != charRepetido && i + 2 < dna.length && k + 2 < dna[i].length ){


                        if (dna[i][k] == dna[i+2][k+2]) {
                            if (dna [i][k] == dna [i+1][k+1]){
                                if ( k + 3 < dna[i].length && i + 3 < dna.length ){

                                    if (dna [i][k] == dna [i+3][k+3]){

                                        charRepetido = dna[i][k];
                                        // Si ya se encontro una coincidencia de 4 letras, devuelve true
                                        if (posibleMutante) {
                                            return true;
                                        }

                                        posibleMutante = true;
                                    }

                                }
                                //Luego de una secuencia horizontal de 3 letras
                                if ( k > 0 && i > 0 && dna [i][k] != charRepetido){
                                    if (dna [i][k] == dna [i-1][k-1]){
                                        charRepetido = dna[i][k];
                                        // Si ya se encontro una coincidencia de 4 letras, devuelve true
                                        if (posibleMutante) {
                                            return true;
                                        }

                                        posibleMutante = true;
                                    }
                                }
                            }
                        }

                    }



                }



                // Columna impar y fila mod 6 || Columna par y fila+3 mod 6 // D

                if((k%2 != 0 && i%6 == 0) || (k%2 == 0 && (i+3)%6 == 0)){

                    //DIAGONAL SUPERIOR DERECHA

                    if ( dna[i][k] != charRepetido && i - 2 >= 0 && k + 2 < dna[i].length ){


                        if (dna[i][k] == dna[i-2][k+2]) {
                            if (dna [i][k] == dna [i-1][k+1]){
                                if ( k + 3 < dna[i].length && i - 3 <= 0 ){

                                    if (dna [i][k] == dna [i-3][k+3]){

                                        charRepetido = dna[i][k];
                                        // Si ya se encontro una coincidencia de 4 letras, devuelve true
                                        if (posibleMutante) {
                                            return true;
                                        }

                                        posibleMutante = true;
                                    }

                                }
                                //Luego de una secuencia horizontal de 3 letras
                                if ( k > 1 && i > 1 && dna [i][k] != charRepetido){
                                    if (dna [i][k] == dna [i-1][k-1]){
                                        charRepetido = dna[i][k];
                                        // Si ya se encontro una coincidencia de 4 letras, devuelve true
                                        if (posibleMutante) {
                                            return true;
                                        }

                                        posibleMutante = true;
                                    }
                                }
                            }
                        }

                    }

                    //DIAGONAL INFERIOR DERECHA

                    if ( dna[i][k] != charRepetido && i + 2 < dna.length && k + 2 < dna[i].length ){


                        if (dna[i][k] == dna[i+2][k+2]) {
                            if (dna [i][k] == dna [i+1][k+1]){
                                if ( k + 3 < dna[i].length && i + 3 < dna.length ){

                                    if (dna [i][k] == dna [i+3][k+3]){

                                        charRepetido = dna[i][k];
                                        // Si ya se encontro una coincidencia de 4 letras, devuelve true
                                        if (posibleMutante) {
                                            return true;
                                        }

                                        posibleMutante = true;
                                    }

                                }
                                //Luego de una secuencia horizontal de 3 letras
                                if ( k > 0 && i > 0 && dna [i][k] != charRepetido){
                                    if (dna [i][k] == dna [i-1][k-1]){
                                        charRepetido = dna[i][k];
                                        // Si ya se encontro una coincidencia de 4 letras, devuelve true
                                        if (posibleMutante) {
                                            return true;
                                        }

                                        posibleMutante = true;
                                    }
                                }
                            }
                        }

                    }

                    // DIAGONAL SUPERIOR IZQUIERDA

                    if ( dna[i][k] != charRepetido && i - 2 >= 0 && k - 2 >= 0 ){


                        if (dna[i][k] == dna[i-2][k-2]) {
                            if (dna [i][k] == dna [i-1][k-1]){
                                if ( k - 3 >= 0 && i - 3 <= 0 ){

                                    if (dna [i][k] == dna [i-3][k-3]){

                                        charRepetido = dna[i][k];
                                        // Si ya se encontro una coincidencia de 4 letras, devuelve true
                                        if (posibleMutante) {
                                            return true;
                                        }

                                        posibleMutante = true;
                                    }

                                }
                                //Luego de una secuencia horizontal de 3 letras
                                if ( k + 1 < dna[i].length && i + 1 < dna.length  && dna [i][k] != charRepetido){
                                    if (dna [i][k] == dna [i+1][k+1]){
                                        charRepetido = dna[i][k];
                                        // Si ya se encontro una coincidencia de 4 letras, devuelve true
                                        if (posibleMutante) {
                                            return true;
                                        }

                                        posibleMutante = true;
                                    }
                                }
                            }
                        }

                    }

                    // DIAGIONAL INFERIOR IZQUIERDA

                    if ( dna[i][k] != charRepetido && i + 2 < dna.length && k - 2 >= 0 ){


                        if (dna[i][k] == dna[i+2][k-2]) {
                            if (dna [i][k] == dna [i+1][k-1]){
                                if ( k - 3 >= 0 && i + 3 < dna.length ){

                                    if (dna [i][k] == dna [i+3][k-3]){

                                        charRepetido = dna[i][k];
                                        // Si ya se encontro una coincidencia de 4 letras, devuelve true
                                        if (posibleMutante) {
                                            return true;
                                        }

                                        posibleMutante = true;
                                    }

                                }
                                //Luego de una secuencia horizontal de 3 letras
                                if ( k + 1 < dna[i].length && i > 0 && dna [i][k] != charRepetido){
                                    if (dna [i][k] == dna [i-1][k+1]){
                                        charRepetido = dna[i][k];
                                        // Si ya se encontro una coincidencia de 4 letras, devuelve true
                                        if (posibleMutante) {
                                            return true;
                                        }

                                        posibleMutante = true;
                                    }
                                }
                            }
                        }

                    }


                }

            }
            //System.out.println();
        }

        return false;
    }

}
