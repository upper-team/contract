package com.ruoyi.system.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.utils.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysSutypeMapper;
import com.ruoyi.system.domain.SysSutype;
import com.ruoyi.system.service.ISysSutypeService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 供应商分类Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
@Service
public class SysSutypeServiceImpl implements ISysSutypeService 
{
    @Autowired
    private SysSutypeMapper sysSutypeMapper;

    /**
     * 查询供应商分类
     * 
     * @param sutypeId 供应商分类ID
     * @return 供应商分类
     */
    @Override
    public SysSutype selectSysSutypeById(Long sutypeId)
    {
        return sysSutypeMapper.selectSysSutypeById(sutypeId);
    }

    /**
     * 查询供应商分类列表
     * 
     * @param sysSutype 供应商分类
     * @return 供应商分类
     */
    @Override
    public List<SysSutype> selectSysSutypeList(SysSutype sysSutype)
    {
        return sysSutypeMapper.selectSysSutypeList(sysSutype);
    }


    @Override
    public List<Ztree> selectSutypeTreeExcludeChild(SysSutype type)
    {
        Long typeId = type.getSutypeId();
        List<SysSutype> typeList = sysSutypeMapper.selectSysSutypeList(type);
        Iterator<SysSutype> it = typeList.iterator();
        while (it.hasNext())
        {
            SysSutype d = (SysSutype) it.next();
            if (d.getSutypeId().intValue() == typeId
                    || ArrayUtils.contains(StringUtils.split(d.getAncestor(), ","), typeId + ""))
            {
                it.remove();
            }
        }
        List<Ztree> ztrees = selectSysSutypeTree();
        return ztrees;
    }



    @Override
    @Transactional
    public int updateSutype(SysSutype sutype)
    {
        SysSutype newParentDept = sysSutypeMapper.selectSysSutypeById(sutype.getParentId());
        SysSutype oldDept = selectSysSutypeById(sutype.getSutypeId());
        if (StringUtils.isNotNull(newParentDept) && StringUtils.isNotNull(oldDept))
        {
            String newAncestors = newParentDept.getAncestor() + "," + newParentDept.getSutypeId();
            String oldAncestors = oldDept.getAncestor();
            sutype.setAncestors(newAncestors);
            updateSutypeChildren(sutype.getSutypeId(), newAncestors, oldAncestors);
        }
        int result = sysSutypeMapper.updateSysSutype(sutype);

        return result;
    }









    /**
     * 新增供应商分类
     * 
     * @param sysSutype 供应商分类
     * @return 结果
     */
    @Override
    public int insertSysSutype(SysSutype sysSutype)
    {
        SysSutype info = sysSutypeMapper.selectSysSutypeById(sysSutype.getParentId());
        sysSutype.setAncestor(info.getAncestor() + "," + sysSutype.getParentId());
        return sysSutypeMapper.insertSysSutype(sysSutype);
    }

    /**
     * 修改供应商分类
     * 
     * @param sysSutype 供应商分类
     * @return 结果
     */
    @Override
    public int updateSysSutype(SysSutype sysSutype)
    {
        SysSutype newParentSutype = sysSutypeMapper.selectSysSutypeById(sysSutype.getParentId());
        SysSutype oldSutype = selectSysSutypeById(sysSutype.getSutypeId());
        if (StringUtils.isNotNull(newParentSutype) && StringUtils.isNotNull(oldSutype))
        {
            String newAncestors = newParentSutype.getAncestor() + "," + newParentSutype.getSutypeId();
            String oldAncestors = oldSutype.getAncestor();
            sysSutype.setAncestor(newAncestors);
            updateSutypeChildren(sysSutype.getSutypeId(), newAncestors, oldAncestors);
        }

        int result = sysSutypeMapper.updateSysSutype(sysSutype);

        return result;
    }



    public void updateSutypeChildren(Long sutypeId, String newAncestors, String oldAncestors)
    {
        List<SysSutype> children = sysSutypeMapper.selectChildrenSutypeById(sutypeId);
        for (SysSutype child : children)
        {
            child.setAncestors(child.getAncestor().replace(oldAncestors, newAncestors));
        }
        if (children.size() > 0)
        {
            sysSutypeMapper.updateSutypeChildren(children);
        }
    }


    /**
     * 删除供应商分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysSutypeByIds(String ids)
    {
        return sysSutypeMapper.deleteSysSutypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除供应商分类信息
     * 
     * @param sutypeId 供应商分类ID
     * @return 结果
     */
    @Override
    public int deleteSysSutypeById(Long sutypeId)
    {
        return sysSutypeMapper.deleteSysSutypeById(sutypeId);
    }

    /**
     * 查询供应商分类树列表
     * 
     * @return 所有供应商分类信息
     */
    @Override
    public List<Ztree> selectSysSutypeTree()
    {
        List<SysSutype> sysSutypeList = sysSutypeMapper.selectSysSutypeList(new SysSutype());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (SysSutype sysSutype : sysSutypeList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(sysSutype.getSutypeId());
            ztree.setpId(sysSutype.getParentId());
            ztree.setName(sysSutype.getSutypeName());
            ztree.setTitle(sysSutype.getSutypeName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
