package com.gctech.system.service;

import com.gctech.system.domain.LogSecRule;

import java.util.List;

/**
 * 规则策略 服务层
 * 
 * @author ruoyi
 * @date 2019-08-01
 */
public interface ILogSecRuleService 
{
	/**
     * 查询规则策略信息
     * 
     * @param id 规则策略ID
     * @return 规则策略信息
     */
	public LogSecRule selectLogSecRuleById(Long id);
	
	/**
     * 查询规则策略列表
     * 
     * @param logSecRule 规则策略信息
     * @return 规则策略集合
     */
	public List<LogSecRule> selectLogSecRuleList(LogSecRule logSecRule);
	
	/**
     * 新增规则策略
     * 
     * @param logSecRule 规则策略信息
     * @return 结果
     */
	public int insertLogSecRule(LogSecRule logSecRule);
	
	/**
     * 修改规则策略
     * 
     * @param logSecRule 规则策略信息
     * @return 结果
     */
	public int updateLogSecRule(LogSecRule logSecRule);
		
	/**
     * 删除规则策略信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteLogSecRuleByIds(String ids);
	
}
