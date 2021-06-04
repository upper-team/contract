package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysContractCollection;
import org.springframework.web.multipart.MultipartFile;

/**
 * 收款合同Service接口
 * 
 * @author ruoyi
 * @date 2021-05-03
 */
public interface ISysContractCollectionService 
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
     * 批量删除收款合同
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysContractCollectionByIds(String ids);

    /**
     * 删除收款合同信息
     * 
     * @param contractId 收款合同ID
     * @return 结果
     */
    public int deleteSysContractCollectionById(Long contractId);

    public String uploadFile(SysContractCollection SysContractCollection, MultipartFile file);
}
