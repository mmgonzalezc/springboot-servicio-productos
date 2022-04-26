package com.formacionbdi.springboot.app.productos.models.dao;

import com.formacionbdi.springboot.app.productos.models.entiy.Producto;
import org.springframework.data.repository.CrudRepository;
/***
 * Cuando se hereda por defecto ya es un objeto manejado por sprint
 * No es necesario a notar con ninguna anotacion xq se registra por debajo
 *
 */
public interface ProductoDao extends CrudRepository <Producto,Long>{


}
