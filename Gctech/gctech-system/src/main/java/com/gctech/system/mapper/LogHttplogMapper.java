package com.gctech.system.mapper;

import com.gctech.system.domain.LogHttplog;

import java.util.List;

/**
 * http访问记录日志 数据层
 *
 * @author ruoyi
 * @date 2019-08-01
 */
public interface LogHttplogMapper {
    /**
     * 查询http访问记录日志信息
     *
     * @param id http访问记录日志ID
     * @return http访问记录日志信息
     */
    public LogHttplog selectLogHttplogById(Long id);

    /**
     * 查询http访问记录日志列表
     *
     * @param logHttplog http访问记录日志信息
     * @return http访问记录日志集合
     */
    public List<LogHttplog> selectLogHttplogList(LogHttplog logHttplog);

    /**
     * 新增http访问记录日志
     *
     * @param logHttplog http访问记录日志信息
     * @return 结果
     */
    public int insertLogHttplog(LogHttplog logHttplog);

    /**
     * 修改http访问记录日志
     *
     * @param logHttplog http访问记录日志信息
     * @return 结果
     */
    public int updateLogHttplog(LogHttplog logHttplog);

    /**
     * 删除http访问记录日志
     *
     * @param id http访问记录日志ID
     * @return 结果
     */
    public int deleteLogHttplogById(Long id);

    /**
     * 批量删除http访问记录日志
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLogHttplogByIds(String[] ids);

    /**
     * 根据过滤条件查询总条目
     *
     * @param logHttplog
     * @return
     */
    Long selectCount(LogHttplog logHttplog);
}