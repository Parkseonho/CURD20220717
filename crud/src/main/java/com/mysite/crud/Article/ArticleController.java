package com.mysite.crud.Article;

import com.mysite.crud.Ut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

//------------------------------------------------------------

    @RequestMapping("/doWrite")
    @ResponseBody
    public String doWrite(String title, String body){
        if(Ut.empty(title)){
            return "제목을 입력하시오.";
        }
        if(Ut.empty(body)){
            return "내용을 입력하시오.";
        }
        Article article = new Article();
        article.setRegDate(LocalDateTime.now());
        article.setUpdateDate(LocalDateTime.now());
        article.setTitle(title);
        article.setBody(body);
        article.setUserId(1L);

        articleRepository.save(article);
        return "%d번 게시물 생성이 완료되었습니다.".formatted(article.getId());

    }

//------------------------------------------------------------

    @RequestMapping("/list")
    @ResponseBody
    public List<Article> showList(){
        return articleRepository.findAll();
    }

    @RequestMapping("/detail")
    @ResponseBody
    public Article showDetail(Long id){
        Article article = articleRepository.findById(id).get();
        return article;
    }

//------------------------------------------------------------
    @RequestMapping("/doModify")
    @ResponseBody
    public String doModify(Long id, String title, String body){
        if(id == null){
            return "게시물번호를 입력해주세요";
        }
        if(Ut.empty(title)){
            return "제목을 입력해주세요.";
        }
        if(Ut.empty(body)){
            return "내용을 입력해주세요.";
        }
        if(!articleRepository.existsById(id)){
            return "게시물이 없습니다.";
        }

        Article article = articleRepository.findById(id).get();

        article.setTitle(title);
        article.setBody(body);
        article.setUpdateDate(LocalDateTime.now());

        articleRepository.save(article);

        return "%d번 게시물 수정이 완료되었습니다.".formatted(article.getId());
    }

//------------------------------------------------------------

    @RequestMapping("/doDelete")
    @ResponseBody
    public String doDelete(Long id){
        if(!articleRepository.existsById(id)){
            return "%d번 게시물은 없습니다.".formatted(id);
        }
        Article article = articleRepository.findById(id).get();
        articleRepository.delete(article);

        return "%번 게시물을 삭제했습니다.".formatted(id);
    }
}
