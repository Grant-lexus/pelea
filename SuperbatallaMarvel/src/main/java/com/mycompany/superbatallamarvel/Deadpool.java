
package com.mycompany.superbatallamarvel;




public class Deadpool extends Personaje {
    private int balasEspeciales;
    
// En Deadpool.java
public Deadpool(int vida, int ataque, int defensa, int velocidad, int precision, int evasion) {
    super("Deadpool", vida, ataque, defensa, velocidad, precision, evasion,
          "Cuarta Pared", "Regeneración acelerada");
    // ... inicializaciones adicionales

    }

    @Override
    public void habilidadEspecial(Personaje oponente) {
        if (balasEspeciales > 0) {
            int dano = 15 + rand.nextInt(20);
            System.out.println(nombre + " usa " + habilidadNombre + " con pistolas!");
            oponente.recibirDano(dano);
            balasEspeciales--;
        } else {
            int curacion = rand.nextInt(12) + 8;
            vida = Math.min(vida + curacion, vidaMaxima);
            System.out.println(nombre + " se cura " + curacion + " puntos. Vida: " + vida);
            
            if (rand.nextDouble() < 0.25) {
                balasEspeciales = 3;
                System.out.println("¡" + nombre + " recargó sus pistolas!");
            }
        }
    }
}
