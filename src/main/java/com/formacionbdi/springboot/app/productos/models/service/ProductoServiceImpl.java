package com.formacionbdi.springboot.app.productos.models.service;

import com.formacionbdi.springboot.app.productos.models.dao.ProductoDao;
import com.formacionbdi.springboot.app.commons.model.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements IproductoService{
    @Autowired
    private ProductoDao productoDao;

    @Override
    /**
     * Transaccion solo de lectura
     */
    @Transactional(readOnly = true) // Transactional de lectura
    public List<Producto> findAll() {
        return (List<Producto>) productoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true) // Transactional de lectura
    public Producto findById(Long id) {
        return productoDao.findById(id).orElse(null);
    }


    @Override
    @Transactional  // Transactional de escritura
    public Producto save(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    @Transactional  // Transactional de escritura
    public void deleteById(Long id) {
        productoDao.deleteById(id);
    }
}
