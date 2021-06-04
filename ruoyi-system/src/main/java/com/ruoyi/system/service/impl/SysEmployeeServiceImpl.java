package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysEmployeeMapper;
import com.ruoyi.system.domain.SysEmployee;
import com.ruoyi.system.service.ISysEmployeeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 员工档案Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-19
 */
@Service
public class SysEmployeeServiceImpl implements ISysEmployeeService 
{
    @Autowired
    private SysEmployeeMapper sysEmployeeMapper;

    /**
     * 查询员工档案
     * 
     * @param employeeId 员工档案ID
     * @return 员工档案
     */
    @Override
    public SysEmployee selectSysEmployeeById(Long employeeId)
    {
        return sysEmployeeMapper.selectSysEmployeeById(employeeId);
    }

    /**
     * 查询员工档案列表
     * 
     * @param sysEmployee 员工档案
     * @return 员工档案
     */
    @Override
    public List<SysEmployee> selectSysEmployeeList(SysEmployee sysEmployee)
    {
        return sysEmployeeMapper.selectSysEmployeeList(sysEmployee);
    }

    /**
     * 新增员工档案
     * 
     * @param sysEmployee 员工档案
     * @return 结果
     */
    @Override
    public int insertSysEmployee(SysEmployee sysEmployee)
    {
        return sysEmployeeMapper.insertSysEmployee(sysEmployee);
    }

    /**
     * 修改员工档案
     * 
     * @param sysEmployee 员工档案
     * @return 结果
     */
    @Override
    public int updateSysEmployee(SysEmployee sysEmployee)
    {
        return sysEmployeeMapper.updateSysEmployee(sysEmployee);
    }

    /**
     * 删除员工档案对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysEmployeeByIds(String ids)
    {
        return sysEmployeeMapper.deleteSysEmployeeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除员工档案信息
     * 
     * @param employeeId 员工档案ID
     * @return 结果
     */
    @Override
    public int deleteSysEmployeeById(Long employeeId)
    {
        return sysEmployeeMapper.deleteSysEmployeeById(employeeId);
    }

    @Override
    public List<SysEmployee> selectSysEmployeeAll(){
        return sysEmployeeMapper.selectSysEmployeeAll();
    }
}
