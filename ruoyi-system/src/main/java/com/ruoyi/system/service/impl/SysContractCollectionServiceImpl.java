package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.file.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysContractCollectionMapper;
import com.ruoyi.system.domain.SysContractCollection;
import com.ruoyi.system.service.ISysContractCollectionService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.web.multipart.MultipartFile;

/**
 * 收款合同Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-03
 */
@Service
public class SysContractCollectionServiceImpl implements ISysContractCollectionService 
{
    @Autowired
    private SysContractCollectionMapper sysContractCollectionMapper;

    /**
     * 查询收款合同
     * 
     * @param contractId 收款合同ID
     * @return 收款合同
     */
    @Override
    public SysContractCollection selectSysContractCollectionById(Long contractId)
    {
        return sysContractCollectionMapper.selectSysContractCollectionById(contractId);
    }

    /**
     * 查询收款合同列表
     * 
     * @param sysContractCollection 收款合同
     * @return 收款合同
     */
    @Override
    public List<SysContractCollection> selectSysContractCollectionList(SysContractCollection sysContractCollection)
    {
        return sysContractCollectionMapper.selectSysContractCollectionList(sysContractCollection);
    }

    /**
     * 新增收款合同
     * 
     * @param sysContractCollection 收款合同
     * @return 结果
     */
    @Override
    public int insertSysContractCollection(SysContractCollection sysContractCollection)
    {
        return sysContractCollectionMapper.insertSysContractCollection(sysContractCollection);
    }

    /**
     * 修改收款合同
     * 
     * @param sysContractCollection 收款合同
     * @return 结果
     */
    @Override
    public int updateSysContractCollection(SysContractCollection sysContractCollection)
    {
        return sysContractCollectionMapper.updateSysContractCollection(sysContractCollection);
    }

    /**
     * 删除收款合同对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysContractCollectionByIds(String ids)
    {
        return sysContractCollectionMapper.deleteSysContractCollectionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除收款合同信息
     * 
     * @param contractId 收款合同ID
     * @return 结果
     */
    @Override
    public int deleteSysContractCollectionById(Long contractId)
    {
        return sysContractCollectionMapper.deleteSysContractCollectionById(contractId);
    }

    @Override
    public String uploadFile(SysContractCollection SysContractCollection, MultipartFile file) {
        String uploadFileName = null;
        try {
            // 上传文件路径(可自定义)
            String filePath = "D:\\ruoyi\\uploadPath\\"+SysContractCollection.getContractNum()+"_"+SysContractCollection.getContractName();
            // 上传并返回新文件名称
            FileUploadUtils.upload(filePath, file);
            uploadFileName = filePath+"\\"+file.getOriginalFilename();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        return uploadFileName;
    }
}
