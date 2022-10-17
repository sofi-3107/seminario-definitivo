
package com.mycompany.seminario;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Sofi
 */
public class FastClearControls {
    
    
    
      public static void clearTextFields(TextField... campos){
        for(TextField c:campos){
            c.clear();
        }
    }
        public static void clearComboBoxes(ComboBox... combos){
        for(ComboBox c:combos){
           c.getSelectionModel().clearSelection();
        }
    }
}
