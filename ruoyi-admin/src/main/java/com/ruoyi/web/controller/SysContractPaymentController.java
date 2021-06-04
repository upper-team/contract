package com.ruoyi.web.controller;

import java.util.List;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.*;
import com.ruoyi.common.utils.file.FileUploadUtils;
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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;
/**
 * 付款合同Controller
 * 
 * @author ruoyi
 * @date 2021-05-09
 */
@Controller
@RequestMapping("/system/payment")
public class SysContractPaymentController extends BaseController
{
    private String prefix = "system/payment";

    @Autowired
    private ISysSupplierService supplierService;

    @Autowired
    private ISysProductService productService;

    @Autowired
    private ISysEmployeeService employeeService;

    @Autowired
    private ISysContractPaymentService sysContractPaymentService;

    @RequiresPermissions("system:payment:view")
    @GetMapping()
    public String payment()
    {
        return prefix + "/payment";
    }

    /**
     * 查询付款合同列表
     */
    @RequiresPermissions("system:payment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysContractPayment sysContractPayment)
    {
        startPage();
        List<SysContractPayment> list = sysContractPaymentService.selectSysContractPaymentList(sysContractPayment);
        return getDataTable(list);
    }

    /**
     * 导出付款合同列表
     */
    @RequiresPermissions("system:payment:export")
    @Log(title = "付款合同", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysContractPayment sysContractPayment)
    {
        List<SysContractPayment> list = sysContractPaymentService.selectSysContractPaymentList(sysContractPayment);
        ExcelUtil<SysContractPayment> util = new ExcelUtil<SysContractPayment>(SysContractPayment.class);
        return util.exportExcel(list, "payment");
    }

    /**
     * 新增付款合同
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        List<SysProduct> productList = productService.selectSysProductAll();
        List<SysSupplier> supplierList = supplierService.selectSysSupplierAll();
        List<SysEmployee> employeeList = employeeService.selectSysEmployeeAll();
        mmap.put("suppliers",supplierList);
        mmap.put("products", productList);
        mmap.put("employees", employeeList);
        return prefix + "/add";
    }

    /**
     * 新增保存付款合同
     */
    @RequiresPermissions("system:payment:add")
    @Log(title = "付款合同", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysContractPayment sysContractPayment,MultipartFile file)
    {
        String scanningCopy = sysContractPaymentService.uploadFile(sysContractPayment, file);
        sysContractPayment.setScanningCopy(scanningCopy);
        return toAjax(sysContractPaymentService.insertSysContractPayment(sysContractPayment));
    }

    /**
     * 修改付款合同
     */
    @GetMapping("/edit/{contractId}")
    public String edit(@PathVariable("contractId") Long contractId, ModelMap mmap)
    {
        SysContractPayment sysContractPayment = sysContractPaymentService.selectSysContractPaymentById(contractId);
        mmap.put("sysContractPayment", sysContractPayment);
        List<SysProduct> productList = productService.selectSysProductAll();
        List<SysSupplier> supplierList = supplierService.selectSysSupplierAll();
        List<SysEmployee> employeeList = employeeService.selectSysEmployeeAll();
        mmap.put("suppliers", supplierList);
        mmap.put("products", productList);
        mmap.put("employees", employeeList);
        return prefix + "/edit";
    }

    /**
     * 修改保存付款合同
     */
    @RequiresPermissions("system:payment:edit")
    @Log(title = "付款合同", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysContractPayment sysContractPayment)
    {
        return toAjax(sysContractPaymentService.updateSysContractPayment(sysContractPayment));
    }

    /**
     * 删除付款合同
     */
    @RequiresPermissions("system:payment:remove")
    @Log(title = "付款合同", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysContractPaymentService.deleteSysContractPaymentByIds(ids));
    }

    /**
     * 下载pdf
     */
    @RequiresPermissions("system:contract_collection:downPDF")
    @PostMapping("/downPDF")
    @ResponseBody
    public AjaxResult downPDF(String ids){
        SysContractPayment sysContractPayment = new SysContractPayment();
       sysContractPayment.setIdArr(Convert.toStrArray(ids));
        List<SysContractPayment> SysContractPaymentList = sysContractPaymentService.selectSysContractPaymentList(sysContractPayment);
        for(SysContractPayment sysContractPayment1  : SysContractPaymentList){
            String pdfUrl = sysContractPayment1.getScanningCopy();//拿到pdf存储路径
            return AjaxResult.success(pdfUrl);
        }
        return AjaxResult.success("下载完毕");
    }
}
