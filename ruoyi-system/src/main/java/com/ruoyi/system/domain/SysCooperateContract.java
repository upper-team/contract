package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 合作合同管理对象 sys_cooperate_contract
 * 
 * @author ruoyi
 * @date 2021-04-19
 */
public class SysCooperateContract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合同id */
    private Long contractId;

    /** 合同分类id */
    @Excel(name = "合同分类id")
    private Long contractDeptId;

    /** 合同名称 */
    @Excel(name = "合同名称")
    private String contractName;

    /** 合同标的 */
    @Excel(name = "合同标的")
    private String contractTarget;

    /** 业务员 */
    @Excel(name = "业务员")
    private String manager;

    /** 合同金额 */
    @Excel(name = "合同金额")
    private Long contractAmount;

    /** 签订日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "签订日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signDate;

    public void setContractId(Long contractId) 
    {
        this.contractId = contractId;
    }

    public Long getContractId() 
    {
        return contractId;
    }
    public void setContractDeptId(Long contractDeptId) 
    {
        this.contractDeptId = contractDeptId;
    }

    public Long getContractDeptId() 
    {
        return contractDeptId;
    }
    public void setContractName(String contractName) 
    {
        this.contractName = contractName;
    }

    public String getContractName() 
    {
        return contractName;
    }
    public void setContractTarget(String contractTarget) 
    {
        this.contractTarget = contractTarget;
    }

    public String getContractTarget() 
    {
        return contractTarget;
    }
    public void setManager(String manager) 
    {
        this.manager = manager;
    }

    public String getManager() 
    {
        return manager;
    }
    public void setContractAmount(Long contractAmount) 
    {
        this.contractAmount = contractAmount;
    }

    public Long getContractAmount() 
    {
        return contractAmount;
    }
    public void setSignDate(Date signDate) 
    {
        this.signDate = signDate;
    }

    public Date getSignDate() 
    {
        return signDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("contractId", getContractId())
            .append("contractDeptId", getContractDeptId())
            .append("contractName", getContractName())
            .append("contractTarget", getContractTarget())
            .append("manager", getManager())
            .append("contractAmount", getContractAmount())
            .append("signDate", getSignDate())
            .toString();
    }
}
