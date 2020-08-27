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

import py.com.uber.admin.dao.ModelosDAO;
import py.com.uber.admin.entities.Modelos;
import py.com.uber.admin.model.params.PaginadoParam;
import py.com.uber.admin.model.result.PaginadoResult;

@Service
public class ModelosService {
	
	@Autowired
	private ModelosDAO dao;
	

	@Transactional( readOnly= true)
	public PaginadoResult<Modelos> listar(PaginadoParam<Modelos> param) {

		ExampleMatcher matcher = ExampleMatcher.matching()
		    .withStringMatcher(StringMatcher.CONTAINING);
		
		Example<Modelos> example = Example.of(param.getFiltros(),matcher);
		
			Page<Modelos> lista = dao.findAll(example,
				PageRequest.of(
						param.getPagina(), 
						param.getCantidad(), 
						Sort.by(
								param.getOrderDir().equals("ASC")? Sort.Direction.ASC:Sort.Direction.DESC,
								param.getOrderBy())
						));
				PaginadoResult<Modelos> result = new PaginadoResult<>(lista);
				return result;
	}
	
	@Transactional
	public Modelos guardar(Modelos param){
		return dao.save(param);
	}
	@Transactional
	public Modelos modificar(Modelos param, Integer id){
		Modelos entidad =dao.getOne(id);
		entidad.setDescripcion(param.getDescripcion());
		entidad.setIdMarca(param.getIdMarca());
		return dao.save(entidad);
	}
	@Transactional( readOnly= true)
	
	public Modelos obtener( Integer id){
		return dao.findById(id).orElse(null);
	}
	
	@Transactional
	public void eliminar(Integer id){
		dao.deleteById(id);
	}
	
	@Transactional( readOnly= true)
	public List<Modelos> listar(){
		return dao.findAll();
	}
	
	@Transactional
	public Modelos desactivar( Integer id){
		Modelos entidad =dao.getOne(id);
		entidad.setActivo("N");
		return dao.save(entidad);
	}
	
	@Transactional
	public Modelos activar( Integer id){
		Modelos entidad =dao.getOne(id);
		entidad.setActivo("S");
		return dao.save(entidad);
	}

}
