package com.service.blog.service;

import com.service.blog.constbag.RepsitoryPool.DaoRepositoryNamePool;
import com.service.blog.constbag.RepsitoryPool.ServiceRepositoryNamePool;
import com.service.blog.dao.user.IUserDao;
import com.service.blog.model.ResultUtils;
import com.service.blog.model.User;
import com.service.blog.paramenum.ResultCodeEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = ServiceRepositoryNamePool.SERVICE_COMMON_HELPER)
public class CommonHelperService {

    @Resource(name = DaoRepositoryNamePool.DAO_IMPL_USER)
    private IUserDao userDao;

    public boolean checkUserExists(ResultUtils resultUtils, User user) {
        User resultUserInfo = userDao.getUser(user);
        if (resultUserInfo == null) {
            resultUtils.setCode(ResultCodeEnum.AUTH_ERROR.getValue());
            resultUtils.setMsg(ResultCodeEnum.AUTH_ERROR.getDesc());
            return true;
        }
        return false;
    }
}
