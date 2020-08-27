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

import py.com.uber.admin.dao.ViajesDAO;
import py.com.uber.admin.entities.Viajes;
import py.com.uber.admin.model.params.PaginadoParam;
import py.com.uber.admin.model.result.PaginadoResult;

@Service
public class ViajesService {
	
	@Autowired
	private ViajesDAO dao;
	

	@Transactional( readOnly= true)
	public PaginadoResult<Viajes> listar(PaginadoParam<Viajes> param) {

		ExampleMatcher matcher = ExampleMatcher.matching()
		    .withStringMatcher(StringMatcher.CONTAINING);
		
		Example<Viajes> example = Example.of(param.getFiltros(),matcher);
		
			Page<Viajes> lista = dao.findAll(example,
				PageRequest.of(
						param.getPagina(), 
						param.getCantidad(), 
						Sort.by(
								param.getOrderDir().equals("ASC")? Sort.Direction.ASC:Sort.Direction.DESC,
								param.getOrderBy())
						));
				PaginadoResult<Viajes> result = new PaginadoResult<>(lista);
				return result;
	}
	
	@Transactional
	public Viajes guardar(Viajes param){
		return dao.save(param);
	}
	@Transactional
	public Viajes modificar(Viajes param, Integer id){
		Viajes cpDB =dao.getOne(id);
		return dao.save(cpDB);
	}
	@Transactional( readOnly= true)
	
	public Viajes obtener( Integer id){
		return dao.findById(id).orElse(null);
	}
	
	@Transactional
	public void eliminar(Integer id){
		dao.deleteById(id);
	}
	
	@Transactional( readOnly= true)
	public List<Viajes> listar(){
		return dao.findAll();
	}

}
