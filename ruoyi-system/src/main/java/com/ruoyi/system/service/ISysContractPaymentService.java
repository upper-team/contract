package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.SysContractCollection;
import com.ruoyi.system.domain.SysContractPayment;
import org.springframework.web.multipart.MultipartFile;
/**
 * 付款合同Service接口
 * 
 * @author ruoyi
 * @date 2021-05-09
 */
public interface ISysContractPaymentService 
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
     * 批量删除付款合同
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysContractPaymentByIds(String ids);

    /**
     * 删除付款合同信息
     * 
     * @param contractId 付款合同ID
     * @return 结果
     */
    public int deleteSysContractPaymentById(Long contractId);

    public String uploadFile(SysContractPayment sysContractPayment, MultipartFile file);
}
