package edu.usc.cgsa.web.controller;

import edu.usc.cgsa.web.model.BoardMember;
import edu.usc.cgsa.web.service.BoardMemberService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Ronan
 * @email crnoogle@gmail.com
 * @date 5/16/20
 * @website
 */
@RestController
@RequestMapping("/bm")
@CrossOrigin
public class BoardMemberController {

  private static final Logger LOG = LoggerFactory.getLogger(BoardMemberController.class);

  @Autowired
  private BoardMemberService bmService;

  @ApiOperation("Save a Board Member")
  @PostMapping(value = "/save")
  public ResponseEntity<String> save(@RequestBody BoardMember bm) {
    try {
      bmService.insert(bm);
      return ResponseEntity.ok("Success to save the board member: " + bm.toString());
    } catch (SQLException e) {
      LOG.error(e.getMessage());
      return new ResponseEntity<>("Fail to save the board member: " + bm.toString(), HttpStatus.FORBIDDEN);
    }
  }

  @ApiOperation("Delete a Board Member")
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    try {
      bmService.deleteById(id);
      return ResponseEntity.ok("Success to delete the board member");
    } catch (SQLException e) {
      LOG.error(e.getMessage());
      return new ResponseEntity<>("Fail to delete the board member with id: " + id, HttpStatus.FORBIDDEN);
    }
  }

  @ApiOperation("Get All Board Members")
  @GetMapping("/all")
  public List<BoardMember> getAll() {
    List<BoardMember> list = null;
    try {
      list = bmService.findAll();
    } catch (SQLException e) {
      LOG.error(e.getMessage());
    }
    return list;
  }

  @ApiOperation("Get a Board Member By Id")
  @GetMapping("/{id}")
  public BoardMember getById(@PathVariable Long id) {
    BoardMember bm = null;
    try {
      bm = bmService.findById(id);
    } catch (SQLException e) {
      LOG.error(e.getMessage());
    }
    return bm;
  }

}
