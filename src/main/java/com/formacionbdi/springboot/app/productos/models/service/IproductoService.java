package com.formacionbdi.springboot.app.productos.models.service;

import com.formacionbdi.springboot.app.commons.model.entity.Producto;

import java.util.List;

public interface IproductoService {
    /***
     * CRUD
     * @return
     */
    List<Producto> findAll();
    Producto findById(Long id);
    Producto save(Producto producto);
    void deleteById(Long id);
}
