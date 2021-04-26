package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 客户类型对象 sys_clitype
 * 
 * @author ruoyi
 * @date 2021-04-19
 */
public class SysClitype extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 客户类型ID */
    private Long clitypeId;

    /** 客户类型名称 */
    @Excel(name = "客户类型名称")
    private String clitypeName;

    public void setClitypeId(Long clitypeId) 
    {
        this.clitypeId = clitypeId;
    }

    public Long getClitypeId() 
    {
        return clitypeId;
    }

    public void setClitypeName(String clitypeName) 
    {
        this.clitypeName = clitypeName;
    }

    public String getClitypeName() 
    {
        return clitypeName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("clitypeId", getClitypeId())
            .append("parentId", getParentId())
            .append("ancestors", getAncestors())
            .append("clitypeName", getClitypeName())
            .append("orderNum", getOrderNum())
            .toString();
    }
}
