package com.ruoyi.web.controller;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDept;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysSutype;
import com.ruoyi.system.service.ISysSutypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 供应商分类Controller
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
@Controller
@RequestMapping("/system/sutype")
public class SysSutypeController extends BaseController
{
    private String prefix = "system/sutype";

    @Autowired
    private ISysSutypeService sysSutypeService;

    @RequiresPermissions("system:sutype:view")
    @GetMapping()
    public String sutype()
    {
        return prefix + "/sutype";
    }

    /**
     * 查询供应商分类树列表
     */
    @RequiresPermissions("system:sutype:list")
    @PostMapping("/list")
    @ResponseBody
    public List<SysSutype> list(SysSutype sysSutype)
    {
        List<SysSutype> list = sysSutypeService.selectSysSutypeList(sysSutype);
        return list;
    }

    /**
     * 导出供应商分类列表
     */
    @RequiresPermissions("system:sutype:export")
    @Log(title = "供应商分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysSutype sysSutype)
    {
        List<SysSutype> list = sysSutypeService.selectSysSutypeList(sysSutype);
        ExcelUtil<SysSutype> util = new ExcelUtil<SysSutype>(SysSutype.class);
        return util.exportExcel(list, "sutype");
    }

    /**
     * 新增供应商分类
     */
    @GetMapping(value = { "/add/{sutypeId}", "/add/" })
    public String add(@PathVariable(value = "sutypeId", required = false) Long sutypeId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(sutypeId))
        {
            mmap.put("sysSutype", sysSutypeService.selectSysSutypeById(sutypeId));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存供应商分类
     */
    @RequiresPermissions("system:sutype:add")
    @Log(title = "供应商分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysSutype sysSutype)
    {
        return toAjax(sysSutypeService.insertSysSutype(sysSutype));
    }

    /**
     * 修改供应商分类
     */
    @GetMapping("/edit/{sutypeId}")
    public String edit(@PathVariable("sutypeId") Long sutypeId, ModelMap mmap)
    {
        SysSutype sysSutype = sysSutypeService.selectSysSutypeById(sutypeId);
        mmap.put("sysSutype", sysSutype);
        return prefix + "/edit";
    }

    /**
     * 修改保存供应商分类
     */
    @RequiresPermissions("system:sutype:edit")
    @Log(title = "供应商分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysSutype sysSutype)
    {
        return toAjax(sysSutypeService.updateSysSutype(sysSutype));
    }

    /**
     * 删除
     */
    @RequiresPermissions("system:sutype:remove")
    @Log(title = "供应商分类", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{sutypeId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("sutypeId") Long sutypeId)
    {
        return toAjax(sysSutypeService.deleteSysSutypeById(sutypeId));
    }

    /**
     * 选择供应商分类树
     */
    @GetMapping(value = { "/selectSutypeTree/{sutypeId}", "/selectSutypeTree/" })
    public String selectSutypeTree(@PathVariable(value = "sutypeId", required = false) Long sutypeId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(sutypeId))
        {
            mmap.put("sysSutype", sysSutypeService.selectSysSutypeById(sutypeId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载供应商分类树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = sysSutypeService.selectSysSutypeTree();
        return ztrees;
    }
}
