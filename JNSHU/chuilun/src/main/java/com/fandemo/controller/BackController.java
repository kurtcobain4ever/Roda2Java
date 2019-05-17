package com.fandemo.controller;

import com.fandemo.pojo.po.Account;
import com.fandemo.pojo.po.Banner;
import com.fandemo.pojo.po.Title;
import com.fandemo.pojo.po.Works;
import com.fandemo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/a")
public class BackController {
    @Autowired
    BannerService bannerService;
    @Autowired
    AccountService accountService;
    @Autowired
    TitleService titleService;
    @Autowired
    WorksService worksService;
    int code;
    //公共接口：图片上传
    @RequestMapping(value = "/image",method = RequestMethod.POST)
    public String uploadImage(MultipartFile img,ModelMap modelMap)throws Exception{
        //文件展示路径
        String projectServerPath = "/image/";
        //上传文件绝对路径
        String path = "/usr/local/img/";
        //文件名
        String fileName=img.getOriginalFilename();
        File dir=new File(path);
        if(!dir.exists()){
            dir.mkdir();
        }
        img.transferTo(new File(path + File.separator + fileName));
        String loc = projectServerPath + fileName;
        code=0;
        modelMap.addAttribute("code",code);
        modelMap.addAttribute("loc",loc);
        return "imageresult";
    }

    //登录接口
    @RequestMapping(value = "/login",method =RequestMethod.POST)
    public String loogin(@RequestBody Account accountx, ModelMap modelMap,HttpSession session){
        Account account=accountService.doLogin(accountx);
        if(account!=null){
            code=0;
            modelMap.addAttribute("account",account);
            modelMap.addAttribute("code",code);
            session.setAttribute("account",account);
            return "login";
        }
        code=-301;
        modelMap.addAttribute("code",code);
        return "result";
    }

    @RequestMapping(value = "/nologin",method = RequestMethod.GET)
    public String nologin(ModelMap modelMap){
        code=-302;
        modelMap.addAttribute("code",code);
        return "result";
    }


    @RequestMapping(value = "/u/logout",method =RequestMethod.GET)
    public String loogout(ModelMap modelMap,HttpSession session){
        session.removeAttribute("account");
        session.invalidate();
        code=0;
        modelMap.addAttribute("code",code);
        return "result";
    }
   //获取所有banner
    @RequestMapping(value = "/u/banner",method = RequestMethod.GET)
    public String getBannerlist(ModelMap modelMap){
        List<Banner> banners=bannerService.doGetAll();
        code=0;
        modelMap.addAttribute("code",code);
        modelMap.addAttribute("banners",banners);
        return "banner";
    }
    //增加banner
    @RequestMapping("/add")
    public String addBannerTest(){
        return "uploadImage";

    }

    //新增banner
    @RequestMapping(value = "/u/banner",method = RequestMethod.POST)
    public String addBannerPic(@RequestBody Banner bannerx,HttpServletRequest request,
                               ModelMap model)throws Exception{
        Banner banner=new Banner();
        banner.setName(bannerx.getName());
        banner.setUrl(bannerx.getUrl());
        banner.setLoc(bannerx.getLoc());
        banner.setInd(0);
        banner.setStatus(0);
        Account account=(Account)request.getSession().getAttribute("Account");
        banner.setEditor_id(account.getId());
        banner.setCreate_at(System.currentTimeMillis());
        bannerService.doCreate(banner);
        code =0;
        model.addAttribute("code",code);
        return "result";
    }

