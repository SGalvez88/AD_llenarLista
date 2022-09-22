/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llenadolista;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import llenadolista.Controller.InterfazPaises;
import llenadolista.Controller.Lista;

/**
 *
 * @author galve
 */
public class LlenadoLista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Lista lista = new Lista();
//        lista.setVisible(true);
        iniciarInterfaz(lecturaFichero());
    }
    
    private static ArrayList<String> lecturaFichero(){
        String rutaFichero = "src\\llenadolista\\todosPaises.txt";
        String linea = "";
        ArrayList<String> paises = new ArrayList<>();
                
        try {
            FileReader fileReader = new FileReader(rutaFichero);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
           
            while ((linea = bufferedReader.readLine()) != null) {
                paises.add(linea);
            }
            
            bufferedReader.close();
            fileReader.close();
            
            return paises;

        } catch (Exception exception) {
            
            JOptionPane.showMessageDialog(null, "Se ha producido un error al leer el fichero");
        }
            return paises;
    }

    private static void iniciarInterfaz(ArrayList<String> paises) {
        if(paises.isEmpty()){
            return;
        }
        
        InterfazPaises interfazPaises = new InterfazPaises();
        interfazPaises.showInformation(paises);
        interfazPaises.setVisible(true);
    }
    
}
