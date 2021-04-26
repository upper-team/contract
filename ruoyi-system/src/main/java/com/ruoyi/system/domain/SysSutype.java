package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 供应商分类对象 sys_sutype
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
public class SysSutype extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 供应商分类id */
    private Long sutypeId;

    /** 祖级列表 */
    private String ancestor;

    /** 分类名称 */
    @Excel(name = "分类名称")
    private String sutypeName;

    public void setSutypeId(Long sutypeId) 
    {
        this.sutypeId = sutypeId;
    }

    public Long getSutypeId() 
    {
        return sutypeId;
    }
    public void setAncestor(String ancestor) 
    {
        this.ancestor = ancestor;
    }

    public String getAncestor() 
    {
        return ancestor;
    }
    public void setSutypeName(String sutypeName) 
    {
        this.sutypeName = sutypeName;
    }

    public String getSutypeName() 
    {
        return sutypeName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sutypeId", getSutypeId())
            .append("parentId", getParentId())
            .append("ancestor", getAncestor())
            .append("sutypeName", getSutypeName())
            .append("orderNum", getOrderNum())
            .toString();
    }
}
