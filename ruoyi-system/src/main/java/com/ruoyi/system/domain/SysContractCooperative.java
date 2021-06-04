package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 合作合同对象 sys_contract_cooperative
 * 
 * @author ruoyi
 * @date 2021-05-04
 */
public class SysContractCooperative extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合同ID */
    private Long contractId;

    /** 合同编号 */
    @Excel(name = "合同编号")
    private Long contractNum;

    /** 合同名称 */
    @Excel(name = "合同名称")
    private String contractName;

    /** 合作单位 */
    @Excel(name = "合作单位")
    private String cooperationUnit;

    /** 合作标的 */
    @Excel(name = "合作标的")
    private String contractObject;

    /** 业务员 */
    @Excel(name = "业务员")
    private String employeeName;

    /** 签订日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "签订日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date contractDate;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 合同扫描件 */
    private String scanningCopy;

    private String[] idArr;

    public void setContractId(Long contractId) 
    {
        this.contractId = contractId;
    }

    public Long getContractId() 
    {
        return contractId;
    }
    public void setContractNum(Long contractNum) 
    {
        this.contractNum = contractNum;
    }

    public Long getContractNum() 
    {
        return contractNum;
    }
    public void setContractName(String contractName) 
    {
        this.contractName = contractName;
    }
    public String getContractName() { return contractName; }


    public void setCooperationUnit(String cooperationUnit) 
    {
        this.cooperationUnit = cooperationUnit;
    }

    public String getCooperationUnit() 
    {
        return cooperationUnit;
    }
    public void setContractObject(String contractObject) 
    {
        this.contractObject = contractObject;
    }

    public String getContractObject() 
    {
        return contractObject;
    }
    public void setEmployeeName(String employeeName) 
    {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() 
    {
        return employeeName;
    }
    public void setContractDate(Date contractDate) 
    {
        this.contractDate = contractDate;
    }

    public Date getContractDate() 
    {
        return contractDate;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }

    public void setScanningCopy(String scanningCopy)
    {
        this.scanningCopy = scanningCopy;
    }

    public String getScanningCopy()
    {
        return scanningCopy;
    }

    public String[] getIdArr() {
        return idArr;
    }

    public void setIdArr(String[] idArr) {
        this.idArr = idArr;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("contractId", getContractId())
            .append("contractNum", getContractNum())
            .append("contractName", getContractName())
            .append("cooperationUnit", getCooperationUnit())
            .append("contractObject", getContractObject())
            .append("employeeName", getEmployeeName())
            .append("contractDate", getContractDate())
            .append("remarks", getRemarks())
            .append("scanningCopy", getScanningCopy())
            .toString();
    }
}
