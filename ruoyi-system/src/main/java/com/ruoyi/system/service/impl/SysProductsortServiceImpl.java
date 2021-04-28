package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysSutype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysProductsortMapper;
import com.ruoyi.system.domain.SysProductsort;
import com.ruoyi.system.service.ISysProductsortService;
import com.ruoyi.common.core.text.Convert;

/**
 * 产品分类Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-25
 */
@Service
public class SysProductsortServiceImpl implements ISysProductsortService 
{
    @Autowired
    private SysProductsortMapper sysProductsortMapper;

    /**
     * 查询产品分类
     * 
     * @param sortId 产品分类ID
     * @return 产品分类
     */
    @Override
    public SysProductsort selectSysProductsortById(Long sortId)
    {
        return sysProductsortMapper.selectSysProductsortById(sortId);
    }

    /**
     * 查询产品分类列表
     * 
     * @param sysProductsort 产品分类
     * @return 产品分类
     */
    @Override
    public List<SysProductsort> selectSysProductsortList(SysProductsort sysProductsort)
    {
        return sysProductsortMapper.selectSysProductsortList(sysProductsort);
    }

    /**
     * 新增产品分类
     * 
     * @param sysProductsort 产品分类
     * @return 结果
     */
    @Override
    public int insertSysProductsort(SysProductsort sysProductsort)
    {
        SysProductsort info = sysProductsortMapper.selectSysProductsortById(sysProductsort.getParentId());
        sysProductsort.setAncestor(info.getAncestor() + "," + sysProductsort.getParentId());
        return sysProductsortMapper.insertSysProductsort(sysProductsort);
        //return sysProductsortMapper.insertSysProductsort(sysProductsort);
    }

    /**
     * 修改产品分类
     * 
     * @param sysProductsort 产品分类
     * @return 结果
     */
    @Override
    public int updateSysProductsort(SysProductsort sysProductsort)
    {
        SysProductsort newParentProductsort = sysProductsortMapper.selectSysProductsortById(sysProductsort.getParentId());
        SysProductsort oldProductsort = selectSysProductsortById(sysProductsort.getSortId());
        if (StringUtils.isNotNull(newParentProductsort) && StringUtils.isNotNull(oldProductsort))
        {
            String newAncestors = newParentProductsort.getAncestor() + "," + newParentProductsort.getSortId();
            String oldAncestors = oldProductsort.getAncestor();
            sysProductsort.setAncestor(newAncestors);
            updateProductsortChildren(sysProductsort.getSortId(), newAncestors, oldAncestors);
        }
        int result = sysProductsortMapper.updateSysProductsort(sysProductsort);

        return result;
        //return sysProductsortMapper.updateSysProductsort(sysProductsort);
    }
    public void updateProductsortChildren(Long sortId, String newAncestors, String oldAncestors)
    {
        List<SysProductsort> children = sysProductsortMapper.selectChildrenProductsortById(sortId);
        for (SysProductsort child : children)
        {
            child.setAncestors(child.getAncestor().replace(oldAncestors, newAncestors));
        }
        if (children.size() > 0)
        {
            sysProductsortMapper.updateProductsortChildren(children);
        }
    }

    /**
     * 删除产品分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysProductsortByIds(String ids)
    {
        return sysProductsortMapper.deleteSysProductsortByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品分类信息
     * 
     * @param sortId 产品分类ID
     * @return 结果
     */
    @Override
    public int deleteSysProductsortById(Long sortId)
    {
        return sysProductsortMapper.deleteSysProductsortById(sortId);
    }

    /**
     * 查询产品分类树列表
     * 
     * @return 所有产品分类信息
     */
    @Override
    public List<Ztree> selectSysProductsortTree()
    {
        List<SysProductsort> sysProductsortList = sysProductsortMapper.selectSysProductsortList(new SysProductsort());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (SysProductsort sysProductsort : sysProductsortList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(sysProductsort.getSortId());
            ztree.setpId(sysProductsort.getParentId());
            ztree.setName(sysProductsort.getSortName());
            ztree.setTitle(sysProductsort.getSortName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
