package edu.usc.cgsa.web.controller;

import edu.usc.cgsa.web.model.Category;
import edu.usc.cgsa.web.model.Item;
import edu.usc.cgsa.web.model.Post;
import edu.usc.cgsa.web.model.ReturnItem;
import edu.usc.cgsa.web.service.CategoryService;
import edu.usc.cgsa.web.service.PostService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
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
@RequestMapping("/post")
@CrossOrigin
public class PostController {

  private static final Logger LOG = LoggerFactory.getLogger(PostController.class);

  @Autowired
  private PostService postService;

  @Autowired
  private CategoryService categoryService;

  @ApiOperation("Save a Post")
  @PostMapping(value = "/save")
  public ResponseEntity<String> save(@RequestBody Post post) {
    try {
      postService.insert(post);
      return ResponseEntity.ok("Success to save the post: " + post.toString());
    } catch (SQLException e) {
      LOG.error(e.getMessage());
      return new ResponseEntity<>("Fail to save the post: " + post.toString(), HttpStatus.FORBIDDEN);
    }
  }

  @ApiOperation("Delete a Post")
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    try {
      postService.deleteById(id);
      return ResponseEntity.ok("Success to delete the post");
    } catch (SQLException e) {
      LOG.error(e.getMessage());
      return new ResponseEntity<>("Fail to delete the post with id: " + id, HttpStatus.FORBIDDEN);
    }
  }

  @ApiOperation("Get All Categories By Type")
  @GetMapping("/category/{type}/all")
  public Object getAllCategories(@PathVariable String type) {

    List<ReturnItem> returnedItems = new ArrayList<>();
    try {
      for (Category category : categoryService.findAllByType(type)) {
        ReturnItem tempItem = new ReturnItem();
        tempItem.setHeader(category.getName());
        List<Item> tempList = new ArrayList<>();
        tempItem.setItems(tempList);
        for (Post post : postService.findByCategoryId(category.getCategoryId())) {
          Item item = new Item();
          item.setText(post.getPostName());
          item.setUrl(post.getPostUrl());
          tempList.add(item);
        }
        returnedItems.add(tempItem);
      }
    } catch (SQLException e) {
      LOG.error(e.getMessage());
    }
    return returnedItems;
  }

  @ApiOperation("Get All Posts")
  @GetMapping("/all")
  public List<Post> getAll() {
    List<Post> list = null;
    try {
      list = postService.findAll();
    } catch (SQLException e) {
      LOG.error(e.getMessage());
    }
    return list;
  }

  @ApiOperation("GetWechatPageById")
  @GetMapping("/wechat/{id}")
  public ResponseEntity<Object> getWechatPageById(@PathVariable String id) throws IOException {
    URL url = new URL("https://mp.weixin.qq.com/s/" + id);
    StringBuilder sb = new StringBuilder();
    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
    String line;
    while ((line = reader.readLine()) != null) {
      sb.append(line);
    }
    String res = sb.toString();
    res = res.replaceAll("data-src", "src");
    res = res.replaceAll("wx_fmt=jpeg", "wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1");
    res = res.replaceAll("wx_fmt=png", "wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1");
    res = res.replaceAll("wx_fmt=gif", "wx_fmt=gif&tp=webp&wxfrom=5&wx_lazy=1");
    HttpHeaders headers = new HttpHeaders();
    headers.add(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE);
    return new ResponseEntity<>(res, headers, HttpStatus.OK);
  }

  @ApiOperation("Get a Post By Id")
  @GetMapping("/{id}")
  public Post getById(@PathVariable Long id) {
    Post post = null;
    try {
      post = postService.findById(id);
    } catch (SQLException e) {
      LOG.error(e.getMessage());
    }
    return post;
  }

  @ApiOperation("Get all Posts from one Category")
  @GetMapping("/cat{id}")
  public List<Post> getPostsInCategoryById(@PathVariable Long id) {
    List<Post> posts = null;
    try {
      posts = postService.findByCategoryId(id);
    } catch (SQLException e) {
      LOG.error(e.getMessage());
    }
    return posts;
  }

}
