package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excels;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 供应商档案对象 sys_supplier
 * 
 * @author ruoyi
 * @date 2021-04-24
 */
public class SysSupplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 供应商编号 */
    private Long supplierId;

    private Long parentId;

    private Long sutype_id;

    /** 分类编号 */
    private Long sutypeId;

    @Excels({
            @Excel(name = "分类名称", targetAttr = "sutypeName", type = Excel.Type.EXPORT)
    })
    private SysSutype sutype;

    /** 供应商全称 */
    @Excel(name = "供应商全称")
    private String supplierFullname;

    /** 供应商简称 */
    @Excel(name = "供应商简称")
    private String supplierSimplifiedName;

    /** 供应商地址 */
    @Excel(name = "供应商地址")
    private String supplierAddress;

    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }

    public void setSutypeId(Long sutypeId) 
    {
        this.sutypeId = sutypeId;
    }

    public Long getSutypeId() 
    {
        return sutypeId;
    }
    public void setSupplierFullname(String supplierFullname) 
    {
        this.supplierFullname = supplierFullname;
    }

    public Long getParentId()
    {
        return parentId;
    }

    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    public String getSupplierFullname() 
    {
        return supplierFullname;
    }
    public void setSupplierSimplifiedName(String supplierSimplifiedName) 
    {
        this.supplierSimplifiedName = supplierSimplifiedName;
    }

    public SysSutype getSutype()
    {
        if (sutype == null)
        {
            sutype = new SysSutype();
        }
        return sutype;
    }

    public void setSutype(SysSutype sutype){
        this.sutype = sutype;
    }


    public Long getSutype_id(){
        return sutype_id;
    }

    public void setSutype_id(Long sutype_id){
        this.sutype_id = sutype_id;
    }

    public String getSupplierSimplifiedName() 
    {
        return supplierSimplifiedName;
    }
    public void setSupplierAddress(String supplierAddress) 
    {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierAddress() 
    {
        return supplierAddress;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("supplierId", getSupplierId())
            .append("sutypeId", getSutypeId())
            .append("supplierFullname", getSupplierFullname())
            .append("supplierSimplifiedName", getSupplierSimplifiedName())
            .append("supplierAddress", getSupplierAddress())
            .append("sutype", getSutype())
            .toString();
    }
}
