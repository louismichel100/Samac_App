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
import javafx.event.EventHandler;
import static javafx.scene.input.KeyCode.ESCAPE;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author NGONO
 */
public class note {
   
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
    
    private final StringProperty nom = new SimpleStringProperty();
 
    public final String get_nom() {
        return nom.get();
    }
 
    public final void set_nom(String value) {
        nom.set(value);
    }
 
    public final StringProperty nomProperty() {
        return nom;
    }
    
    private final StringProperty cc = new SimpleStringProperty();
 
    public final String get_cc() {
        return cc.get();
    }
    
    

    public final void set_cc(String value) {
        cc.set(value);
    }
 
    public final StringProperty ccProperty() {
        return cc;
    }
    
    private final StringProperty exam = new SimpleStringProperty();
 
    public final String get_exam() {
        return exam.get();
    }
 
    public final void set_exam(String value) {
        exam.set(value);
    }
 
    public final StringProperty examProperty() {
        return exam;
    }
    /////////
    
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
 
    public final void addPropertyChangeListener(String property, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(property, listener);
    }
 
    public final void removePropertyChangeListener(String property, PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(property, listener);
    }
 
    private final void firePropertyChange(String property, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(property, oldValue, newValue);
    }
    
    private final StringProperty na = new SimpleStringProperty();
 
    public final String get_na() {
        return na.get();
    }
 
    public final void set_na(String value) {
        na.set(value);
    }
 
    public final StringProperty naProperty() {
        return na;
    }
    
}
