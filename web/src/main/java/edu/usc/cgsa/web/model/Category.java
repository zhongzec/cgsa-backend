package edu.usc.cgsa.web.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ronan
 * @email crnoogle@gmail.com
 * @date 8/25/20
 * @website
 */
@Data
@NoArgsConstructor
public class Category {
  private Long categoryId;
  private String name;
  private String type;
}
