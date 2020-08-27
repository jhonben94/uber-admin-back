package py.com.uber.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import py.com.uber.admin.entities.Conductores;


public interface DefinicionesDAO  extends JpaRepository<Conductores, Integer>, QueryByExampleExecutor<Conductores>{

}
