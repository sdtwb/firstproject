package com.main;

//import com.itextpdf.text.log.Logger;
//import com.itextpdf.text.log.LoggerFactory;

import java.io.File;
import java.net.URL;

/**
 * @author: 鞠骞
 * @date: 18-01-05
 * @version: 1.0.0
 * @description: 生成PDF 工具类
 */
public class PdfUtils {
    //private static final Logger logger = LoggerFactory.getLogger(PdfUtils.class);

    /**
     * 生成pdf文件
     * @param htmlContent  待生成pdf的 html内容
     * @param file  生成pdf文件地址
     * @see  <a href="https://itextpdf.com/">https://itextpdf.com/</a>
     * @return true 生成成功    false 生成失败
     */
    public  boolean generatePdf(String htmlContent,File file)throws Exception{
       
        return true;
    }

    /**
     * 应用场景:
     * 1.在windows下,使用Thread.currentThread()获取路径时,出现空对象，导致不能使用
     * 2.在linux下,使用PdfUtils.class获取路径为null,
     * 获取字体路径
     * @return 返回字体路径
     */
    private static String getFontPath(){
        String path="";
        // 1.
        ClassLoader classLoader= Thread.currentThread().getContextClassLoader();
        URL url = (classLoader==null)?null:classLoader.getResource("/");
        String threadCurrentPath = (url==null)?"":url.getPath();
        // 2. 如果线程获取为null,则使用当前PdfUtils.class加载路径
        if(threadCurrentPath==null||"".equals(threadCurrentPath)){
            path = PdfUtils.class.getClass().getResource("/").getPath();
        }
        // 3.拼接字体路径
        StringBuffer stringBuffer = new StringBuffer(path);
        stringBuffer.append("/fonts/SIMKAI.TTF");
        path = stringBuffer.toString();
        return path;
    }
}