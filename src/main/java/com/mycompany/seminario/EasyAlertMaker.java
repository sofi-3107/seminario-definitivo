
package com.mycompany.seminario;

import javafx.scene.control.Alert;

/**
 *
 * @author Sofi
 */
public class EasyAlertMaker {
    
    
    public static Alert alertMessager(Alert.AlertType type, String title, String content) {
        Alert a = new Alert(type);
        a.setTitle(title);
        a.setContentText(content);
        return a;
    }
    
}
