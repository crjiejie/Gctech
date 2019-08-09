package com.gctech.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gctech.common.core.domain.BaseEntity;

/**
 * 规则策略表 log_sec_rule
 * 
 * @author ruoyi
 * @date 2019-08-01
 */
public class LogSecRule extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long id;
	/** 匹配内容 */
	private String rule;
	/** 规则类型 */
	private String secTpye;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setRule(String rule) 
	{
		this.rule = rule;
	}

	public String getRule() 
	{
		return rule;
	}
	public void setSecTpye(String secTpye)
	{
		this.secTpye = secTpye;
	}

	public String getSecTpye()
	{
		return secTpye;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("rule", getRule())
            .append("secTpye", getSecTpye())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
