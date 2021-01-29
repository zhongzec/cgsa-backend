package edu.usc.cgsa.web.dao;

import edu.usc.cgsa.web.model.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ronan
 * @email crnoogle@gmail.com
 * @date 5/16/20
 * @website
 */
@Mapper
@Repository
public interface DepartmentMapper {

  Long createTable();

  Long insert(Department bm);

  Long deleteById(Long id);

  Department findById(Long id);

  List<Department> findAll();
}
