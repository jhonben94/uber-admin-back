package py.com.uber.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.uber.admin.entities.Permisos;


public interface PermisoDAO  extends JpaRepository<Permisos, Integer>{

}
