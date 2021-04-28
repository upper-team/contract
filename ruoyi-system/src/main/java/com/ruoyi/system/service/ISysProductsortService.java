package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysProductsort;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 产品分类Service接口
 * 
 * @author ruoyi
 * @date 2021-04-25
 */
public interface ISysProductsortService 
{
    /**
     * 查询产品分类
     * 
     * @param sortId 产品分类ID
     * @return 产品分类
     */
    public SysProductsort selectSysProductsortById(Long sortId);

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
     * 批量删除产品分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysProductsortByIds(String ids);

    /**
     * 删除产品分类信息
     * 
     * @param sortId 产品分类ID
     * @return 结果
     */
    public int deleteSysProductsortById(Long sortId);

    /**
     * 查询产品分类树列表
     * 
     * @return 所有产品分类信息
     */
    public List<Ztree> selectSysProductsortTree();
}
