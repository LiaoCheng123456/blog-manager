package com.service.blog.controller.article;

import com.alibaba.fastjson.JSON;
import com.service.blog.constbag.RepsitoryPool.ControllerRepositoryNamePool;
import com.service.blog.constbag.RepsitoryPool.ServiceRepositoryNamePool;
import com.service.blog.controller.BaseController;
import com.service.blog.model.Article;
import com.service.blog.constbag.route.ArticleRoute;
import com.service.blog.service.article.ArticleService;

import com.service.blog.constbag.Const;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * It is article Controller. It is provide basic skip function add. delete. update. query by article
 *
 * @author Abner
 */
@RestController
@RequestMapping(value = ControllerRepositoryNamePool.CONTROLLER_ARTICLE)
public class ArticleController extends BaseController {

    @Resource(name = ServiceRepositoryNamePool.SERVICE_ARTICLE)
    private ArticleService articleService;

    /**
     * the provide add skip route function by article
     *
     * @param request      httpServletRequest context
     * @param requestParam must add of article
     * @return response result
     */
    @PostMapping(value = ArticleRoute.ADD_ARTICLE, headers = Const.HEADERS, produces = Const.PRODUCES_JSON)
    public String addArticleFunction(HttpServletRequest request, @RequestBody String requestParam) {
        Article article = JSON.parseObject(requestParam, Article.class);
        return articleService.addArticleFunction(JSON.toJSONString(article));
    }

    /**
     * provide get article list function of route
     *
     * @param request httpServletRequest context
     * @param title article title
     * @return
     */
    @GetMapping(value = ArticleRoute.GET_ARTICLE_LIST, headers = Const.HEADERS, produces = Const.PRODUCES_JSON)
    public String getArticleListFunction(HttpServletRequest request, @RequestParam(value = Const.MUST_PARAM_TITLE, required = Const.FALSE) String title) {
        Article article = new Article();
        article.setTitle(title);
        return articleService.getArticleListFunction(JSON.toJSONString(article));
    }
}
