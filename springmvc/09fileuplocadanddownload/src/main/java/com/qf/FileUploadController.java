package com.qf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf
 * @Description:
 * @Date 2022/5/23 20:26
 */
@Controller
public class FileUploadController {

    @RequestMapping("/fileuplading")
    public String fileUpload(MultipartFile pic, String name, HttpServletRequest request) {


        //获取到文件的名字
        String originalFilename = pic.getOriginalFilename();
        String realPath = request.getServletContext().getRealPath("/pic");//获取项目运行期间的一个目录,这个目录在项目中
        System.err.println(realPath);
        try {
            pic.transferTo(new File(realPath+ File.separator+originalFilename)); //保存到对应的文件
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "success";
    }
}
