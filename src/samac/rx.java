/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samac;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author NGONO
 */
public class rx {
     private final StringProperty mat = new SimpleStringProperty();
 
    public final String get_mat() {
        return mat.get();
    }
    
     public final void set_mat(String value) {
        mat.set(value);
    }
 
 
    public final StringProperty matProperty() {
        return mat;
    }
    
    private final StringProperty val = new SimpleStringProperty();
 
    public final String get_val() {
        return val.get();
    }
    
     public final void set_val(String value) {
        val.set(value);
    }
 
    
 
    public final StringProperty valProperty() {
        return val;
    }
    
    private final StringProperty val_p = new SimpleStringProperty();
 
    public final String get_val_p() {
        return val_p.get();
    }
    
     public final void set_val_p(String value) {
        val_p.set(value);
    }
 
    
 
    public final StringProperty valProperty_p() {
        return val_p;
    }
    
}
