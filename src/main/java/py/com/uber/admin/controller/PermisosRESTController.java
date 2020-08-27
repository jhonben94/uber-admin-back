package py.com.uber.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;


import py.com.uber.admin.Globales;
import py.com.uber.admin.entities.Permisos;
import py.com.uber.admin.entities.Permisos;
import py.com.uber.admin.model.Respuesta;
import py.com.uber.admin.model.params.PaginadoParam;
import py.com.uber.admin.model.result.PaginadoResult;
import py.com.uber.admin.services.PermisosService;

@RestController
@RequestMapping("/permisos")
public class PermisosRESTController {
	@Autowired
	private PermisosService service;
	@PostMapping(path="/paginado")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity <?> listarPaginado(@RequestBody PaginadoParam<Permisos> param){
		try {
			PaginadoResult<Permisos> lista = service.listar(param);
			return new ResponseEntity <PaginadoResult<?>>(lista,HttpStatus.OK);	
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity <Void>(HttpStatus.CONFLICT);	
		}
	}
	
	@PostMapping("/")
	public  ResponseEntity <?> agregarRecurso (@RequestBody Permisos param){
		Respuesta<Permisos> respuesta = new Respuesta<>();

		try {
			Permisos dato = service.guardar(param);
			respuesta.setDato(dato);
			respuesta.setMensaje(Globales.MensajeCRUD.MENSAJE_AGREGAR);
			respuesta.setExitoso(true);
			return new ResponseEntity <Respuesta<?>>(respuesta,HttpStatus.CREATED);	
			
		} catch (Exception e) {
			respuesta.setMensaje(e.getMessage());
			respuesta.setExitoso(false);
			return new ResponseEntity <Respuesta<?>>(respuesta,HttpStatus.CONFLICT);
		}
		
	}
	
	@PutMapping("/{id}")
	public  ResponseEntity <?> modificarRecurso (@PathVariable("id")Integer id ,  @RequestBody Permisos param){
		Respuesta<Permisos> respuesta = new Respuesta<>();

		try {
			Permisos dato = service.modificar(param,id);
			respuesta.setDato(dato);
			respuesta.setMensaje(Globales.MensajeCRUD.MENSAJE_MODIFICAR);
			respuesta.setExitoso(true);
			return new ResponseEntity <Respuesta<?>>(respuesta,HttpStatus.OK);	
			
		} catch (Exception e) {
			respuesta.setMensaje(e.getMessage());
			respuesta.setExitoso(false);
			return new ResponseEntity <Respuesta<?>>(respuesta,HttpStatus.CONFLICT);
		}
		
	}
	@GetMapping("/{id}")
	public  ResponseEntity <?> obtenerRecurso (@PathVariable("id")Integer id ){
		Respuesta<Permisos> respuesta = new Respuesta<>();

		try {
			Permisos dato = service.obtener(id);
			System.out.println(dato);
			if(dato==null) {
				respuesta.setMensaje(Globales.MensajeCRUD.MENSAJE_OBTENER_ERROR);
				respuesta.setExitoso(false);
				return new ResponseEntity <Respuesta<?>>(respuesta,HttpStatus.NOT_FOUND);
			}
			respuesta.setDato(dato);
			respuesta.setMensaje(Globales.MensajeCRUD.MENSAJE_OBTENER);
			respuesta.setExitoso(true);
			return new ResponseEntity <Respuesta<?>>(respuesta,HttpStatus.OK);	
			
		} catch (Exception e) {
			respuesta.setMensaje(e.getMessage());
			respuesta.setExitoso(false);
			return new ResponseEntity <Respuesta<?>>(respuesta,HttpStatus.CONFLICT);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public  ResponseEntity <?> eliminarRecurso (@PathVariable("id")Integer id ){
		Respuesta<Permisos> respuesta = new Respuesta<>();

		try {
			service.eliminar(id);
			respuesta.setMensaje(Globales.MensajeCRUD.MENSAJE_ELIMINAR);
			respuesta.setExitoso(true);
			return new ResponseEntity <Respuesta<?>>(respuesta,HttpStatus.OK);	

		} catch (Exception e) {
			respuesta.setMensaje(e.getMessage());
			respuesta.setExitoso(false);
			return new ResponseEntity <Respuesta<?>>(respuesta,HttpStatus.CONFLICT);		}

	}
	
	@GetMapping("/")
	public  ResponseEntity <?> listar ( ){
		Respuesta<List<Permisos> > respuesta = new Respuesta<>();
		List<Permisos> dato = new ArrayList<Permisos>();
		try {
			dato = service.listar();
			System.out.println(dato);
			if(dato==null) {
				respuesta.setDato(dato);
				respuesta.setMensaje(Globales.MensajeCRUD.MENSAJE_OBTENER_ERROR);
				respuesta.setExitoso(false);
				return new ResponseEntity <Respuesta<?>>(respuesta,HttpStatus.NOT_FOUND);
			}
			
			respuesta.setDato(dato);
			respuesta.setExitoso(true);
			return new ResponseEntity <Respuesta<?>>(respuesta,HttpStatus.OK);	
			
		} catch (Exception e) {
			respuesta.setMensaje(e.getMessage());
			respuesta.setExitoso(false);
			return new ResponseEntity <Respuesta<?>>(respuesta,HttpStatus.CONFLICT);
		}

	}
	
	@PutMapping(path="/{id}/activar")
	public  ResponseEntity <?> activar (@PathVariable("id")Integer id ){
		Respuesta<Permisos> respuesta = new Respuesta<>();

		try {
			Permisos dato = service.activar(id);
			respuesta.setDato(dato);
			respuesta.setMensaje(Globales.MensajeCRUD.MENSAJE_ACTIVAR);
			respuesta.setExitoso(true);
			return new ResponseEntity <Respuesta<?>>(respuesta,HttpStatus.OK);	
			
		} catch (Exception e) {
			respuesta.setMensaje(e.getMessage());
			respuesta.setExitoso(false);
			return new ResponseEntity <Respuesta<?>>(respuesta,HttpStatus.CONFLICT);
		}
		
	}
	
	@PutMapping(path="/{id}/desactivar")
	public  ResponseEntity <?> descativar (@PathVariable("id")Integer id ){
		Respuesta<Permisos> respuesta = new Respuesta<>();

		try {
			Permisos dato = service.desactivar(id);
			respuesta.setDato(dato);
			respuesta.setMensaje(Globales.MensajeCRUD.MENSAJE_DESACTIVAR);
			respuesta.setExitoso(true);
			return new ResponseEntity <Respuesta<?>>(respuesta,HttpStatus.OK);	
			
		} catch (Exception e) {
			respuesta.setMensaje(e.getMessage());
			respuesta.setExitoso(false);
			return new ResponseEntity <Respuesta<?>>(respuesta,HttpStatus.CONFLICT);
		}
		
	}

}
