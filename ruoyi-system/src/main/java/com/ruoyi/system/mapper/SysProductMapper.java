package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysProduct;

/**
 * 产品档案Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-24
 */
public interface SysProductMapper 
{
    /**
     * 查询产品档案
     * 
     * @param productId 产品档案ID
     * @return 产品档案
     */
    public SysProduct selectSysProductById(Long productId);

    /**
     * 查询产品档案列表
     * 
     * @param sysProduct 产品档案
     * @return 产品档案集合
     */
    public List<SysProduct> selectSysProductList(SysProduct sysProduct);

    /**
     * 新增产品档案
     * 
     * @param sysProduct 产品档案
     * @return 结果
     */
    public int insertSysProduct(SysProduct sysProduct);

    /**
     * 修改产品档案
     * 
     * @param sysProduct 产品档案
     * @return 结果
     */
    public int updateSysProduct(SysProduct sysProduct);

    /**
     * 删除产品档案
     * 
     * @param productId 产品档案ID
     * @return 结果
     */
    public int deleteSysProductById(Long productId);

    /**
     * 批量删除产品档案
     * 
     * @param productIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysProductByIds(String[] productIds);

    public List<SysProduct> selectSysProductAll();
}
