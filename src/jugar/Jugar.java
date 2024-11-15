/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugar;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Maria Gabriela
 */
public class Jugar {

    public static void main(String[] args) {
        while(true){
        while(true){
        String[] palabras = {"LENGUAJE", "HONDURAS", "PROGRAMAR", "CAMPEON", "ANIMALES", 
                              "VIDEOJUEGOS", "MEXICO", "MESSI", "PERROS", "OPTIMIZAR"};
        int npalabras = palabras.length;  
       int menu;
       menu=Integer.parseInt(JOptionPane.showInputDialog("-------MENU-------\n"+"1. Jugar\n"
               + "2. Cambiar Palabras\n"
               + "3. Salir"));
       switch(menu){
       case 1:
      
      Random random = new Random();
      String palabrar = palabras[random.nextInt(palabras.length)];
      char[] progreso = new char[palabrar.length()];
      
      int contador = 5;
        for (int i = 0; i < progreso.length; i++) {
            progreso[i] = '_';
        }

        while (contador > 0) {
        
            String progresoa = "";
            for (char x : progreso) {
               progresoa += x + " ";
            }
            
        String entrada = JOptionPane.showInputDialog(null,  "Palabra: " + progresoa.toString()+"\n" + "Oportunidades: "+ contador+"\n"+"Ingrese un carácter:");
        
          if (entrada == null || entrada.length() < 1) {
                JOptionPane.showMessageDialog(null, "Por favor solo ingrese un caracteres validos.");
                continue;
            }

            char intento = entrada.toUpperCase().charAt(0);
            int aciertos = 0; 

            for (int i = 0; i < palabrar.length(); i++) {
                if (palabrar.charAt(i) == intento) {
                        progreso[i] = intento;
                        aciertos++;
                }
                    
                }
             if (aciertos == 0) {
                contador--;
                JOptionPane.showMessageDialog(null, "La palabra no contiene: " +intento);
            } else {
                JOptionPane.showMessageDialog(null, "La palabra si contiene "+intento);
            }
             
            int completados = 0;
            for (char x : progreso) {
                if (x != '_') {
                    completados++;
                }
            }

            if (completados == palabrar.length()) {
                JOptionPane.showMessageDialog(null, "Adivinaste la palabra: "+palabrar);
                break;
                
            }           
         }
          if (contador==0){
              JOptionPane.showMessageDialog(null, "La palabra era: " +palabrar);
          }

       break;
       case 2: 
                   
                    String lpalabras = "Palabras actuales:\n";
                    for (int i = 0; i < npalabras; i++) {
                        lpalabras += (i + 1) + ". " + palabras[i] + "\n"; 
                    }

                    String elegir = JOptionPane.showInputDialog(null, lpalabras +
                            "\nIngrese el número de la palabra que va a cambiar (1-" + npalabras + ") si no es asi presione cancelar para volver:");

                    if (elegir != null && !elegir.isEmpty()) {
                        int indice = Integer.parseInt(elegir) - 1;

                        if (indice >= 0 && indice < npalabras) {
                           
                            String nuevaPalabra = JOptionPane.showInputDialog(null, "Ingrese la nueva palabra:");

                            if (nuevaPalabra != null && !nuevaPalabra.isEmpty()) {
                                
                                palabras[indice] = nuevaPalabra.toUpperCase();

                                JOptionPane.showMessageDialog(null, "La palabra ha sido reemplazada .");
                                JOptionPane.showMessageDialog(null,palabras);
                                
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Intente de nuevo.");
                        }
                    }
                    break;
        case 3:
            JOptionPane.showMessageDialog(null, "Gracias por jugar");
            System.exit(0);
        break;
        default:
            JOptionPane.showMessageDialog(null, "Solo use las opciones del menu");
            
        }
        }
        
    }
    
}
}