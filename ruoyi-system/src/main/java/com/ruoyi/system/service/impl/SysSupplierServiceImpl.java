package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.SysClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysSupplierMapper;
import com.ruoyi.system.domain.SysSupplier;
import com.ruoyi.system.service.ISysSupplierService;
import com.ruoyi.common.core.text.Convert;

/**
 * 供应商档案Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-24
 */
@Service
public class SysSupplierServiceImpl implements ISysSupplierService 
{
    @Autowired
    private SysSupplierMapper sysSupplierMapper;

    /**
     * 查询供应商档案
     * 
     * @param supplierId 供应商档案ID
     * @return 供应商档案
     */
    @Override
    public SysSupplier selectSysSupplierById(Long supplierId)
    {
        return sysSupplierMapper.selectSysSupplierById(supplierId);
    }

    /**
     * 查询供应商档案列表
     * 
     * @param sysSupplier 供应商档案
     * @return 供应商档案
     */
    @Override
    public List<SysSupplier> selectSysSupplierList(SysSupplier sysSupplier)
    {
        return sysSupplierMapper.selectSysSupplierList(sysSupplier);
    }

    /**
     * 新增供应商档案
     * 
     * @param sysSupplier 供应商档案
     * @return 结果
     */
    @Override
    public int insertSysSupplier(SysSupplier sysSupplier)
    {
        return sysSupplierMapper.insertSysSupplier(sysSupplier);
    }

    /**
     * 修改供应商档案
     * 
     * @param sysSupplier 供应商档案
     * @return 结果
     */
    @Override
    public int updateSysSupplier(SysSupplier sysSupplier)
    {
        return sysSupplierMapper.updateSysSupplier(sysSupplier);
    }

    /**
     * 删除供应商档案对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysSupplierByIds(String ids)
    {
        return sysSupplierMapper.deleteSysSupplierByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除供应商档案信息
     * 
     * @param supplierId 供应商档案ID
     * @return 结果
     */
    @Override
    public int deleteSysSupplierById(Long supplierId)
    {
        return sysSupplierMapper.deleteSysSupplierById(supplierId);
    }

    @Override
    public List<SysSupplier> selectSysSupplierAll(){
        return sysSupplierMapper.selectSysSupplierAll();
    }

}
