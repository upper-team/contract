package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysProductsort;
import com.ruoyi.system.domain.SysSutype;
import org.apache.ibatis.annotations.Param;

/**
 * 产品分类Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-25
 */
public interface SysProductsortMapper 
{
    /**
     * 查询产品分类
     * 
     * @param sortId 产品分类ID
     * @return 产品分类
     */
    public SysProductsort selectSysProductsortById(Long sortId);

    /**
     * 修改子元素关系
     *
     * @param depts 子元素
     * @return 结果
     */
    public int updateProductsortChildren(@Param("productsorts") List<SysProductsort> productsorts);
    public List<SysProductsort> selectChildrenProductsortById(Long sortId);

    /**
     * 查询产品分类列表
     * 
     * @param sysProductsort 产品分类
     * @return 产品分类集合
     */
    public List<SysProductsort> selectSysProductsortList(SysProductsort sysProductsort);

    /**
     * 新增产品分类
     * 
     * @param sysProductsort 产品分类
     * @return 结果
     */
    public int insertSysProductsort(SysProductsort sysProductsort);

    /**
     * 修改产品分类
     * 
     * @param sysProductsort 产品分类
     * @return 结果
     */
    public int updateSysProductsort(SysProductsort sysProductsort);

    /**
     * 删除产品分类
     * 
     * @param sortId 产品分类ID
     * @return 结果
     */
    public int deleteSysProductsortById(Long sortId);

    /**
     * 批量删除产品分类
     * 
     * @param sortIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysProductsortByIds(String[] sortIds);
}
