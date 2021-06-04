package com.ruoyi.web.controller;

import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.uuid.UUID;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传&下载
 *
 * @author lxy
 */
@Controller
@RequestMapping("/system/file")
public class FileController {

    private String prefix = "system/file";

    @Autowired
    private ServerConfig serverConfig;

    @GetMapping("/fileDemo")
    public String fileDemo() {
        return prefix + "/fileDemo";
    }

    @GetMapping("/file")
    public String file() {
        return prefix + "/file";
    }

    @RequiresPermissions("system:file:upload")
    @PostMapping("/upload")
    @ResponseBody
    public AjaxResult uploadFile(MultipartFile file) throws Exception {
        try {
            // 上传文件路径(可自定义)
            String filePath = "D:\\ruoyi\\uploadPath\\"+ UUID.randomUUID().toString();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    @RequiresPermissions("system:file:download")
    @PostMapping("/download")
    @ResponseBody
    public AjaxResult download() throws Exception {
        // 下载本地文件
        String file = "ruoyi\\uploadPath\\37ba1026-5dee-44ed-a79a-9cca2177fe31\\10.pdf";
        return AjaxResult.success(file);
    }

}
