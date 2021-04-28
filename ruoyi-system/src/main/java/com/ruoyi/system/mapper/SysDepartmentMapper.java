package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.system.domain.SysDepartment;
import org.apache.ibatis.annotations.Param;

/**
 * 部门档案Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-21
 */
public interface SysDepartmentMapper 
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
     * 删除部门档案
     * 
     * @param departmentId 部门档案ID
     * @return 结果
     */
    public int deleteSysDepartmentById(Long departmentId);

    /**
     * 批量删除部门档案
     * 
     * @param departmentIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysDepartmentByIds(String[] departmentIds);

    /**
     * 根据ID查询所有子部门
     *
     * @param deptId 部门ID
     * @return 部门列表
     */
    public List<SysDepartment> selectChildrenDepartmentById(Long departmentId);

    /**
     * 修改子元素关系
     *
     * @param depts 子元素
     * @return 结果
     */
    public int updateDepartmentChildren(@Param("departments") List<SysDepartment> departments);
}
