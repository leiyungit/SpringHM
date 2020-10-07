package com.itcast.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * fileupload1
 * fileupload2
 * 都已解决中文乱码问题
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     *  跨服务器上传文件
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileupload4")
    public String fileupload4(MultipartFile upload) throws Exception {
        System.out.println("跨服务器文件上传......");
        // 定义上传文件路径
        String path = "http://localhost:9090/uploads/";
        // 说明上传文件项
        // 获取上传文件名称
        String filename = upload.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        filename = uuid.toString().replace("-", "") + "_" + filename;

        // 创建客户端对象
        Client client = Client.create();
        // 和图片服务器进行连接
        WebResource webResource = client.resource(path + filename);
        //上传图片/文件
        webResource.put(upload.getBytes());
        client.destroy();
        return "success";
    }


    /**
     *
     * @param request
     * @param upload  <input type="file" name="upload"> 必须与控件的name属性值一样
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileupload3")
    public String fileupload3(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("springmvc文件上传......");
        request.setCharacterEncoding("utf-8");  //设置编码
        // 项目根目录下/uploads文件夹
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断文件是否存在
        File file = new File(path);
        if (!file.exists()) {
            // 创建该文件夹
            file.mkdirs();
        }
        // 说明上传文件项
        // 获取上传文件名称
        String filename = upload.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        filename = uuid.toString().replace("-", "") + "_" + filename;

        upload.transferTo(new File(path, filename));

        //然后对获取的FileItem执行如下转码方式
        //new String(item.getString("UTF-8"));
        // 完成文件上传
        //item.write(new File(path,filename));
        // 删除临时文件
        //item.delete();
        return "success";
    }


    @RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传......");
        // 项目根目录下/uploads文件夹
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断文件是否存在
        File file = new File(path);
        if(!file.exists()){
            // 创建该文件夹
            file.mkdirs();
        }
        // 解析request对象，获取上传的文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 设置编码
        upload.setHeaderEncoding("UTF-8");
        // 解析request
        List<FileItem> items = upload.parseRequest(request);

        for (FileItem item : items) {
            if(item.isFormField()){
                // 说明是普通表单项
            }else {
                // 说明上传文件项
                // 获取上传文件名称
                String filename = item.getName();
                UUID uuid = UUID.randomUUID();
                filename = uuid.toString().replace("-","") +"_"+filename;
                //然后对获取的FileItem执行如下转码方式
                new String(item.getString("UTF-8"));
                // 完成文件上传
                item.write(new File(path,filename));
                // 删除临时文件
                item.delete();
            }

        }

        return "success";
    }

    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request) throws Exception {
        System.out.println("文件上传......");
        // 获取数据时需要进行转码 item.getString("网站使用编码utf-8,GBK等");
        request.setCharacterEncoding("utf-8");  //设置编码
        // 项目根目录下/uploads文件夹
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断文件是否存在
        File file = new File(path);
        if(!file.exists()){
            // 创建该文件夹
            file.mkdirs();
        }
        // 解析request对象，获取上传的文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 解析request
        List<FileItem> items = upload.parseRequest(request);

        for (FileItem item : items) {
            if(item.isFormField()){
                // 说明是普通表单项
            }else {
                // 说明上传文件项
                // 获取上传文件名称
                String filename = item.getName();
                UUID uuid = UUID.randomUUID();
                filename = uuid.toString().replace("-","") +"_"+filename;
                //然后对获取的FileItem执行如下转码方式
                new String(item.getString("UTF-8"));
                // 完成文件上传
                //item.write(new File(path,filename));

                //手动写的
                OutputStream out = new FileOutputStream(new File(path,filename));
                InputStream in = item.getInputStream() ;
                int length = 0 ;
                byte [] buf = new byte[1024] ;
                System.out.println("获取上传文件的总共的容量："+item.getSize());
                // in.read(buf) 每次读到的数据存放在   buf 数组中
                while( (length = in.read(buf) ) != -1){
                    //在   buf 数组中 取出数据 写到 （输出流）磁盘上
                    out.write(buf, 0, length);
                }
                in.close();
                out.close();
                // 删除临时文件
                //item.delete();
            }

        }

        return "success";
    }
}
