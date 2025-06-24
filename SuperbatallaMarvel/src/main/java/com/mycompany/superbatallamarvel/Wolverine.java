/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.superbatallamarvel;

public class Wolverine extends Personaje {
    private int acumuladorFuria;
    
// En Wolverine.java
public Wolverine(int vida, int ataque, int defensa, int velocidad, int precision, int evasion) {
    super("Wolverine", vida, ataque, defensa, velocidad, precision, evasion, 
          "Garras de Adamantium", "Factor curativo");
    // ... inicializaciones adicionales
}

    @Override
    public void habilidadEspecial(Personaje oponente) {
        acumuladorFuria++;
        if (acumuladorFuria >= 3) {
            int dano = ataque * 2;
            System.out.println(nombre + " entra en FURIA con sus " + habilidadNombre + "!");
            oponente.recibirDano(dano);
            acumuladorFuria = 0;
        } else {
            int curacion = rand.nextInt(15) + 10;
            vida = Math.min(vida + curacion, vidaMaxima);
            System.out.println(nombre + " se cura " + curacion + " puntos. Vida: " + vida);
        }
    }
}