package com.gctech.web.controller.system;

import java.util.Date;
import java.util.List;

import com.gctech.common.core.page.TableDataInfo;
import com.gctech.common.utils.DateUtils;
import com.gctech.system.domain.LogHttplog;
import com.gctech.system.domain.LogSecRule;
import com.gctech.system.domain.SysLogininfor;
import com.gctech.system.service.ILogHttplogService;
import com.gctech.system.service.ILogSecRuleService;
import com.gctech.system.service.ISysLogininforService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.gctech.common.config.Global;
import com.gctech.common.core.controller.BaseController;
import com.gctech.framework.util.ShiroUtils;
import com.gctech.system.domain.SysMenu;
import com.gctech.system.domain.SysUser;
import com.gctech.system.service.ISysMenuService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 首页 业务处理
 *
 * @author ruoyi
 */
@Controller
public class SysIndexController extends BaseController {
    @Autowired
    private ISysMenuService menuService;
    @Autowired
    private ISysLogininforService logininforService;
    @Autowired
    private ILogHttplogService logHttplogService;
    @Autowired
    private ILogSecRuleService logSecRuleService;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap) {
        // 取身份信息
        SysUser user = ShiroUtils.getSysUser();
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", Global.getCopyrightYear());
        mmap.put("demoEnabled", Global.isDemoEnabled());
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap) {
        LogHttplog logHttplog = new LogHttplog();
        Long accessAll = logHttplogService.selectCount(logHttplog);
        LogSecRule rule = new LogSecRule();
        rule.setSecTpye("99");
        List<LogSecRule> logSecRules = logSecRuleService.selectLogSecRuleList(rule);
        String postBody = "";
        if (logSecRules.size() > 0) {
            postBody = logSecRules.get(0).getRule();
        }
        logHttplog.setPostBody(postBody);
        Long dangerousAll = logHttplogService.selectCount(logHttplog);
        logHttplog = new LogHttplog();
        Date date = new Date();
        Integer hours = Integer.valueOf(DateUtils.parseDateToStr("HH", date)) - 1;
        String minutes = DateUtils.parseDateToStr("mm", date);
        logHttplog.setTs(DateUtils.getDate() + "T" + hours + ":" + minutes);
        Long currentAll = logHttplogService.selectCount(logHttplog);
        mmap.put("version", Global.getVersion());
        mmap.put("accessAll", accessAll);
        mmap.put("currentAll", currentAll);
        mmap.put("dangerousAll", dangerousAll);
        mmap.put("ruleAll", logSecRules.size());
        return "main";
    }

    @RequiresPermissions("monitor:logininfor:list")
    @PostMapping("/index/userLoginLog/list")
    @ResponseBody
    public TableDataInfo list(SysLogininfor logininfor) {
        startPage();
        logininfor.setLoginName(ShiroUtils.getLoginName());
        List<SysLogininfor> list = logininforService.selectLogininforList(logininfor);
        return getDataTable(list);
    }
}
