package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 付款合同对象 sys_contract_payment
 * 
 * @author ruoyi
 * @date 2021-05-09
 */
public class SysContractPayment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合同id */
    private Long contractId;
    /** 合同名称 */
    @Excel(name = "合同名称")
    private String contractName;
    /** 合同编号 */
    @Excel(name = "合同编号")
    private String contractNum;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierFullname;

    /** 合同标的 */
    @Excel(name = "合同标的")
    private String productName;

    /** 业务员 */
    @Excel(name = "业务员")
    private String employeeName;

    /** 合同金额 */
    @Excel(name = "合同金额")
    private String contractSum;

    /** 签订日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "签订日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date contractDate;

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

    public void setContractName(String contractName)
    {
        this.contractName = contractName;
    }

    public String getContractName()
    {
        return contractName;
    }
    public void setContractNum(String contractNum) 
    {
        this.contractNum = contractNum;
    }

    public String getContractNum() 
    {
        return contractNum;
    }
    public void setSupplierFullname(String supplierFullname)
    {
        this.supplierFullname = supplierFullname;
    }

    public String getSupplierFullname()
    {
        return supplierFullname;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setEmployeeName(String employeeName) 
    {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() 
    {
        return employeeName;
    }
    public void setContractSum(String contractSum) 
    {
        this.contractSum = contractSum;
    }

    public String getContractSum() 
    {
        return contractSum;
    }
    public void setContractDate(Date contractDate) 
    {
        this.contractDate = contractDate;
    }

    public Date getContractDate() 
    {
        return contractDate;
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
                .append("contractName", getContractName())
            .append("contractNum", getContractNum())
            .append("supplierFullname", getSupplierFullname())
            .append("productName", getProductName())
            .append("employeeName", getEmployeeName())
            .append("contractSum", getContractSum())
            .append("contractDate", getContractDate())
            .append("remark", getRemark())
                .append("scanningCopy", getScanningCopy())

            .toString();
    }
}
