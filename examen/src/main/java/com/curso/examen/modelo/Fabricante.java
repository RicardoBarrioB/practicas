package com.curso.examen.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "fabricantes")
public class Fabricante implements Serializable {
    
    int idFabricante;
    String fabricante;
    


}
