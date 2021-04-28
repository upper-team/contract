package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excels;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品档案对象 sys_product
 * 
 * @author ruoyi
 * @date 2021-04-24
 */
public class SysProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品id */
    private Long productId;

    /** 分类父ID */
    private Long parentId;

    /** 产品编号 */
    @Excel(name = "产品编号")
    private Long productNum;

    /** 产品名称（开票名称） */
    @Excel(name = "产品名称", readConverterExp = "开=票名称")
    private String productName;

    /** 产品分类 */
    @Excel(name = "产品分类")
    private Long sortId;

    /** 分类对象 */
    @Excels({
            @Excel(name = "分类名称", targetAttr = "productsortName", type = Excel.Type.EXPORT),
    })
    private SysProductsort productsort;

    public SysProductsort getProductsort()
    {
        if (productsort == null)
        {
            productsort = new SysProductsort();
        }
        return productsort;
    }

    public void setProductsort(SysProductsort productsort)
    {
        this.productsort = productsort;
    }

    public Long getParentId()
    {
        return parentId;
    }

    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    public void setProductId(Long productId)
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setProductNum(Long productNum) 
    {
        this.productNum = productNum;
    }

    public Long getProductNum() 
    {
        return productNum;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setSortId(Long sortId) 
    {
        this.sortId = sortId;
    }

    public Long getSortId() 
    {
        return sortId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productId", getProductId())
            .append("productNum", getProductNum())
            .append("productName", getProductName())
            .append("sortId", getSortId())
             .append("productsort",getProductsort())
            .toString();
    }
}
