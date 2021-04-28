package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysDepartment;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 部门档案Service接口
 * 
 * @author ruoyi
 * @date 2021-04-21
 */
public interface ISysDepartmentService 
{
    /**
     * 查询部门档案
     * 
     * @param departmentId 部门档案ID
     * @return 部门档案
     */
    public SysDepartment selectSysDepartmentById(Long departmentId);

    /**
     * 查询部门档案列表
     * 
     * @param sysDepartment 部门档案
     * @return 部门档案集合
     */
    public List<SysDepartment> selectSysDepartmentList(SysDepartment sysDepartment);

    /**
     * 新增部门档案
     * 
     * @param sysDepartment 部门档案
     * @return 结果
     */
    public int insertSysDepartment(SysDepartment sysDepartment);

    /**
     * 修改部门档案
     * 
     * @param sysDepartment 部门档案
     * @return 结果
     */
    public int updateSysDepartment(SysDepartment sysDepartment);

    /**
     * 批量删除部门档案
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysDepartmentByIds(String ids);

    /**
     * 删除部门档案信息
     * 
     * @param departmentId 部门档案ID
     * @return 结果
     */
    public int deleteSysDepartmentById(Long departmentId);

    /**
     * 查询部门档案树列表
     * 
     * @return 所有部门档案信息
     */
    public List<Ztree> selectSysDepartmentTree();
}
