
package com.mycompany.superbatallamarvel;

import java.util.Random;

public abstract class Personaje {
    protected String nombre;
    protected int vida;
    protected int vidaMaxima;
    protected int ataque;
    protected int defensa;
    protected int velocidad;
    protected int precision;
    protected int evasion;
    protected Random rand = new Random();
    protected String habilidadNombre;
    protected String descripcion;

    public Personaje(String nombre, int vida, int ataque, int defensa, 
                    int velocidad, int precision, int evasion, 
                    String habilidadNombre, String descripcion) {
        this.nombre = nombre;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.precision = precision;
        this.evasion = evasion;
        this.habilidadNombre = habilidadNombre;
        this.descripcion = descripcion;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void recibirDano(int dano) {
        if (rand.nextInt(100) < evasion) {
            System.out.println(nombre + " esquivó el ataque!");
            return;
        }
        
        int danoReal = Math.max(dano - defensa, 0);
        vida -= danoReal;
        System.out.println(nombre + " recibe " + danoReal + " de daño. Vida restante: " + vida);
    }

    public void atacar(Personaje oponente) {
        if (rand.nextInt(100) > precision) {
            System.out.println(nombre + " falló el ataque!");
            return;
        }
        System.out.println(nombre + " ataca a " + oponente.nombre);
        oponente.recibirDano(ataque);
    }

    public abstract void habilidadEspecial(Personaje oponente);

    // Getters
    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getVelocidad() { return velocidad; }
    
    public void mostrarEstado() {
        System.out.printf("%s - Vida: %d/%d | Ataque: %d | Defensa: %d | Velocidad: %d%n",
                nombre, vida, vidaMaxima, ataque, defensa, velocidad);
    }
}