package edu.usc.cgsa.web.service.impl;

import edu.usc.cgsa.web.dao.DepartmentMapper;
import edu.usc.cgsa.web.model.Department;
import edu.usc.cgsa.web.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Ronan
 * @email crnoogle@gmail.com
 * @date 5/16/20
 * @website
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

  private final DepartmentMapper deptRepo;

  public DepartmentServiceImpl(DepartmentMapper deptRepo) {
    this.deptRepo = deptRepo;
    deptRepo.createTable();
  }

  @Override
  public Long save(Department department) {
    return deptRepo.insert(department);
  }

  @Override
  public Long deleteById(Long id) {
    return deptRepo.deleteById(id);
  }

  @Override
  public Department findById(Long id) {
    return deptRepo.findById(id);
  }

  @Override
  public List<Department> findAll() {
    return deptRepo.findAll();
  }
}
