package com.main;

//import com.itextpdf.text.log.Logger;
//import com.itextpdf.text.log.LoggerFactory;

import java.io.File;
import java.net.URL;

/**
 * @author: ���
 * @date: 18-01-05
 * @version: 1.0.0
 * @description: ����PDF ������
 */
public class PdfUtils {
    //private static final Logger logger = LoggerFactory.getLogger(PdfUtils.class);

    /**
     * ����pdf�ļ�
     * @param htmlContent  ������pdf�� html����
     * @param file  ����pdf�ļ���ַ
     * @see  <a href="https://itextpdf.com/">https://itextpdf.com/</a>
     * @return true ���ɳɹ�    false ����ʧ��
     */
    public  boolean generatePdf(String htmlContent,File file)throws Exception{
       
        return true;
    }

    /**
     * Ӧ�ó���:
     * 1.��windows��,ʹ��Thread.currentThread()��ȡ·��ʱ,���ֿն��󣬵��²���ʹ��
     * 2.��linux��,ʹ��PdfUtils.class��ȡ·��Ϊnull,
     * ��ȡ����·��
     * @return ��������·��
     */
    private static String getFontPath(){
        String path="";
        // 1.
        ClassLoader classLoader= Thread.currentThread().getContextClassLoader();
        URL url = (classLoader==null)?null:classLoader.getResource("/");
        String threadCurrentPath = (url==null)?"":url.getPath();
        // 2. ����̻߳�ȡΪnull,��ʹ�õ�ǰPdfUtils.class����·��
        if(threadCurrentPath==null||"".equals(threadCurrentPath)){
            path = PdfUtils.class.getClass().getResource("/").getPath();
        }
        // 3.ƴ������·��
        StringBuffer stringBuffer = new StringBuffer(path);
        stringBuffer.append("/fonts/SIMKAI.TTF");
        path = stringBuffer.toString();
        return path;
    }
}