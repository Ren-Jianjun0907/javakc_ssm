package com.zhg.javakc.modules.test.controller;

import com.zhg.javakc.base.page.Page;
import com.zhg.javakc.base.util.CommonUtil;
import com.zhg.javakc.modules.test.entity.Testentity;
import com.zhg.javakc.modules.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author :任建军
 * @date: 2019/11/19
 **/
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/queryTest")
    public ModelAndView queryTest(Testentity testentity, HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView=new ModelAndView("test/list");
       Page<Testentity> page=testService.queryTest(testentity,new Page<Testentity>(request,response));
        modelAndView.addObject("page",page);
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Testentity testentity){
        //设置ID
        testentity.setTestId(CommonUtil.uuid());
    testService.save(testentity);
    return "redirect:queryTest.do";
    }
    @RequestMapping("/view")
    public String view(String ids, ModelMap modelMap){
        //根据id查到相应的数据
        Testentity testentity=testService.get(ids);
        //查询到得数据给了modelMap
        modelMap.put("testentity",testentity);
        return "test/update";

    }
    @RequestMapping("/update")
    public String update(Testentity testentity){
        testService.update(testentity);
        return "redirect:queryTest.do";
    }
    @RequestMapping("/delete")
    public String delete(String[] ids){
testService.delete(ids);
        return "redirect:queryTest.do";
        }
}
