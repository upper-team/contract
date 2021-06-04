package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysContractPayment;

/**
 * 付款合同Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-09
 */
public interface SysContractPaymentMapper 
{
    /**
     * 查询付款合同
     * 
     * @param contractId 付款合同ID
     * @return 付款合同
     */
    public SysContractPayment selectSysContractPaymentById(Long contractId);

    /**
     * 查询付款合同列表
     * 
     * @param sysContractPayment 付款合同
     * @return 付款合同集合
     */
    public List<SysContractPayment> selectSysContractPaymentList(SysContractPayment sysContractPayment);

    /**
     * 新增付款合同
     * 
     * @param sysContractPayment 付款合同
     * @return 结果
     */
    public int insertSysContractPayment(SysContractPayment sysContractPayment);

    /**
     * 修改付款合同
     * 
     * @param sysContractPayment 付款合同
     * @return 结果
     */
    public int updateSysContractPayment(SysContractPayment sysContractPayment);

    /**
     * 删除付款合同
     * 
     * @param contractId 付款合同ID
     * @return 结果
     */
    public int deleteSysContractPaymentById(Long contractId);

    /**
     * 批量删除付款合同
     * 
     * @param contractIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysContractPaymentByIds(String[] contractIds);
}
