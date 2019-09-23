package demo.plagdetect.calfeature;

import demo.plagdetect.calfeature.model.Num;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalNumSim {

    /**
     * @Author duanding
     * @Description 从文件中提取数值变量
     * @Date 5:16 PM 2019/9/23
     * @Param [file]
     * @return void
     **/
    public static List extractNumFromFile(File file){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        List<String> strList;
        List<String> numList = new ArrayList<>();
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            bufferedReader.readLine();
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                if ("".equals(line.trim())) {
                    continue;
                }
                if (line.trim().length() < 2) {
                    continue;
                }
                if (line.trim().charAt(0) == '@'){
                    continue;
                }
                strList = Arrays.asList(line.split("[ \\,\\)]"));
                for(String str : strList){
                    System.out.println(str);
                    if(detectNum(str)){
                        numList.add(str);
                    }
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                    bufferedReader = null;
                }
                if (fileReader != null) {
                    fileReader.close();
                    fileReader = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return numList;
    }

    /**
     * @Author duanding
     * @Description 检测字符串是否为数值
     * @Date 4:52 PM 2019/9/23
     * @Param [str]
     * @return java.lang.Boolean
     **/
    public static Boolean detectNum(String str){
        Boolean strResult = str.matches("-?[0-9]+.?[0-9]*");
        return strResult;
    }
}
