package edu.usc.cgsa.web.service;

import edu.usc.cgsa.web.model.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Ronan
 * @email crnoogle@gmail.com
 * @date 5/16/20
 * @website
 */
public interface DepartmentService {
  /**
   * Can be used to save new entity or update existent one
   *
   * @param department target department entity
   * @return saved or updated entity
   */
  Long save(Department department) throws SQLException;

  Long deleteById(Long id) throws SQLException;

  Department findById(Long id) throws SQLException;

  List<Department> findAll() throws SQLException;
}
