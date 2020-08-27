package py.com.uber.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.uber.admin.entities.Viajes;


public interface ViajesDAO  extends JpaRepository<Viajes, Integer>{

}
