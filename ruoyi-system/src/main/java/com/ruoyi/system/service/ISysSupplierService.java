package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysSupplier;

/**
 * 供应商档案Service接口
 * 
 * @author ruoyi
 * @date 2021-04-24
 */
public interface ISysSupplierService 
{
    /**
     * 查询供应商档案
     * 
     * @param supplierId 供应商档案ID
     * @return 供应商档案
     */
    public SysSupplier selectSysSupplierById(Long supplierId);

    /**
     * 查询供应商档案列表
     * 
     * @param sysSupplier 供应商档案
     * @return 供应商档案集合
     */
    public List<SysSupplier> selectSysSupplierList(SysSupplier sysSupplier);

    /**
     * 新增供应商档案
     * 
     * @param sysSupplier 供应商档案
     * @return 结果
     */
    public int insertSysSupplier(SysSupplier sysSupplier);

    /**
     * 修改供应商档案
     * 
     * @param sysSupplier 供应商档案
     * @return 结果
     */
    public int updateSysSupplier(SysSupplier sysSupplier);

    /**
     * 批量删除供应商档案
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysSupplierByIds(String ids);

    /**
     * 删除供应商档案信息
     * 
     * @param supplierId 供应商档案ID
     * @return 结果
     */
    public int deleteSysSupplierById(Long supplierId);
}
