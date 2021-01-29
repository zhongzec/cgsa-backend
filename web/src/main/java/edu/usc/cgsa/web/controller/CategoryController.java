package edu.usc.cgsa.web.controller;

import edu.usc.cgsa.web.model.Category;
import edu.usc.cgsa.web.model.Post;
import edu.usc.cgsa.web.service.CategoryService;
import edu.usc.cgsa.web.service.PostService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ronan
 * @email crnoogle@gmail.com
 * @date 5/16/20
 * @website
 */
@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

  private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);

  @Autowired
  private CategoryService catService;

  @ApiOperation("Save a Category")
  @PostMapping(value = "/save")
  public ResponseEntity<String> save(@RequestBody Category cat) {
    try {
      catService.insert(cat);
      return ResponseEntity.ok("Success to save the category: " + cat.toString());
    } catch (SQLException e) {
      LOG.error(e.getMessage());
      return new ResponseEntity<>("Fail to save the category: " + cat.toString(), HttpStatus.FORBIDDEN);
    }
  }

  @ApiOperation("Delete a Category")
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    try {
      catService.deleteById(id);
      return ResponseEntity.ok("Success to delete the category");
    } catch (SQLException e) {
      LOG.error(e.getMessage());
      return new ResponseEntity<>("Fail to delete the category with id: " + id, HttpStatus.FORBIDDEN);
    }
  }

  @ApiOperation("Get All Categories")
  @GetMapping("/all")
  public List<Category> getAll() {
    List<Category> list = null;
    try {
      list = catService.findAll();
    } catch (SQLException e) {
      LOG.error(e.getMessage());
    }
    return list;
  }

  @ApiOperation("Get a Category By Id")
  @GetMapping("/{id}")
  public Category getById(@PathVariable Long id) {
    Category cat = null;
    try {
      cat = catService.findById(id);
    } catch (SQLException e) {
      LOG.error(e.getMessage());
    }
    return cat;
  }

}
