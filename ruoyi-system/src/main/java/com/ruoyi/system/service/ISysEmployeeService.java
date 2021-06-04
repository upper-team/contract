package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysEmployee;

/**
 * 员工档案Service接口
 * 
 * @author ruoyi
 * @date 2021-04-19
 */
public interface ISysEmployeeService 
{
    /**
     * 查询员工档案
     * 
     * @param employeeId 员工档案ID
     * @return 员工档案
     */
    public SysEmployee selectSysEmployeeById(Long employeeId);

    /**
     * 查询员工档案列表
     * 
     * @param sysEmployee 员工档案
     * @return 员工档案集合
     */
    public List<SysEmployee> selectSysEmployeeList(SysEmployee sysEmployee);

    /**
     * 新增员工档案
     * 
     * @param sysEmployee 员工档案
     * @return 结果
     */
    public int insertSysEmployee(SysEmployee sysEmployee);

    /**
     * 修改员工档案
     * 
     * @param sysEmployee 员工档案
     * @return 结果
     */
    public int updateSysEmployee(SysEmployee sysEmployee);

    /**
     * 批量删除员工档案
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysEmployeeByIds(String ids);

    /**
     * 删除员工档案信息
     * 
     * @param employeeId 员工档案ID
     * @return 结果
     */
    public int deleteSysEmployeeById(Long employeeId);

    public List<SysEmployee> selectSysEmployeeAll();
}
