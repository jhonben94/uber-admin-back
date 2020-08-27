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

import py.com.uber.admin.dao.ConductoresDAO;
import py.com.uber.admin.entities.Conductores;
import py.com.uber.admin.model.params.PaginadoParam;
import py.com.uber.admin.model.result.PaginadoResult;

@Service
public class ConductoresService {
	
	@Autowired
	private ConductoresDAO dao;
	

	@Transactional( readOnly= true)
	public PaginadoResult<Conductores> listar(PaginadoParam<Conductores> param) {

		ExampleMatcher matcher = ExampleMatcher.matching()
		    .withStringMatcher(StringMatcher.CONTAINING);
		
		Example<Conductores> example = Example.of(param.getFiltros(),matcher);
			Page<Conductores> lista = dao.findAll(example,
				PageRequest.of(
						param.getPagina(), 
						param.getCantidad(), 
						Sort.by(
								param.getOrderDir().equals("ASC")? Sort.Direction.ASC:Sort.Direction.DESC,
								param.getOrderBy())
						));
				PaginadoResult<Conductores> result = new PaginadoResult<>(lista);
				return result;
	}
	
	@Transactional
	public Conductores guardar(Conductores param){
		return dao.save(param);
	}
	@Transactional
	public Conductores modificar(Conductores param, Integer id){
		Conductores cpDB =dao.getOne(id);
		return dao.save(cpDB);
	}
	@Transactional( readOnly= true)
	
	public Conductores obtener( Integer id){
		return dao.findById(id).orElse(null);
	}
	
	@Transactional
	public void eliminar(Integer id){
		dao.deleteById(id);
	}
	
	@Transactional( readOnly= true)
	public List<Conductores> listar(){
		return dao.findAll();
	}

}
