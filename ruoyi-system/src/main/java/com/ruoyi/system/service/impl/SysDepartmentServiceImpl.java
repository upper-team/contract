package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.ArrayList;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysDepartmentMapper;
import com.ruoyi.system.domain.SysDepartment;
import com.ruoyi.system.service.ISysDepartmentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 部门档案Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-21
 */
@Service
public class SysDepartmentServiceImpl implements ISysDepartmentService 
{
    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;

    /**
     * 查询部门档案
     * 
     * @param departmentId 部门档案ID
     * @return 部门档案
     */
    @Override
    public SysDepartment selectSysDepartmentById(Long departmentId)
    {
        return sysDepartmentMapper.selectSysDepartmentById(departmentId);
    }

    /**
     * 查询部门档案列表
     * 
     * @param sysDepartment 部门档案
     * @return 部门档案
     */
    @Override
    public List<SysDepartment> selectSysDepartmentList(SysDepartment sysDepartment)
    {
        return sysDepartmentMapper.selectSysDepartmentList(sysDepartment);
    }

    /**
     * 新增部门档案
     * 
     * @param sysDepartment 部门档案
     * @return 结果
     */
    @Override
    public int insertSysDepartment(SysDepartment sysDepartment)
    {
        SysDepartment info = sysDepartmentMapper.selectSysDepartmentById(sysDepartment.getParentId());
        sysDepartment.setAncestors(info.getAncestors() + "," + sysDepartment.getParentId());
        return sysDepartmentMapper.insertSysDepartment(sysDepartment);
    }

    /**
     * 修改部门档案
     * 
     * @param sysDepartment 部门档案
     * @return 结果
     */
    @Override
    public int updateSysDepartment(SysDepartment sysDepartment)
    {
        SysDepartment newParentDept = sysDepartmentMapper.selectSysDepartmentById(sysDepartment.getParentId());
        SysDepartment oldDept = selectSysDepartmentById(sysDepartment.getDepartmentId());
        if (StringUtils.isNotNull(newParentDept) && StringUtils.isNotNull(oldDept))
        {
            String newAncestors = newParentDept.getAncestors() + "," + newParentDept.getDepartmentId();
            String oldAncestors = oldDept.getAncestors();
            sysDepartment.setAncestors(newAncestors);
            updateDepartmentChildren(sysDepartment.getDepartmentId(), newAncestors, oldAncestors);
        }
        int result = sysDepartmentMapper.updateSysDepartment(sysDepartment);
        return result;
    }

    /**
     * 修改子元素关系
     *
     * @param deptId 被修改的部门ID
     * @param newAncestors 新的父ID集合
     * @param oldAncestors 旧的父ID集合
     */
    public void updateDepartmentChildren(Long deptId, String newAncestors, String oldAncestors)
    {
        List<SysDepartment> children = sysDepartmentMapper.selectChildrenDepartmentById(deptId);
        for (SysDepartment child : children)
        {
            child.setAncestors(child.getAncestors().replace(oldAncestors, newAncestors));
        }
        if (children.size() > 0)
        {
            sysDepartmentMapper.updateDepartmentChildren(children);
        }
    }

    /**
     * 删除部门档案对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysDepartmentByIds(String ids)
    {
        return sysDepartmentMapper.deleteSysDepartmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除部门档案信息
     * 
     * @param departmentId 部门档案ID
     * @return 结果
     */
    @Override
    public int deleteSysDepartmentById(Long departmentId)
    {
        return sysDepartmentMapper.deleteSysDepartmentById(departmentId);
    }

    /**
     * 查询部门档案树列表
     * 
     * @return 所有部门档案信息
     */
    @Override
    public List<Ztree> selectSysDepartmentTree()
    {
        List<SysDepartment> sysDepartmentList = sysDepartmentMapper.selectSysDepartmentList(new SysDepartment());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (SysDepartment sysDepartment : sysDepartmentList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(sysDepartment.getDepartmentId());
            ztree.setpId(sysDepartment.getParentId());
            ztree.setName(sysDepartment.getDepartmentName());
            ztree.setTitle(sysDepartment.getDepartmentName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
