package py.com.uber.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.uber.admin.entities.TipoDocumentos;


public interface TipoDocumentosDAO  extends JpaRepository<TipoDocumentos, Integer>{

}
