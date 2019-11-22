package com.service.blog.dao.user;

import com.service.blog.constbag.RepsitoryPool.DaoRepositoryNamePool;
import com.service.blog.constbag.RepsitoryPool.MapperRepositoryNamePool;
import com.service.blog.dao.BaseDao;
import com.service.blog.model.User;
import org.springframework.stereotype.Repository;

@Repository(value = DaoRepositoryNamePool.DAO_IMPL_USER)
public class UserDaoImpl extends BaseDao implements IUserDao{

    @Override
    public User userLogin(User user) {
        return sqlSessionTemplate.selectOne(MapperRepositoryNamePool.MAPPER_USER + Thread.currentThread().getStackTrace()[1].getMethodName(), user);
    }

    @Override
    public User getUser(User user) {
        return sqlSessionTemplate.selectOne(MapperRepositoryNamePool.MAPPER_USER + Thread.currentThread().getStackTrace()[1].getMethodName(), user);
    }
}
