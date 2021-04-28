package com.ruoyi.web.controller;

import java.util.List;
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
import com.ruoyi.system.domain.SysProductsort;
import com.ruoyi.system.service.ISysProductsortService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 产品分类Controller
 * 
 * @author ruoyi
 * @date 2021-04-25
 */
@Controller
@RequestMapping("/system/productsort")
public class SysProductsortController extends BaseController
{
    private String prefix = "system/productsort";

    @Autowired
    private ISysProductsortService sysProductsortService;

    @RequiresPermissions("system:productsort:view")
    @GetMapping()
    public String productsort()
    {
        return prefix + "/productsort";
    }

    /**
     * 查询产品分类树列表
     */
    @RequiresPermissions("system:productsort:list")
    @PostMapping("/list")
    @ResponseBody
    public List<SysProductsort> list(SysProductsort sysProductsort)
    {
        List<SysProductsort> list = sysProductsortService.selectSysProductsortList(sysProductsort);
        return list;
    }

    /**
     * 导出产品分类列表
     */
    @RequiresPermissions("system:productsort:export")
    @Log(title = "产品分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysProductsort sysProductsort)
    {
        List<SysProductsort> list = sysProductsortService.selectSysProductsortList(sysProductsort);
        ExcelUtil<SysProductsort> util = new ExcelUtil<SysProductsort>(SysProductsort.class);
        return util.exportExcel(list, "productsort");
    }

    /**
     * 新增产品分类
     */
    @GetMapping(value = { "/add/{sortId}", "/add/" })
    public String add(@PathVariable(value = "sortId", required = false) Long sortId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(sortId))
        {
            mmap.put("sysProductsort", sysProductsortService.selectSysProductsortById(sortId));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存产品分类
     */
    @RequiresPermissions("system:productsort:add")
    @Log(title = "产品分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysProductsort sysProductsort)
    {
        return toAjax(sysProductsortService.insertSysProductsort(sysProductsort));
    }

    /**
     * 修改产品分类
     */
    @GetMapping("/edit/{sortId}")
    public String edit(@PathVariable("sortId") Long sortId, ModelMap mmap)
    {
        SysProductsort sysProductsort = sysProductsortService.selectSysProductsortById(sortId);
        mmap.put("sysProductsort", sysProductsort);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品分类
     */
    @RequiresPermissions("system:productsort:edit")
    @Log(title = "产品分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysProductsort sysProductsort)
    {
        return toAjax(sysProductsortService.updateSysProductsort(sysProductsort));
    }

    /**
     * 删除
     */
    @RequiresPermissions("system:productsort:remove")
    @Log(title = "产品分类", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{sortId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("sortId") Long sortId)
    {
        return toAjax(sysProductsortService.deleteSysProductsortById(sortId));
    }

    /**
     * 选择产品分类树
     */
    @GetMapping(value = { "/selectProductsortTree/{sortId}", "/selectProductsortTree/" })
    public String selectProductsortTree(@PathVariable(value = "sortId", required = false) Long sortId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(sortId))
        {
            mmap.put("sysProductsort", sysProductsortService.selectSysProductsortById(sortId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载产品分类树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = sysProductsortService.selectSysProductsortTree();
        return ztrees;
    }
}
