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

import py.com.uber.admin.dao.TitularesDAO;
import py.com.uber.admin.entities.Titulares;
import py.com.uber.admin.model.params.PaginadoParam;
import py.com.uber.admin.model.result.PaginadoResult;

@Service
public class TitularesService {
	
	@Autowired
	private TitularesDAO dao;
	

	@Transactional( readOnly= true)
	public PaginadoResult<Titulares> listar(PaginadoParam<Titulares> param) {

		ExampleMatcher matcher = ExampleMatcher.matching()
		    .withStringMatcher(StringMatcher.CONTAINING);
		
		Example<Titulares> example = Example.of(param.getFiltros(),matcher);
		
			Page<Titulares> lista = dao.findAll(example,
				PageRequest.of(
						param.getPagina(), 
						param.getCantidad(), 
						Sort.by(
								param.getOrderDir().equals("ASC")? Sort.Direction.ASC:Sort.Direction.DESC,
								param.getOrderBy())
						));
				PaginadoResult<Titulares> result = new PaginadoResult<>(lista);
				return result;
	}
	
	@Transactional
	public Titulares guardar(Titulares param){
		return dao.save(param);
	}
	@Transactional
	public Titulares modificar(Titulares param, Integer id){
		Titulares cpDB =dao.getOne(id);
		return dao.save(cpDB);
	}
	@Transactional( readOnly= true)
	
	public Titulares obtener( Integer id){
		return dao.findById(id).orElse(null);
	}
	
	@Transactional
	public void eliminar(Integer id){
		dao.deleteById(id);
	}
	
	@Transactional( readOnly= true)
	public List<Titulares> listar(){
		return dao.findAll();
	}

}
