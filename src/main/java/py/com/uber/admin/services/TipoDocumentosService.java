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
import py.com.uber.admin.dao.TipoDocumentosDAO;
import py.com.uber.admin.entities.TipoDocumentos;
import py.com.uber.admin.model.params.PaginadoParam;
import py.com.uber.admin.model.result.PaginadoResult;

@Service
public class TipoDocumentosService {
	
	@Autowired
	private TipoDocumentosDAO dao;
	

	@Transactional( readOnly= true)
	public PaginadoResult<TipoDocumentos> listar(PaginadoParam<TipoDocumentos> param) {

		ExampleMatcher matcher = ExampleMatcher.matching()
		    .withStringMatcher(StringMatcher.CONTAINING);
		
		Example<TipoDocumentos> example = Example.of(param.getFiltros(),matcher);
		
			Page<TipoDocumentos> lista = dao.findAll(example,
				PageRequest.of(
						param.getPagina(), 
						param.getCantidad(), 
						Sort.by(
								param.getOrderDir().equals("ASC")? Sort.Direction.ASC:Sort.Direction.DESC,
								param.getOrderBy())
						));
				PaginadoResult<TipoDocumentos> result = new PaginadoResult<>(lista);
				return result;
	}
	
	@Transactional
	public TipoDocumentos guardar(TipoDocumentos param){
		return dao.save(param);
	}
	@Transactional
	public TipoDocumentos modificar(TipoDocumentos param, Integer id){
		TipoDocumentos entidad =dao.getOne(id);
		entidad.setNombre(param.getNombre());
		return dao.save(entidad);
	}
	@Transactional( readOnly= true)
	
	public TipoDocumentos obtener( Integer id){
		return dao.findById(id).orElse(null);
	}
	
	@Transactional
	public void eliminar(Integer id){
		dao.deleteById(id);
	}
	
	@Transactional( readOnly= true)
	public List<TipoDocumentos> listar(){
		return dao.findAll();
	}
	
	@Transactional
	public TipoDocumentos desactivar( Integer id){
		TipoDocumentos entidad =dao.getOne(id);
		entidad.setActivo("N");
		return dao.save(entidad);
	}
	
	@Transactional
	public TipoDocumentos activar( Integer id){
		TipoDocumentos entidad =dao.getOne(id);
		entidad.setActivo("S");
		return dao.save(entidad);
	}
	

}
