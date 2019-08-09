package com.gctech.web.controller.system;

import java.util.Date;
import java.util.List;

import com.gctech.framework.util.ShiroUtils;
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
import com.gctech.system.domain.LogSecRule;
import com.gctech.system.service.ILogSecRuleService;
import com.gctech.common.core.controller.BaseController;
import com.gctech.common.core.page.TableDataInfo;
import com.gctech.common.core.domain.AjaxResult;
import com.gctech.common.utils.poi.ExcelUtil;

/**
 * 规则策略 信息操作处理
 *
 * @author wangjunpeng
 * @date 2019-08-01
 */
@Controller
@RequestMapping("/system/logSecRule")
public class LogSecRuleController extends BaseController {
    private String prefix = "system/logSecRule";

    @Autowired
    private ILogSecRuleService logSecRuleService;

    @RequiresPermissions("system:logSecRule:view")
    @GetMapping()
    public String logSecRule() {
        return prefix + "/logSecRule";
    }

    /**
     * 查询规则策略列表
     */
    @RequiresPermissions("system:logSecRule:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LogSecRule logSecRule) {
        startPage();
        List<LogSecRule> list = logSecRuleService.selectLogSecRuleList(logSecRule);
        return getDataTable(list);
    }


    /**
     * 导出规则策略列表
     */
    @RequiresPermissions("system:logSecRule:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LogSecRule logSecRule) {
        List<LogSecRule> list = logSecRuleService.selectLogSecRuleList(logSecRule);
        ExcelUtil<LogSecRule> util = new ExcelUtil<LogSecRule>(LogSecRule.class);
        return util.exportExcel(list, "logSecRule");
    }

    /**
     * 新增规则策略
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存规则策略
     */
    @RequiresPermissions("system:logSecRule:add")
    @Log(title = "规则策略", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LogSecRule logSecRule) {
        logSecRule.setCreateBy(ShiroUtils.getLoginName());
        logSecRule.setCreateTime(new Date());
        return toAjax(logSecRuleService.insertLogSecRule(logSecRule));
    }

    /**
     * 修改规则策略
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        LogSecRule logSecRule = logSecRuleService.selectLogSecRuleById(id);
        mmap.put("logSecRule", logSecRule);
        return prefix + "/edit";
    }

    /**
     * 修改保存规则策略
     */
    @RequiresPermissions("system:logSecRule:edit")
    @Log(title = "规则策略", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LogSecRule logSecRule) {
        logSecRule.setUpdateBy(ShiroUtils.getLoginName());
        logSecRule.setUpdateTime(new Date());
        return toAjax(logSecRuleService.updateLogSecRule(logSecRule));
    }

    /**
     * 删除规则策略
     */
    @RequiresPermissions("system:logSecRule:remove")
    @Log(title = "规则策略", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(logSecRuleService.deleteLogSecRuleByIds(ids));
    }

}
