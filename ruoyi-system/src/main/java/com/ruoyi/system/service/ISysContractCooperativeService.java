package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysContractCooperative;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 合作合同Service接口
 * 
 * @author ruoyi
 * @date 2021-05-04
 */
public interface ISysContractCooperativeService 
{
    /**
     * 查询合作合同
     * 
     * @param contractId 合作合同ID
     * @return 合作合同
     */
    public SysContractCooperative selectSysContractCooperativeById(Long contractId);

    /**
     * 查询合作合同列表
     * 
     * @param sysContractCooperative 合作合同
     * @return 合作合同集合
     */
    public List<SysContractCooperative> selectSysContractCooperativeList(SysContractCooperative sysContractCooperative);

    /**
     * 新增合作合同
     * 
     * @param sysContractCooperative 合作合同
     * @return 结果
     */
    public int insertSysContractCooperative(SysContractCooperative sysContractCooperative);

    /**
     * 修改合作合同
     * 
     * @param sysContractCooperative 合作合同
     * @return 结果
     */
    public int updateSysContractCooperative(SysContractCooperative sysContractCooperative);

    /**
     * 批量删除合作合同
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysContractCooperativeByIds(String ids);

    /**
     * 删除合作合同信息
     * 
     * @param contractId 合作合同ID
     * @return 结果
     */
    public int deleteSysContractCooperativeById(Long contractId);

    public String uploadFile(SysContractCooperative SysContractCollection, MultipartFile file);

}
