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

import py.com.uber.admin.dao.MarcasDAO;
import py.com.uber.admin.entities.Marcas;
import py.com.uber.admin.model.params.PaginadoParam;
import py.com.uber.admin.model.result.PaginadoResult;

@Service
public class MarcasService {
	
	@Autowired
	private MarcasDAO dao;
	

	@Transactional( readOnly= true)
	public PaginadoResult<Marcas> listar(PaginadoParam<Marcas> param) {

		ExampleMatcher matcher = ExampleMatcher.matching()
		    .withStringMatcher(StringMatcher.CONTAINING);
		
		Example<Marcas> example = Example.of(param.getFiltros(),matcher);
		
			Page<Marcas> lista = dao.findAll(example,
				PageRequest.of(
						param.getPagina(), 
						param.getCantidad(), 
						Sort.by(
								param.getOrderDir().equals("ASC")? Sort.Direction.ASC:Sort.Direction.DESC,
								param.getOrderBy())
						));
				PaginadoResult<Marcas> result = new PaginadoResult<>(lista);
				return result;
	}
	
	@Transactional
	public Marcas guardar(Marcas param){
		return dao.save(param);
	}
	@Transactional
	public Marcas modificar(Marcas param, Integer id){
		Marcas entidad =dao.getOne(id);
		entidad.setDescripcion(param.getDescripcion());
		return dao.save(entidad);
	}
	@Transactional( readOnly= true)
	
	public Marcas obtener( Integer id){
		return dao.findById(id).orElse(null);
	}
	
	@Transactional
	public void eliminar(Integer id){
		dao.deleteById(id);
	}
	
	@Transactional( readOnly= true)
	public List<Marcas> listar(){
		return dao.findAll();
	}
	@Transactional
	public Marcas desactivar( Integer id){
		Marcas entidad =dao.getOne(id);
		entidad.setActivo("N");
		return dao.save(entidad);
	}
	
	@Transactional
	public Marcas activar( Integer id){
		Marcas entidad =dao.getOne(id);
		entidad.setActivo("S");
		return dao.save(entidad);
	}
}
