package com.mycompany.superbatallamarvel;
import java.util.Scanner;

public class SuperbatallaMarvel {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in) // Cerrar el Scanner al final
        ) {
            System.out.println("=== CONFIGURACIÓN INICIAL ===");
            
            // Configurar Wolverine
            System.out.println("\n-- WOLVERINE --");
            System.out.print("Introduce los puntos de vida: ");
            int vidaWolverine = sc.nextInt();
            System.out.print("Introduce el ataque: ");
            int ataqueWolverine = sc.nextInt();
            
            // Configurar Deadpool
            System.out.println("\n-- DEADPOOL --");
            System.out.print("Introduce los puntos de vida: ");
            int vidaDeadpool = sc.nextInt();
            System.out.print("Introduce el ataque: ");
            int ataqueDeadpool = sc.nextInt();
            
            // Crear personajes con valores personalizados
            Personaje wolverine = new Wolverine(vidaWolverine, ataqueWolverine, 8, 7, 85, 15);
            Personaje deadpool = new Deadpool(vidaDeadpool, ataqueDeadpool, 5, 9, 75, 20);
            
            System.out.println("\n=== INICIO DE LA PELEA ===");
            wolverine.mostrarEstado();
            deadpool.mostrarEstado();
            System.out.println("--------------------------");

            // Determinar quién ataca primero
            Personaje atacante = (wolverine.getVelocidad() >= deadpool.getVelocidad()) ? wolverine : deadpool;
            Personaje defensor = (atacante == wolverine) ? deadpool : wolverine;

            int turno = 1;
            while (wolverine.estaVivo() && deadpool.estaVivo()) {
                System.out.println("\n--- Turno " + turno + " ---");
                
                if (atacante.estaVivo()) {
                    atacante.habilidadEspecial(defensor);
                    atacante.atacar(defensor);
                }
                
                if (defensor.estaVivo()) {
                    defensor.habilidadEspecial(atacante);
                    defensor.atacar(atacante);
                }

                turno++;
                esperar(1500);
            }

            mostrarResultado(wolverine, deadpool);
        }
    }

    private static void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void mostrarResultado(Personaje p1, Personaje p2) {
        System.out.println("\n=== RESULTADO ===");
        p1.mostrarEstado();
        p2.mostrarEstado();

        if (p1.estaVivo() && !p2.estaVivo()) {
            System.out.println("\n¡" + p1.getNombre() + " gana!");
        } else if (p2.estaVivo() && !p1.estaVivo()) {
            System.out.println("\n¡" + p2.getNombre() + " gana!");
        } else {
            System.out.println("\n¡Empate!");
        }
    }
}