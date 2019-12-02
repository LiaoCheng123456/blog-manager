package com.service.blog.service.article;

import com.alibaba.fastjson.JSON;
import com.service.blog.constbag.Const;
import com.service.blog.constbag.RepsitoryPool.DaoRepositoryNamePool;
import com.service.blog.constbag.RepsitoryPool.ServiceRepositoryNamePool;
import com.service.blog.dao.article.IArticleDao;
import com.service.blog.dao.user.IUserDao;
import com.service.blog.model.Article;
import com.service.blog.model.ResultUtils;
import com.service.blog.model.User;
import com.service.blog.paramenum.NumberEnum;
import com.service.blog.paramenum.ResultCodeEnum;
import com.service.blog.paramenum.WhetherConstEnum;
import com.service.blog.service.CommonHelperService;
import com.service.blog.utils.DateUtils;
import com.service.blog.utils.IDUtils;
import com.service.blog.utils.LoggerUtils;
import com.service.blog.utils.ParameterUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = ServiceRepositoryNamePool.SERVICE_ARTICLE)
public class ArticleService {

    @Resource(name = DaoRepositoryNamePool.DAO_IMPL_ARTICLE)
    private IArticleDao articleDao;

    @Resource(name = ServiceRepositoryNamePool.SERVICE_COMMON_HELPER)
    private CommonHelperService commonHelperService;

    /**
     * this provide is add function by article
     *
     * @param requestParam must add of article
     * @return handle result
     */
    public String addArticleFunction(String requestParam) {
        ResultUtils resultUtils = new ResultUtils();
        try {
            Article article = JSON.parseObject(requestParam, Article.class);

            // check multi between parameter whether have one null parameter
            String checkParamResult = ParameterUtils.checkParam(article, Const.MUST_PARAM_TITLE, Const.MUST_PARAM_CONTENT, Const.MUST_PARAM_AUTHOR);
            if (checkParamResult != null) {
                return checkParamResult;
            }

            // check user is exists
            User user = new User();
            user.setId(article.getAuthor());
            if (commonHelperService.checkUserExists(resultUtils, user)) return JSON.toJSONString(resultUtils);

            generatorArticleParameter(article);

            articleDao.addArticle(article);
        } catch (Exception e) {
            return LoggerUtils.error(requestParam, e);
        }
        return JSON.toJSONString(resultUtils);
    }

    /**
     * generator article must parameter
     *
     * @param article
     *          must parameter
     */
    private void generatorArticleParameter(Article article) {
        // id
        article.setId(IDUtils.getId());

        // add time
        article.setAddTime(DateUtils.NOW_TIME);

        // update time
        article.setUpdateTime(DateUtils.NOW_TIME);

        // read number
        article.setReadNumber(NumberEnum.ZERO_.VALUE);

        // praise number
        article.setPraiseNumber(NumberEnum.ZERO_.VALUE);

        // browse number
        article.setBrowseNumber(NumberEnum.ZERO_.VALUE);

        // whether delete
        article.setIsDelete(WhetherConstEnum.DELETE.NO);
    }

    /**
     * this provide is get list function by article
     *
     * @param requestParam article context
     * @return article list
     */
    public String getArticleListFunction(String requestParam) {
        ResultUtils resultUtils = new ResultUtils();
        Article article = JSON.parseObject(requestParam, Article.class);
        try {
            resultUtils.setData(articleDao.getArticleList(article));
        } catch (Exception e) {
            return LoggerUtils.error(requestParam, e);
        }
        return JSON.toJSONString(resultUtils);
    }

    public String getArticleFunction(String requestParam) {
        ResultUtils resultUtils = new ResultUtils();
        Article article = JSON.parseObject(requestParam, Article.class);
        try {
            resultUtils.setData(articleDao.getArticle(article));
        } catch (Exception e) {
            return LoggerUtils.error(requestParam, e);
        }
        return JSON.toJSONString(resultUtils);
    }
}
