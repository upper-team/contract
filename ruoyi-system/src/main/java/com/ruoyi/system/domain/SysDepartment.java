package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 部门档案对象 sys_department
 * 
 * @author ruoyi
 * @date 2021-04-21
 */
public class SysDepartment extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 部门编号 */
    private Long departmentId;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String departmentName;

    public void setDepartmentId(Long departmentId) 
    {
        this.departmentId = departmentId;
    }
    public Long getDepartmentId() 
    {
        return departmentId;
    }

    public void setDepartmentName(String departmentName) 
    {
        this.departmentName = departmentName;
    }
    public String getDepartmentName() 
    {
        return departmentName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("departmentId", getDepartmentId())
            .append("departmentName", getDepartmentName())
            .append("parentId", getParentId())
            .append("ancestors", getAncestors())
            .toString();
    }
}
