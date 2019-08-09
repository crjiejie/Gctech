package com.gctech.system.service.impl;

import java.util.List;

import com.gctech.system.domain.LogSecRule;
import com.gctech.system.mapper.LogSecRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gctech.system.service.ILogSecRuleService;
import com.gctech.common.core.text.Convert;

/**
 * 规则策略 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-01
 */
@Service
public class LogSecRuleServiceImpl implements ILogSecRuleService 
{
	@Autowired
	private LogSecRuleMapper logSecRuleMapper;

	/**
     * 查询规则策略信息
     * 
     * @param id 规则策略ID
     * @return 规则策略信息
     */
    @Override
	public LogSecRule selectLogSecRuleById(Long id)
	{
	    return logSecRuleMapper.selectLogSecRuleById(id);
	}
	
	/**
     * 查询规则策略列表
     * 
     * @param logSecRule 规则策略信息
     * @return 规则策略集合
     */
	@Override
	public List<LogSecRule> selectLogSecRuleList(LogSecRule logSecRule)
	{
	    return logSecRuleMapper.selectLogSecRuleList(logSecRule);
	}
	
    /**
     * 新增规则策略
     * 
     * @param logSecRule 规则策略信息
     * @return 结果
     */
	@Override
	public int insertLogSecRule(LogSecRule logSecRule)
	{
	    return logSecRuleMapper.insertLogSecRule(logSecRule);
	}
	
	/**
     * 修改规则策略
     * 
     * @param logSecRule 规则策略信息
     * @return 结果
     */
	@Override
	public int updateLogSecRule(LogSecRule logSecRule)
	{
	    return logSecRuleMapper.updateLogSecRule(logSecRule);
	}

	/**
     * 删除规则策略对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteLogSecRuleByIds(String ids)
	{
		return logSecRuleMapper.deleteLogSecRuleByIds(Convert.toStrArray(ids));
	}
	
}
