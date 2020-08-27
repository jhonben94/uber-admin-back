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
import py.com.uber.admin.entities.Permisos;
import py.com.uber.admin.model.params.PaginadoParam;
import py.com.uber.admin.model.result.PaginadoResult;

@Service
public class PermisosService {
	
	@Autowired
	private PermisoDAO dao;
	

	@Transactional( readOnly= true)
	public PaginadoResult<Permisos> listar(PaginadoParam<Permisos> param) {

		ExampleMatcher matcher = ExampleMatcher.matching()
		    .withStringMatcher(StringMatcher.CONTAINING);
		
		Example<Permisos> example = Example.of(param.getFiltros(),matcher);
		
			Page<Permisos> lista = dao.findAll(example,
				PageRequest.of(
						param.getPagina(), 
						param.getCantidad(), 
						Sort.by(
								param.getOrderDir().equals("ASC")? Sort.Direction.ASC:Sort.Direction.DESC,
								param.getOrderBy())
						));
				PaginadoResult<Permisos> result = new PaginadoResult<>(lista);
				return result;
	}
	
	@Transactional
	public Permisos guardar(Permisos param){
		return dao.save(param);
	}
	@Transactional
	public Permisos modificar(Permisos param, Integer id){
		Permisos entidad =dao.getOne(id);
		entidad.setDescripcion(param.getDescripcion());
		return dao.save(entidad);
	}
	@Transactional( readOnly= true)
	
	public Permisos obtener( Integer id){
		return dao.findById(id).orElse(null);
	}
	
	@Transactional
	public void eliminar(Integer id){
		dao.deleteById(id);
	}
	
	@Transactional( readOnly= true)
	public List<Permisos> listar(){
		return dao.findAll();
	}
	
	@Transactional
	public Permisos desactivar( Integer id){
		Permisos entidad =dao.getOne(id);
		entidad.setActivo("N");
		return dao.save(entidad);
	}
	
	@Transactional
	public Permisos activar( Integer id){
		Permisos entidad =dao.getOne(id);
		entidad.setActivo("S");
		return dao.save(entidad);
	}
	

}
