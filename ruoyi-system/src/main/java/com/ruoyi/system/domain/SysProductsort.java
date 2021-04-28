package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 产品分类对象 sys_productsort
 * 
 * @author ruoyi
 * @date 2021-04-25
 */
public class SysProductsort extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品类别编号 */
    private Long sortId;

    /** 类别名称 */
    @Excel(name = "类别名称")
    private String sortName;

    /** 组级列表 */
    private String ancestor;

    public void setSortId(Long sortId) 
    {
        this.sortId = sortId;
    }

    public Long getSortId() 
    {
        return sortId;
    }
    public void setSortName(String sortName) 
    {
        this.sortName = sortName;
    }

    public String getSortName() 
    {
        return sortName;
    }
    public void setAncestor(String ancestor) 
    {
        this.ancestor = ancestor;
    }

    public String getAncestor() 
    {
        return ancestor;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sortId", getSortId())
            .append("parentId", getParentId())
            .append("sortName", getSortName())
            .append("orderNum", getOrderNum())
            .append("ancestor", getAncestor())
            .toString();
    }
}
