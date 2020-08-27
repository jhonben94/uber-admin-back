package py.com.uber.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.uber.admin.entities.Roles;


public interface RolesDAO  extends JpaRepository<Roles, Integer>{

}
