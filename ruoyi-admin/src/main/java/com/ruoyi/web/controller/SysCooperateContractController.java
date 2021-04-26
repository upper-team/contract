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
import com.ruoyi.system.domain.SysCooperateContract;
import com.ruoyi.system.service.ISysCooperateContractService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 合作合同管理Controller
 * 
 * @author ruoyi
 * @date 2021-04-19
 */
@Controller
@RequestMapping("/system/cooperate_contract")
public class SysCooperateContractController extends BaseController
{
    private String prefix = "system/cooperate_contract";

    @Autowired
    private ISysCooperateContractService sysCooperateContractService;

    @RequiresPermissions("system:cooperate_contract:view")
    @GetMapping()
    public String cooperate_contract()
    {
        return prefix + "/cooperate_contract";
    }

    /**
     * 查询合作合同管理列表
     */
    @RequiresPermissions("system:cooperate_contract:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysCooperateContract sysCooperateContract)
    {
        startPage();
        List<SysCooperateContract> list = sysCooperateContractService.selectSysCooperateContractList(sysCooperateContract);
        return getDataTable(list);
    }

    /**
     * 导出合作合同管理列表
     */
    @RequiresPermissions("system:cooperate_contract:export")
    @Log(title = "合作合同管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysCooperateContract sysCooperateContract)
    {
        List<SysCooperateContract> list = sysCooperateContractService.selectSysCooperateContractList(sysCooperateContract);
        ExcelUtil<SysCooperateContract> util = new ExcelUtil<SysCooperateContract>(SysCooperateContract.class);
        return util.exportExcel(list, "cooperate_contract");
    }

    /**
     * 新增合作合同管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存合作合同管理
     */
    @RequiresPermissions("system:cooperate_contract:add")
    @Log(title = "合作合同管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysCooperateContract sysCooperateContract)
    {
        return toAjax(sysCooperateContractService.insertSysCooperateContract(sysCooperateContract));
    }

    /**
     * 修改合作合同管理
     */
    @GetMapping("/edit/{contractId}")
    public String edit(@PathVariable("contractId") Long contractId, ModelMap mmap)
    {
        SysCooperateContract sysCooperateContract = sysCooperateContractService.selectSysCooperateContractById(contractId);
        mmap.put("sysCooperateContract", sysCooperateContract);
        return prefix + "/edit";
    }

    /**
     * 修改保存合作合同管理
     */
    @RequiresPermissions("system:cooperate_contract:edit")
    @Log(title = "合作合同管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysCooperateContract sysCooperateContract)
    {
        return toAjax(sysCooperateContractService.updateSysCooperateContract(sysCooperateContract));
    }

    /**
     * 删除合作合同管理
     */
    @RequiresPermissions("system:cooperate_contract:remove")
    @Log(title = "合作合同管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysCooperateContractService.deleteSysCooperateContractByIds(ids));
    }
}
