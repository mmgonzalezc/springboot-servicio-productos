package com.formacionbdi.springboot.app.productos.models.service;

import com.formacionbdi.springboot.app.productos.models.entiy.Producto;

import java.util.List;

public interface IproductoService {
    /***
     * CRUD
     * @return
     */
    public List<Producto> findAll();
    public Producto findById(Long id);
    public Producto save(Producto producto);
    public void deleteById(Long id);
}
