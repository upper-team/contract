package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 合同分类对象 sys_contract_dept
 * 
 * @author ruoyi
 * @date 2021-04-18
 */
public class SysContractDept extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 合同分类id */
    private Long contractId;

    /** 合同分类id */
    @Excel(name = "合同分类id")
    private String contractDeptName;

    public void setContractId(Long contractId) 
    {
        this.contractId = contractId;
    }

    public Long getContractId() 
    {
        return contractId;
    }
    public void setContractDeptName(String contractDeptName) 
    {
        this.contractDeptName = contractDeptName;
    }

    public String getContractDeptName() 
    {
        return contractDeptName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("contractId", getContractId())
            .append("parentId", getParentId())
            .append("contractDeptName", getContractDeptName())
            .append("orderNum", getOrderNum())
            .toString();
    }
}
