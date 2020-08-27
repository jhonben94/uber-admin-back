package py.com.uber.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.uber.admin.entities.Vehiculos;


public interface VehiculosDAO  extends JpaRepository<Vehiculos, Integer>{

}
