package edu.usc.cgsa.web.service;

import edu.usc.cgsa.web.model.BoardMember;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Ronan
 * @email crnoogle@gmail.com
 * @date 5/16/20
 * @website
 */
public interface BoardMemberService {
  /**
   * Can be used to save new entity or update existent one
   *
   * @param boardMember target board member entity
   * @return saved or updated entity
   */
  Long insert(BoardMember boardMember) throws SQLException;

  Long deleteById(Long id) throws SQLException;

  BoardMember findById(Long id) throws SQLException;

  List<BoardMember> findAll() throws SQLException;
}
