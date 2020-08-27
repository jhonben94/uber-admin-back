package py.com.uber.admin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.com.uber.admin.dao.VehiculosDAO;
import py.com.uber.admin.entities.Vehiculos;
import py.com.uber.admin.entities.Vehiculos;
import py.com.uber.admin.model.params.PaginadoParam;
import py.com.uber.admin.model.result.PaginadoResult;

@Service
public class VehiculosService {
	
	@Autowired
	private VehiculosDAO dao;
	

	@Transactional( readOnly= true)
	public PaginadoResult<Vehiculos> listar(PaginadoParam<Vehiculos> param) {

		ExampleMatcher matcher = ExampleMatcher.matching()
		    .withStringMatcher(StringMatcher.CONTAINING);
		
		Example<Vehiculos> example = Example.of(param.getFiltros(),matcher);
		
			Page<Vehiculos> lista = dao.findAll(example,
				PageRequest.of(
						param.getPagina(), 
						param.getCantidad(), 
						Sort.by(
								param.getOrderDir().equals("ASC")? Sort.Direction.ASC:Sort.Direction.DESC,
								param.getOrderBy())
						));
				PaginadoResult<Vehiculos> result = new PaginadoResult<>(lista);
				return result;
	}
	
	@Transactional
	public Vehiculos guardar(Vehiculos param){
		return dao.save(param);
	}
	@Transactional
	public Vehiculos modificar(Vehiculos param, Integer id){
		Vehiculos cpDB =dao.getOne(id);
		return dao.save(cpDB);
	}
	@Transactional( readOnly= true)
	
	public Vehiculos obtener( Integer id){
		return dao.findById(id).orElse(null);
	}
	
	@Transactional
	public void eliminar(Integer id){
		dao.deleteById(id);
	}
	
	@Transactional( readOnly= true)
	public List<Vehiculos> listar(){
		return dao.findAll();
	}
	@Transactional
	public Vehiculos desactivar( Integer id){
		Vehiculos entidad =dao.getOne(id);
		entidad.setActivo("N");
		return dao.save(entidad);
	}
	
	@Transactional
	public Vehiculos activar( Integer id){
		Vehiculos entidad =dao.getOne(id);
		entidad.setActivo("S");
		return dao.save(entidad);
	}

}
