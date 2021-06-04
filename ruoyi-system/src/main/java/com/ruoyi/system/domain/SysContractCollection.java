package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 收款合同对象 sys_contract_collection
 * 
 * @author ruoyi
 * @date 2021-05-03
 */
public class SysContractCollection extends BaseEntity
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

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String clientName;

    /** 合同标的 */
    @Excel(name = "合同标的")
    private String contractObject;

    /** 规格版本 */
    @Excel(name = "规格版本")
    private String specificationVersion;

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

    /** 履约保证金 */
    @Excel(name = "履约保证金")
    private Long performanceBond;

    /** 付款条件 */
    @Excel(name = "付款条件")
    private String paymentTerm;

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

    public String getContractName() 
    {
        return contractName;
    }
    public void setClientName(String clientName) 
    {
        this.clientName = clientName;
    }

    public String getClientName() 
    {
        return clientName;
    }
    public void setContractObject(String contractObject) 
    {
        this.contractObject = contractObject;
    }

    public String getContractObject() 
    {
        return contractObject;
    }
    public void setSpecificationVersion(String specificationVersion) 
    {
        this.specificationVersion = specificationVersion;
    }

    public String getSpecificationVersion() 
    {
        return specificationVersion;
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
    public void setPerformanceBond(Long performanceBond) 
    {
        this.performanceBond = performanceBond;
    }

    public Long getPerformanceBond() 
    {
        return performanceBond;
    }
    public void setPaymentTerm(String paymentTerm) 
    {
        this.paymentTerm = paymentTerm;
    }

    public String getPaymentTerm() 
    {
        return paymentTerm;
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
            .append("clientName", getClientName())
            .append("contractObject", getContractObject())
            .append("specificationVersion", getSpecificationVersion())
            .append("manager", getManager())
            .append("contractAmount", getContractAmount())
            .append("signDate", getSignDate())
            .append("performanceBond", getPerformanceBond())
            .append("paymentTerm", getPaymentTerm())
            .append("remarks", getRemarks())
            .append("scanningCopy", getScanningCopy())
            .toString();
    }
}
