/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samac;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author NGONO
 */
public class Truc {
    ////////////////////////////////////////////////////////////////////////////
    // Propriétés JavaFX.
    /*private final BooleanProperty visible = new SimpleBooleanProperty();
 
    public final boolean isVisible() {
        return visible.get();
    }
 
    public final void setVisible(boolean value) {
        visible.set(value);
    }
 
    public final BooleanProperty visibleProperty() {
        return visible;
    }
    private final StringProperty name = new SimpleStringProperty();
 
    public final String getName() {
        return name.get();
    }
 
    public final void setName(String value) {
        name.set(value);
    }
 
    public final StringProperty nameProperty() {
        return name;
    }
    ////////////////////////////////////////////////////////////////////////////
    // Propriétés JavaBeans observables.
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
    private boolean opaque = false;
 
    public boolean isOpaque() {
        return opaque;
    }
 
    public void setOpaque(boolean value) {
        final boolean oldValue = opaque;
        opaque = value;
        firePropertyChange("opaque", oldValue, opaque);
    }
    private String comment;
 
    public String getComment() {
        return comment;
    }
 
    public void setComment(String value) {
        final String oldValue = comment;
        comment = value;
        firePropertyChange("comment", oldValue, comment);
    }
 
    ////////////////////////////////////////////////////////////////////////////
    // Autres
 
    public boolean administrator;
    public String email;

*/
    
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
    
}

