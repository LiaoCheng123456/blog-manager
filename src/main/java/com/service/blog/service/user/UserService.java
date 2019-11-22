package com.service.blog.service.user;

import com.alibaba.fastjson.JSON;
import com.service.blog.constbag.Const;
import com.service.blog.constbag.RepsitoryPool.DaoRepositoryNamePool;
import com.service.blog.constbag.RepsitoryPool.ServiceRepositoryNamePool;
import com.service.blog.dao.user.IUserDao;
import com.service.blog.model.ResultUtils;
import com.service.blog.model.User;
import com.service.blog.paramenum.ResultCodeEnum;
import com.service.blog.service.CommonHelperService;
import com.service.blog.utils.LoggerUtils;
import com.service.blog.utils.ParameterUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = ServiceRepositoryNamePool.SERVICE_USER)
public class UserService {

    @Resource(name = DaoRepositoryNamePool.DAO_IMPL_USER)
    private IUserDao userDao;

    @Resource(name = ServiceRepositoryNamePool.SERVICE_COMMON_HELPER)
    private CommonHelperService commonHelperService;

    /**
     * this is handle user login of function
     *
     * @param requestParam username and password
     * @return login result
     */
    public String userLogin(String requestParam) {
        ResultUtils resultUtils = new ResultUtils();
        User user = JSON.parseObject(requestParam, User.class);
        String checkParam = ParameterUtils.checkParam(user, Const.MUST_PARAM_USERNAME, Const.MUST_PARAM_PASSWORD);
        if (checkParam != null) {
            return checkParam;
        }

        // query user info by username. check user is exists
        try {
            User userInfo = new User();
            userInfo.setUsername(user.getUsername());
            if (commonHelperService.checkUserExists(resultUtils, userInfo)) return JSON.toJSONString(resultUtils);

            User resultUserInfo = userDao.getUser(userInfo);
            String password = ParameterUtils.md5(user.getPassword());

            // check password is equal
            if (resultUserInfo.getPassword().toUpperCase().equals(password)) {
                return JSON.toJSONString(resultUtils);
            }
        } catch (Exception e) {
            return LoggerUtils.error(requestParam, e);
        }
        return JSON.toJSONString(resultUtils);
    }
}
