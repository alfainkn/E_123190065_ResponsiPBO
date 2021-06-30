/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import view.View;
import controller.Controller;
import model.Model;
/**
 *
 * @author HP
 */
public class Responsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
                View applyView = new View();
                Model applyModel = new Model();
                Controller controller = new Controller(applyView, applyModel);
        
        
    }
    
}
