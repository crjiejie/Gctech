package com.gctech.web.controller.system;

import java.util.List;

import com.gctech.common.utils.StringUtils;
import com.gctech.system.domain.LogSecRule;
import com.gctech.system.service.ILogSecRuleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gctech.common.annotation.Log;
import com.gctech.common.enums.BusinessType;
import com.gctech.system.domain.LogHttplog;
import com.gctech.system.service.ILogHttplogService;
import com.gctech.common.core.controller.BaseController;
import com.gctech.common.core.page.TableDataInfo;
import com.gctech.common.core.domain.AjaxResult;
import com.gctech.common.utils.poi.ExcelUtil;

/**
 * http访问记录日志 信息操作处理
 *
 * @author wangjunpeng
 * @date 2019-08-01
 */
@Controller
@RequestMapping("/system/logHttplog")
public class LogHttplogController extends BaseController {
    private String prefix = "system/logHttplog";

    @Autowired
    private ILogHttplogService logHttplogService;
    @Autowired
    private ILogSecRuleService logSecRuleService;

    @RequiresPermissions("system:logHttplog:view")
    @GetMapping()
    public String logHttplog() {
        return prefix + "/logHttplog";
    }

    @RequiresPermissions("\tsystem:logHttplog:dangerous:view")
    @GetMapping("dangerous")
    public String dangerous() {
        return prefix + "/logHttplogDangerous";
    }

    /**
     * 查询http访问记录日志列表
     */
    @RequiresPermissions("system:logHttplog:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LogHttplog logHttplog) {
        startPage();
        List<LogHttplog> list = logHttplogService.selectLogHttplogList(logHttplog);
        for (LogHttplog httplog : list) {
            String ts = httplog.getTs();
            if(StringUtils.isNotBlank(ts)){
                httplog.setTs(ts.substring(0,10)+" "+ts.substring(ts.indexOf("T")+1,ts.indexOf("T")+9));
            }
        }
        return getDataTable(list);
    }

    /**
     * 查询http访问记录日志列表
     */
    @RequiresPermissions("system:logHttplog:list")
    @PostMapping("/dangerous/list")
    @ResponseBody
    public TableDataInfo dangerousList(LogHttplog logHttplog) {
        LogSecRule rule = new LogSecRule();
        rule.setSecTpye("99");
        List<LogSecRule> logSecRules = logSecRuleService.selectLogSecRuleList(rule);
        String postBody = "";
        if (logSecRules.size() > 0) {
            postBody = logSecRules.get(0).getRule();
        }
        logHttplog.setPostBody(postBody);
        startPage();
        List<LogHttplog> list = logHttplogService.selectLogHttplogList(logHttplog);
        for (LogHttplog httplog : list) {
            String ts = httplog.getTs();
            if(StringUtils.isNotBlank(ts)){
                httplog.setTs(ts.substring(0,10)+" "+ts.substring(ts.indexOf("T")+1,ts.indexOf("T")+9));
            }
        }
        return getDataTable(list);
    }


    /**
     * 导出http访问记录日志列表
     */
    @RequiresPermissions("system:logHttplog:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LogHttplog logHttplog) {
        List<LogHttplog> list = logHttplogService.selectLogHttplogList(logHttplog);
        ExcelUtil<LogHttplog> util = new ExcelUtil<LogHttplog>(LogHttplog.class);
        return util.exportExcel(list, "logHttplog");
    }

    /**
     * 新增http访问记录日志
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存http访问记录日志
     */
    @RequiresPermissions("system:logHttplog:add")
    @Log(title = "http访问记录日志", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LogHttplog logHttplog) {
        return toAjax(logHttplogService.insertLogHttplog(logHttplog));
    }

    /**
     * 修改http访问记录日志
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        LogHttplog logHttplog = logHttplogService.selectLogHttplogById(id);
        mmap.put("logHttplog", logHttplog);
        return prefix + "/edit";
    }

    /**
     * http访问记录日志详情
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap) {
        LogHttplog logHttplog = logHttplogService.selectLogHttplogById(id);
        mmap.put("logHttplog", logHttplog);
        return prefix + "/detail";
    }

    /**
     * 修改保存http访问记录日志
     */
    @RequiresPermissions("system:logHttplog:edit")
    @Log(title = "http访问记录日志", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LogHttplog logHttplog) {
        return toAjax(logHttplogService.updateLogHttplog(logHttplog));
    }

    /**
     * 删除http访问记录日志
     */
    @RequiresPermissions("system:logHttplog:remove")
    @Log(title = "http访问记录日志", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(logHttplogService.deleteLogHttplogByIds(ids));
    }

}
