package com.formacionbdi.springboot.app.productos.controllers;

import com.formacionbdi.springboot.app.commons.model.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IproductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/***
 * Controlador rest de spring
 * Convierte a json lo que retornan los metodos handler
 */
@RestController
public class ProductoController {
    @Autowired
    private IproductoService iproductoService;
    /***
     * Para obetener el puerto real
     */
    @Autowired
    private Environment env;

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/listar")
    public List<Producto> listar() {
        return iproductoService.findAll().stream().map(producto -> {
            producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
            //producto.setPort(port);
            return producto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id) throws InterruptedException {
        if (id.equals(10L)) {
            throw new IllegalStateException("Producto no encontrado!");
        }
        if (id.equals(7L)) {
            TimeUnit.SECONDS.sleep(5L);
        }
        Producto producto = iproductoService.findById(id);
        producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        //producto.setPort(port);
        /***
        * Time out por defecto en ribbon y histrix es de 1 segundo
        /*
       try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return producto;
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto producto){
        // Nos permite crear o editar por debajo busca el objeto si no lo encuentra lo crea
        return iproductoService.save(producto);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto producto, @PathVariable Long id){
        Producto productoDB = iproductoService.findById(id);
        productoDB.setNombre(producto.getNombre());
        productoDB.setPrecio(producto.getPrecio());
         return iproductoService.save(productoDB);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        iproductoService.deleteById(id);
    }
}
