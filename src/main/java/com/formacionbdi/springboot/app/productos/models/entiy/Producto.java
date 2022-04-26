package com.formacionbdi.springboot.app.productos.models.entiy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/***
 * JPA Entidad relacional
 */
@Entity

/***
 * OPCIONAL SI NO SE INDICA TOMA EL NOMBRE DE LA CLASE
 */
@Table(name = "productos")

/***
 * implements Serializable
 * Buena practica importar de Serializable
 * Se implementa para guardar en session el entity o en archivo bytes
 */
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Key autoincremental
    private Long id;
    private String nombre;
    private Double precio;
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;
    /**
     * Indica que este atributo no es persistente
     * /
     */
    @Transient
    private Integer port;


    public Long getId() {
        return id;
    }

    public Producto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Producto setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Double getPrecio() {
        return precio;
    }

    public Producto setPrecio(Double precio) {
        this.precio = precio;
        return this;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Producto setCreateAt(Date createAt) {
        this.createAt = createAt;
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public Producto setPort(Integer port) {
        this.port = port;
        return this;
    }

    private static final long serialVersionUID = -2504204031894884958L;
}
