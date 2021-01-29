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
public class Post {
  private Long postId;
  private String postName;
  private String postUrl;
  private Long categoryId;
  private String imageUrl;
  private String description;
}
