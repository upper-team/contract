package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysProductMapper;
import com.ruoyi.system.domain.SysProduct;
import com.ruoyi.system.service.ISysProductService;
import com.ruoyi.common.core.text.Convert;

/**
 * 产品档案Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-24
 */
@Service
public class SysProductServiceImpl implements ISysProductService 
{
    @Autowired
    private SysProductMapper sysProductMapper;

    /**
     * 查询产品档案
     * 
     * @param productId 产品档案ID
     * @return 产品档案
     */
    @Override
    public SysProduct selectSysProductById(Long productId)
    {
        return sysProductMapper.selectSysProductById(productId);
    }

    /**
     * 查询产品档案列表
     * 
     * @param sysProduct 产品档案
     * @return 产品档案
     */
    @Override
    public List<SysProduct> selectSysProductList(SysProduct sysProduct)
    {
        return sysProductMapper.selectSysProductList(sysProduct);
    }

    /**
     * 新增产品档案
     * 
     * @param sysProduct 产品档案
     * @return 结果
     */
    @Override
    public int insertSysProduct(SysProduct sysProduct)
    {
        return sysProductMapper.insertSysProduct(sysProduct);
    }

    /**
     * 修改产品档案
     * 
     * @param sysProduct 产品档案
     * @return 结果
     */
    @Override
    public int updateSysProduct(SysProduct sysProduct)
    {
        return sysProductMapper.updateSysProduct(sysProduct);
    }

    /**
     * 删除产品档案对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysProductByIds(String ids)
    {
        return sysProductMapper.deleteSysProductByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品档案信息
     * 
     * @param productId 产品档案ID
     * @return 结果
     */
    @Override
    public int deleteSysProductById(Long productId)
    {
        return sysProductMapper.deleteSysProductById(productId);
    }

    @Override
    public List<SysProduct> selectSysProductAll(){
        return sysProductMapper.selectSysProductAll();
    }
}
