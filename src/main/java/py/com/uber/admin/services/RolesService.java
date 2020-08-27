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

import py.com.uber.admin.dao.PermisoDAO;
import py.com.uber.admin.dao.RolesDAO;
import py.com.uber.admin.entities.Roles;
import py.com.uber.admin.model.params.PaginadoParam;
import py.com.uber.admin.model.result.PaginadoResult;

@Service
public class RolesService {
	
	@Autowired
	private RolesDAO dao;
	

	@Transactional( readOnly= true)
	public PaginadoResult<Roles> listar(PaginadoParam<Roles> param) {

		ExampleMatcher matcher = ExampleMatcher.matching()
		    .withStringMatcher(StringMatcher.CONTAINING);
		
		Example<Roles> example = Example.of(param.getFiltros(),matcher);
		
			Page<Roles> lista = dao.findAll(example,
				PageRequest.of(
						param.getPagina(), 
						param.getCantidad(), 
						Sort.by(
								param.getOrderDir().equals("ASC")? Sort.Direction.ASC:Sort.Direction.DESC,
								param.getOrderBy())
						));
				PaginadoResult<Roles> result = new PaginadoResult<>(lista);
				return result;
	}
	
	@Transactional
	public Roles guardar(Roles param){
		return dao.save(param);
	}
	@Transactional
	public Roles modificar(Roles param, Integer id){
		Roles entidad =dao.getOne(id);
		entidad.setNombre(param.getNombre());
		return dao.save(entidad);
	}
	@Transactional( readOnly= true)
	
	public Roles obtener( Integer id){
		return dao.findById(id).orElse(null);
	}
	
	@Transactional
	public void eliminar(Integer id){
		dao.deleteById(id);
	}
	
	@Transactional( readOnly= true)
	public List<Roles> listar(){
		return dao.findAll();
	}
	
	@Transactional
	public Roles desactivar( Integer id){
		Roles entidad =dao.getOne(id);
		entidad.setActivo("N");
		return dao.save(entidad);
	}
	
	@Transactional
	public Roles activar( Integer id){
		Roles entidad =dao.getOne(id);
		entidad.setActivo("S");
		return dao.save(entidad);
	}
	

}
