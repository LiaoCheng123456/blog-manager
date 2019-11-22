package com.service.blog.dao;


import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;

public class BaseDao {

    @Resource(name = "sqlSessionTemplate")
    protected SqlSessionTemplate sqlSessionTemplate;
}
