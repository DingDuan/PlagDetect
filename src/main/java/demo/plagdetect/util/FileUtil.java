package demo.plagdetect.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
    /**
     * @Author duanding
     * @Description 从diffFile中读取change line
     * @Date 3:41 PM 2019/9/9
     * @Param [diffFile]
     * @return int
     **/
    public static int calculateDiffLineFromDiffFile(File diffFile) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        int changLineNumber = 0;
        try {
            fileReader = new FileReader(diffFile);
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
                char firstChar = line.charAt(0);
                if (firstChar == '-' || firstChar == '+') {
                    changLineNumber++;
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
        return changLineNumber;
    }

    /**
     * @Author duanding
     * @Description 计算目标文件的代码行数
     * @Date 4:54 PM 2019/9/9
     * @Param [targetFile]
     * @return int
     **/
    public static int calculateFileLineFromTargetFile(File targetFile) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        int lineNumber = 0;
        try {
            fileReader = new FileReader(targetFile);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim().length() > 0) {
                    lineNumber++;
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
        return lineNumber;
    }

    /**
     * @Author duanding
     * @Description 计算目标文件中代码字符数（去除注释）
     * @Date 8:35 PM 2019/9/19
     * @Param [targetFile]
     * @return int
     **/
    public static int calCodeCharCount(File targetFile){
        int count = 0;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(targetFile);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim().length() > 0) {
                    if(line.trim().charAt(0)!= '/' && line.trim().charAt(0)!= '*') {
                        //System.out.println(line.trim());
                        count += line.trim().length();
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
        return count;
    }
}
