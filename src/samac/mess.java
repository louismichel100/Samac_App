/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samac;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author NGONO
 */
public class mess {
    private final StringProperty mes = new SimpleStringProperty();
 
    public final String get_mes() {
        return mes.get();
    }
    
     public final void set_mes(String value) {
        mes.set(value);
    }
 
 
    public final StringProperty mesProperty() {
        return mes;
    }
    
    private final StringProperty aut = new SimpleStringProperty();
 
    public final String get_aut() {
        return aut.get();
    }
    
     public final void set_aut(String value) {
        aut.set(value);
    }
 
    
 
    public final StringProperty autProperty() {
        return aut;
    }
    
    private final StringProperty tp = new SimpleStringProperty();
 
    public final String get_tp() {
        return tp.get();
    }
    
     public final void set_tp(String value) {
        tp.set(value);
    }
 
    
 
    public final StringProperty tpProperty() {
        return tp;
    }
    
}