    //修改banner
    @RequestMapping(value = "/u/banner/{id}",method = RequestMethod.PUT)
    public String getBanner(@PathVariable ("id")int id,@RequestBody Banner banner, ModelMap modelMap,HttpServletRequest request){
        //update set(name,url,loc,ind,status) from banner where id={id}
        code=bannerService.doUpdate(banner)?0:-200;
        Account account=(Account)request.getSession().getAttribute("account");
        banner.setEditor_id(account.getId());
        banner.setUpdate_at(System.currentTimeMillis());
        modelMap.addAttribute("code",code);
        return "result";
    }
    //删除banner
    @RequestMapping(value="/u/banner/{id}",method = RequestMethod.DELETE)
    public String deleteBanner(@PathVariable("id")int id, ModelMap modelMap){
        code=bannerService.doDelete(id)?0:-200;
        modelMap.addAttribute("code",code);
        return "result";
    }
    //上下架banner
    @RequestMapping(value = "/u/banner/status/{id}",method = RequestMethod.POST)
    public String loadBanner(@PathVariable("id")int id,@RequestBody int status,HttpServletRequest request, ModelMap modelMap){
        Account account=(Account)request.getSession().getAttribute("account");
        code=bannerService.doLoad(id,status,account.getId())?0:-300;
        modelMap.addAttribute("code",code);
        return "result";
    }
    //新增set
    @RequestMapping(value = "/u/set",method = RequestMethod.POST)
    public String createIndtitle(@RequestBody Title title,ModelMap modelMap,HttpServletRequest request){
        Account account=(Account)request.getSession().getAttribute("account");
        title.setEditor_id(account.getId());
        title.setParent_id(0);
        title.setLevel(1);
        title.setStatus(0);
        title.setCategory("0");
        title.setCreate_at(System.currentTimeMillis());
        code=titleService.doCreate(title)?0:-300;
        modelMap.addAttribute("code",code);
        return "result";
    }
    //刪除set
    @RequestMapping(value = "/u/set/{id}",method = RequestMethod.DELETE)
    public String deleteIndtitle(@PathVariable("id")int id,ModelMap modelMap){
        code=titleService.doDelete(id)?0:-301;
        modelMap.addAttribute("code",code);
        return "result";
    }
    //查詢set
    @RequestMapping(value = "/u/set",method = RequestMethod.GET)
    public String getIndtitle(ModelMap modelMap){
        List<Title> titles =titleService.doGetSetList();
        List<Integer> intlist=new ArrayList<Integer>();
        for(Title title:titles){
            intlist.add(title.getEditor_id());
        }
        List<Account> accounts = accountService.doGetIdList(intlist);
        code=0;
        modelMap.addAttribute("code",code);
        modelMap.addAttribute("accounts",accounts);
        modelMap.addAttribute("titles",titles);
        return "titleBySet";
    }
    //修改set
    @RequestMapping(value = "/u/set",method = RequestMethod.PUT)
    public String updateIndtitle(@RequestBody Title title,ModelMap modelMap){
        code=titleService.doUpdate(title)?0:-300;
        modelMap.addAttribute("code",code);
        return "result";
    }
    //上下架set
    @RequestMapping(value = "/u/set/status/{id}",method = RequestMethod.POST)
    public String onloadIndtitle(@PathVariable("id")int id,@RequestBody Integer status, ModelMap modelMap){
        code=titleService.doLoad(id,status)?0:-300;
        modelMap.addAttribute("code",code);
        return "result";
    }
    //查询二级标题（必须先拿到所属1级标题）
    @RequestMapping(value="/u/theme/list/{set_id}",method = RequestMethod.GET)
    public String getThemelist(@PathVariable("set_id")int set_id,ModelMap modelMap,HttpServletRequest request){
        List<Title> titles =titleService.doGetThemeList(set_id);
        List<Integer> intlist=new ArrayList<Integer>();
        for(Title title:titles){
            intlist.add(title.getEditor_id());
        }
        List<Account> accounts = accountService.doGetIdList(intlist);
        code=0;
        modelMap.addAttribute("code",code);
        modelMap.addAttribute("accounts",accounts);
        modelMap.addAttribute("titles",titles);
        return "titleBySet";
    }
    //增加二级标题
    @RequestMapping(value="/u/theme/{set_id}",method = RequestMethod.POST)
    public String addThemeList(@PathVariable("set_id")int set_id,@RequestBody Title title,ModelMap modelMap,HttpServletRequest request){
        Account account=(Account)request.getSession().getAttribute("account");
        title.setEditor_id(account.getId());
        title.setParent_id(set_id);
        title.setLevel(2);
        title.setStatus(0);
        title.setCategory("0."+set_id);
        title.setCreate_at(System.currentTimeMillis());
        code=titleService.doCreate(title)?0:-300;
        modelMap.addAttribute("code",code);
        return "result";
    }
    //更改二级标题
    @RequestMapping(value="/u/theme",method = RequestMethod.PUT)
    public String updateTheme(@RequestBody Title title,ModelMap modelMap,HttpServletRequest request){
        Account account=(Account)request.getSession().getAttribute("account");
        title.setEditor_id(account.getId());
        title.setUpdate_at(System.currentTimeMillis());
        code=titleService.doUpdate(title)?0:-500;
        modelMap.addAttribute("code",code);
        return "result";
    }
    //删除二级标题
    @RequestMapping(value="/u/theme/{id}",method = RequestMethod.DELETE)
    public String deleteTheme(@PathVariable("id")int id,ModelMap modelMap){
        code=titleService.doDelete(id)?0:-200;
        modelMap.addAttribute("code",code);
        return "result";
    }
    //上下架二级标题
    @RequestMapping(value="/u/theme/status",method = RequestMethod.PUT)
    public String lodaTheme(@RequestBody Title title, ModelMap modelMap){
        code=titleService.doLoad(title.getId(), title.getStatus())?0:-600;
        modelMap.addAttribute("code",code);
        return "result";
    }
    //修改密码
    @RequestMapping(value = "/u/user",method = RequestMethod.PUT)
    public String resetPassword(@RequestParam String oldPassword,@RequestParam String newPassword, ModelMap modelMap,HttpServletRequest request){
        Account account=(Account) request.getSession().getAttribute("account");
        if(account.getPassword().equals(oldPassword)){
            int id=account.getId();
            accountService.doSetPassword(newPassword,id);
            code=0;
            modelMap.addAttribute("code",code);
            return "result";
        }
        code=-501;
        modelMap.addAttribute("code",code);
        return "result";
    }
    //查询作品(必须先获取二级标题名字)
    @RequestMapping(value = "/u/works/list/{theme_id}",method = RequestMethod.GET)
    public String getWorksList(@PathVariable("theme_id")int title_id,@RequestParam(value = "size" )int size,@RequestParam("page")int page, ModelMap modelMap){
        List<Works> worksList=worksService.doGetList(title_id,page,size);
        if(worksList!=null){
            List<Integer> ids=new ArrayList<Integer>();
            for(Works works:worksList){
                ids.add(works.getEditor_id());
            }
            List<Account> accounts=accountService.doGetIdList(ids);
            code=0;
            modelMap.addAttribute("code",code);
            modelMap.addAttribute("worksList",worksList);
            modelMap.addAttribute("accounts",accounts);
            return "worksByTheme";
        }
        code=-200;
        modelMap.addAttribute("code",code);
        return "result";
    }
    //增加作品
    @RequestMapping(value = "/u/works",method = RequestMethod.POST)
    public String addWorks(@RequestBody Works works,HttpServletRequest request,ModelMap modelMap){
        Account account=(Account)request.getSession().getAttribute("account");
        works.setCreate_at(System.currentTimeMillis());
        works.setEditor_id(account.getId());
        code=worksService.doCreate(works)?0:-300;
        modelMap.addAttribute("code",code);
        return "result";
    }
}
