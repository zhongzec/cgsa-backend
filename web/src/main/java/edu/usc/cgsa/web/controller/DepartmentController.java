package edu.usc.cgsa.web.controller;

import edu.usc.cgsa.web.model.Department;
import edu.usc.cgsa.web.service.DepartmentService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Ronan
 * @email crnoogle@gmail.com
 * @date 2/14/20
 * @website
 */
@RestController
@RequestMapping("/dept")
@CrossOrigin
public class DepartmentController {

  private final static Logger LOG = LoggerFactory.getLogger(DepartmentController.class);

  private final DepartmentService deptService;

  public DepartmentController(DepartmentService deptService) {
    this.deptService = deptService;
  }

  @ApiOperation("Save a Department")
  @PostMapping("/save")
  public ResponseEntity<String> save(@RequestBody Department department) {
    try {
      deptService.save(department);
      return ResponseEntity.ok("Success to save the department: " + department.toString());
    } catch (SQLException e) {
      LOG.error(e.getMessage());
      return new ResponseEntity<>("Fail to save the department: " + department.toString(), HttpStatus.FORBIDDEN);
    }
  }

  @ApiOperation("Delete a Department")
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    try {
      deptService.deleteById(id);
      return ResponseEntity.ok("Success to delete the department");
    } catch (SQLException e) {
      LOG.error(e.getMessage());
      return new ResponseEntity<>("Fail to delete the department with id: " + id, HttpStatus.FORBIDDEN);
    }
  }

  @ApiOperation("Get All Departments")
  @GetMapping("/all")
  public List<Department> getAll() {
    List<Department> list = null;
    try {
      list = deptService.findAll();
    } catch (SQLException e) {
      LOG.error(e.getMessage());
    }
    return list;
  }

  @ApiOperation("Get a Department By Id")
  @GetMapping("/{id}")
  public Department getById(@PathVariable Long id) {
    Department dept = null;
    try {
      dept = deptService.findById(id);
    } catch (SQLException e) {
      LOG.error(e.getMessage());
    }
    return dept;
  }

}
