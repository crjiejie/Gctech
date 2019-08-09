package com.gctech.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gctech.system.mapper.LogHttplogMapper;
import com.gctech.system.domain.LogHttplog;
import com.gctech.system.service.ILogHttplogService;
import com.gctech.common.core.text.Convert;

/**
 * http访问记录日志 服务层实现
 *
 * @author ruoyi
 * @date 2019-08-01
 */
@Service
public class LogHttplogServiceImpl implements ILogHttplogService {
    @Autowired
    private LogHttplogMapper logHttplogMapper;

    /**
     * 查询http访问记录日志信息
     *
     * @param id http访问记录日志ID
     * @return http访问记录日志信息
     */
    @Override
    public LogHttplog selectLogHttplogById(Long id) {
        return logHttplogMapper.selectLogHttplogById(id);
    }

    /**
     * 查询http访问记录日志列表
     *
     * @param logHttplog http访问记录日志信息
     * @return http访问记录日志集合
     */
    @Override
    public List<LogHttplog> selectLogHttplogList(LogHttplog logHttplog) {
        return logHttplogMapper.selectLogHttplogList(logHttplog);
    }

    /**
     * 新增http访问记录日志
     *
     * @param logHttplog http访问记录日志信息
     * @return 结果
     */
    @Override
    public int insertLogHttplog(LogHttplog logHttplog) {
        return logHttplogMapper.insertLogHttplog(logHttplog);
    }

    /**
     * 修改http访问记录日志
     *
     * @param logHttplog http访问记录日志信息
     * @return 结果
     */
    @Override
    public int updateLogHttplog(LogHttplog logHttplog) {
        return logHttplogMapper.updateLogHttplog(logHttplog);
    }

    /**
     * 删除http访问记录日志对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLogHttplogByIds(String ids) {
        return logHttplogMapper.deleteLogHttplogByIds(Convert.toStrArray(ids));
    }

    @Override
    public Long selectCount(LogHttplog logHttplog) {
        return logHttplogMapper.selectCount(logHttplog);
    }
}
