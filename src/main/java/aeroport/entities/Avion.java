package aeroport.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "AVIONS")
public class Avion implements Serializable {
    @Id
    @Column(name="ID_AVION")
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Long idAvion;
    
    @Column(name="NOM_AVION")
    private String nomAvion;
    
    private double prix;
    
    @ManyToOne
    private Type type;
    
    public Avion() {
        super();
    }
    
    public Avion(String nomAvion, double prix, Type type) {
        super();
        this.nomAvion = nomAvion;
        this.prix = prix;
        this.type = type;
    }
public Type getType() {
return type;
}
public void setType(Type type) {
this.type = type;
}


public Avion(String nomAvion, double prix) {
super();
this.nomAvion = nomAvion;
this.prix = prix;
}
public Long getIdAvion() {
return idAvion;
}
public void setIdAvion(Long idAvion) {
this.idAvion = idAvion;
}
public String getNomAvion() {
return nomAvion;
}
public void setNomAvion(String nomAvion) {
this.nomAvion = nomAvion;
}
public double getPrix() {
return prix;
}
public void setPrix(double prix) {
this.prix = prix;
}
@Override
public String toString() {
return "Avion [idAvion=" + idAvion + ", nomAvion=" + nomAvion + ", prix=" + prix + "]";
}
}

