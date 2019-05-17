package com.fandemo.controller;

import com.fandemo.MyUtil;
import com.fandemo.pojo.po.*;
import com.fandemo.pojo.vo.TitleVo;
import com.fandemo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/home")
public class FrontController {
    @Autowired
    BannerService bannerService;
    @Autowired
    AccountService accountService;
    @Autowired
    CommentService commentService;
    @Autowired
    WorksService worksService;
    @Autowired
    TitleService titleService;
    private int code;
    //首页banner接口
    @RequestMapping(value = "/banner",method = RequestMethod.GET)
    public String getBanner(ModelMap modelMap){
        //select from banner where status = 1;
        List<Banner> banners=bannerService.doGetUploda();
        code=banners.size()>0?0:-101;
        modelMap.addAttribute("banners",banners);
        modelMap.addAttribute("code",code);
        return "banner";
    }

    //首页标题
    @RequestMapping(value = "/index/title",method = RequestMethod.GET)
    public String getIndexTtiles(ModelMap modelMap){
        int code;
        List<TitleVo> setTitles=titleService.doGetUploadSetList();
        if (setTitles.size()!=0) {
            for(TitleVo titleVo:setTitles){
                List<Title> themeTitles =titleService.doGetUploadThemeList(titleVo.getId());
                titleVo.setcTitles(themeTitles);
            }
            code=0;
        }else {
            code=-101;
            modelMap.addAttribute("code",code);
            return "result";
        }
        List<Account> accounts=accountService.doGetAll();
        Map<Integer,String> accountMap=MyUtil.getAccountMap(accounts);
        modelMap.addAttribute("setTitles",setTitles);
        modelMap.addAttribute("accountMap",accountMap);
        modelMap.addAttribute("code",code);
        return "homeIndex";
    }
    //作品集接口
    @RequestMapping(value = "theme/detail",method = RequestMethod.GET)
    public String getProduction(@RequestParam("title_id")int title_id,ModelMap modelMap,
                                       @RequestParam (value = "page",defaultValue = "1",required = false)int page,
                                       @RequestParam(value = "size",required = false,defaultValue = "10")int size){
        List<Works> worksList=worksService.doGetList(title_id,page,size);
        code=0;
        modelMap.addAttribute("works",worksList);
        modelMap.addAttribute("code",code);
        return "works";
    }


    //写留言接口
    @RequestMapping(value="/comment/{works_id}",method = RequestMethod.POST)
    public String writeComment(@PathVariable("works_id")int works_id,@RequestBody Comment comment, HttpServletRequest request, ModelMap modelMap){
        String vis_ip=request.getRemoteAddr();
        comment.setVisitor_ip(vis_ip);
        comment.setWorks_id(works_id);
        comment.setType(1);
        comment.setUpdate_at(System.currentTimeMillis());
        code=commentService.doCreate(comment)?0:-300;
        modelMap.addAttribute("code",code);
        return "result";
    }
    //获得作品相关留言接口
    @RequestMapping(value = "/comment/{works_id}",method =RequestMethod.GET )
    public String getComment(@PathVariable("works_id")int works_id,ModelMap modelMap){
        List<Comment> comments=commentService.showOnloadComment(works_id);
        List<Integer> ids=new ArrayList<Integer>();
        for(Comment comment:comments){
            ids.add(comment.getEditor_id());
        }if(ids.size()!=0) {
            List<Account> accounts = accountService.doGetIdList(ids);
            modelMap.addAttribute("accounts",accounts);
        }
        if(comments!=null){
            code=0;
            modelMap.addAttribute("comments",comments);
            modelMap.addAttribute("code",code);
            return "commentlist";
        }
        code=-101;
        modelMap.addAttribute("code",code);
        return "result";
    }
    //搜索栏
    @RequestMapping(value="/works/result",method = RequestMethod.GET)
    public String searchWorks(@RequestParam("words")String words,@RequestParam(value = "page",required = false,defaultValue = "1")int page,
                              @RequestParam(value = "size",required = false,defaultValue = "10")int size,ModelMap modelMap){
        List<Works> worksList=worksService.doSearch(words,page,size);
        if(worksList!=null){
            code=0;
            modelMap.addAttribute("workslist",worksList);
            modelMap.addAttribute("code",code);
            return "worksSearchResult";
        }
        code=-101;
        modelMap.addAttribute("code",code);
        return "result";
    }
}
