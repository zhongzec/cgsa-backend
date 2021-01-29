package edu.usc.cgsa.web.config;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ronan
 * @email crnoogle@gmail.com
 * @date 6/1/20
 * @website
 */
@Configuration
@MapperScan("edu.usc.cgsa.web.dao")
public class MyBatisConfig {
}
