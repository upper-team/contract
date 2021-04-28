package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excels;
import com.ruoyi.common.core.domain.entity.SysDept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 员工档案对象 sys_employee
 * 
 * @author ruoyi
 * @date 2021-04-19
 */
public class SysEmployee extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工工号 */
    private Long employeeId;

    /** 部门父ID */
    private Long parentId;

    /** 部门名称 */
    private Long departmentId;

    /** 员工姓名 */
    @Excel(name = "员工姓名")
    private String employeeName;

    /** 部门对象 */
    @Excels({
            @Excel(name = "部门名称", targetAttr = "departmentName", type = Excel.Type.EXPORT),
    })
    private SysDepartment department;

    public SysDepartment getDepartment()
    {
        if (department == null)
        {
            department = new SysDepartment();
        }
        return department;
    }

    public void setDepartment(SysDepartment department)
    {
        this.department = department;
    }

    public Long getParentId()
    {
        return parentId;
    }

    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    public void setEmployeeId(Long employeeId) 
    {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() 
    {
        return employeeId;
    }

    public void setDepartmentId(Long departmentId) 
    {
        this.departmentId = departmentId;
    }

    public Long getDepartmentId() 
    {
        return departmentId;
    }

    public void setEmployeeName(String employeeName) 
    {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() 
    {
        return employeeName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("employeeId", getEmployeeId())
            .append("departmentId", getDepartmentId())
            .append("employeeName", getEmployeeName())
            .append("department", getDepartment())
            .toString();
    }
}
