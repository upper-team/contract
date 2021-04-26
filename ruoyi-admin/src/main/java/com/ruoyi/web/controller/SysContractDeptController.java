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
import com.ruoyi.system.domain.SysContractDept;
import com.ruoyi.system.service.ISysContractDeptService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 合同分类Controller
 * 
 * @author ruoyi
 * @date 2021-04-18
 */
@Controller
@RequestMapping("/system/contract_dept")
public class SysContractDeptController extends BaseController
{
    private String prefix = "system/contract_dept";

    @Autowired
    private ISysContractDeptService sysContractDeptService;

    @RequiresPermissions("system:contract_dept:view")
    @GetMapping()
    public String contract_dept()
    {
        return prefix + "/contract_dept";
    }

    /**
     * 查询合同分类树列表
     */
    @RequiresPermissions("system:contract_dept:list")
    @PostMapping("/list")
    @ResponseBody
    public List<SysContractDept> list(SysContractDept sysContractDept)
    {
        List<SysContractDept> list = sysContractDeptService.selectSysContractDeptList(sysContractDept);
        return list;
    }

    /**
     * 导出合同分类列表
     */
    @RequiresPermissions("system:contract_dept:export")
    @Log(title = "合同分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysContractDept sysContractDept)
    {
        List<SysContractDept> list = sysContractDeptService.selectSysContractDeptList(sysContractDept);
        ExcelUtil<SysContractDept> util = new ExcelUtil<SysContractDept>(SysContractDept.class);
        return util.exportExcel(list, "contract_dept");
    }

    /**
     * 新增合同分类
     */
    @GetMapping(value = { "/add/{contractId}", "/add/" })
    public String add(@PathVariable(value = "contractId", required = false) Long contractId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(contractId))
        {
            mmap.put("sysContractDept", sysContractDeptService.selectSysContractDeptById(contractId));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存合同分类
     */
    @RequiresPermissions("system:contract_dept:add")
    @Log(title = "合同分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysContractDept sysContractDept)
    {
        return toAjax(sysContractDeptService.insertSysContractDept(sysContractDept));
    }

    /**
     * 修改合同分类
     */
    @GetMapping("/edit/{contractId}")
    public String edit(@PathVariable("contractId") Long contractId, ModelMap mmap)
    {
        SysContractDept sysContractDept = sysContractDeptService.selectSysContractDeptById(contractId);
        mmap.put("sysContractDept", sysContractDept);
        return prefix + "/edit";
    }

    /**
     * 修改保存合同分类
     */
    @RequiresPermissions("system:contract_dept:edit")
    @Log(title = "合同分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysContractDept sysContractDept)
    {
        return toAjax(sysContractDeptService.updateSysContractDept(sysContractDept));
    }

    /**
     * 删除
     */
    @RequiresPermissions("system:contract_dept:remove")
    @Log(title = "合同分类", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{contractId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("contractId") Long contractId)
    {
        return toAjax(sysContractDeptService.deleteSysContractDeptById(contractId));
    }

    /**
     * 选择合同分类树
     */
    @GetMapping(value = { "/selectContract_deptTree/{contractId}", "/selectContract_deptTree/" })
    public String selectContract_deptTree(@PathVariable(value = "contractId", required = false) Long contractId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(contractId))
        {
            mmap.put("sysContractDept", sysContractDeptService.selectSysContractDeptById(contractId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载合同分类树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = sysContractDeptService.selectSysContractDeptTree();
        return ztrees;
    }
}
