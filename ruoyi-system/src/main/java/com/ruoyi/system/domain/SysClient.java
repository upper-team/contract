package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excels;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户档案对象 sys_client
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
public class SysClient extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 客户ID */
    @Excel(name = "客户ID")
    private Long clientId;

    /** 分类ID */
    private Long clitypeId;

    /** 客户全称 */
    @Excel(name = "客户全称")
    private String clientFullName;

    private Long parentId;

    /** 客户简称 */
    @Excel(name = "客户简称")
    private String clientSimplifiedName;

    /** 客户地址 */
    @Excel(name = "客户地址")
    private String clientAddress;

    @Excels({
            @Excel(name = "分类名称", targetAttr = "clitypeName", type = Excel.Type.EXPORT)
    })
    private SysClitype clitype;

    public void setClientId(Long clientId) 
    {
        this.clientId = clientId;
    }

    public Long getClientId() 
    {
        return clientId;
    }
    public void setClitypeId(Long clitypeId) 
    {
        this.clitypeId = clitypeId;
    }

    public Long getClitypeId() 
    {
        return clitypeId;
    }

    public Long getParentId()
    {
        return parentId;
    }

    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    public void setClientFullName(String clientFullName) 
    {
        this.clientFullName = clientFullName;
    }

    public String getClientFullName() 
    {
        return clientFullName;
    }

    public void setClientSimplifiedName(String clientSimplifiedName) 
    {
        this.clientSimplifiedName = clientSimplifiedName;
    }

    public String getClientSimplifiedName() 
    {
        return clientSimplifiedName;
    }

    public void setClientAddress(String clientAddress) 
    {
        this.clientAddress = clientAddress;
    }

    public String getClientAddress() 
    {
        return clientAddress;
    }

    public SysClitype getClitype()
    {
        if (clitype == null)
        {
            clitype = new SysClitype();
        }
        return clitype;
    }

    public void setClitype(SysClitype clitype)
    {
        this.clitype = clitype;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("clientId", getClientId())
            .append("clitypeId", getClitypeId())
            .append("clientFullName", getClientFullName())
            .append("clientSimplifiedName", getClientSimplifiedName())
            .append("clientAddress", getClientAddress())
            .append("clitype", getClitype())
            .toString();
    }
}
