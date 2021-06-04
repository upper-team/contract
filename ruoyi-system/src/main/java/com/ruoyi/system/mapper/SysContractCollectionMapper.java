package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysContractCollection;

/**
 * 收款合同Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-03
 */
public interface SysContractCollectionMapper 
{
    /**
     * 查询收款合同
     * 
     * @param contractId 收款合同ID
     * @return 收款合同
     */
    public SysContractCollection selectSysContractCollectionById(Long contractId);

    /**
     * 查询收款合同列表
     * 
     * @param sysContractCollection 收款合同
     * @return 收款合同集合
     */
    public List<SysContractCollection> selectSysContractCollectionList(SysContractCollection sysContractCollection);

    /**
     * 新增收款合同
     * 
     * @param sysContractCollection 收款合同
     * @return 结果
     */
    public int insertSysContractCollection(SysContractCollection sysContractCollection);

    /**
     * 修改收款合同
     * 
     * @param sysContractCollection 收款合同
     * @return 结果
     */
    public int updateSysContractCollection(SysContractCollection sysContractCollection);

    /**
     * 删除收款合同
     * 
     * @param contractId 收款合同ID
     * @return 结果
     */
    public int deleteSysContractCollectionById(Long contractId);

    /**
     * 批量删除收款合同
     * 
     * @param contractIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysContractCollectionByIds(String[] contractIds);
}
