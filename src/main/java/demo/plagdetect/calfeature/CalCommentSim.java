package demo.plagdetect.calfeature;

import demo.plagdetect.util.FileUtil;

import java.io.*;

public class CalCommentSim {

    /**
     * @Author duanding
     * @Description 从旧文件中提取注释部分，放到新的文件中
     * @Date 10:34 AM 2019/9/20
     * @Param [oldFile, commentFile]
     * @return void
     **/
    public static void extractCommentToFile(File oldFile, File commentFile){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileReader = new FileReader(oldFile);
            bufferedReader = new BufferedReader(fileReader);
            fileWriter = new FileWriter(commentFile);
            bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim().length() > 0) {
                    if(line.trim().charAt(0) == '/' || line.trim().charAt(0) == '*') {
                        bufferedWriter.write(line);
                        bufferedWriter.newLine();
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
                if(bufferedWriter != null){
                    bufferedWriter.close();
                    bufferedWriter = null;
                }
                if(fileWriter != null){
                    fileWriter.close();
                    fileWriter = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @Author duanding
     * @Description 用diff计算行相似度
     * @Date 5:39 PM 2019/9/20
     * @Param [commentFile1, commentFile2, compareFile]
     * @return double
     **/
    public static double calLineSimByDiff(File commentFile1, File commentFile2,File compareFile){
        double sim = 0.0;
        TerminalExec terminalExec = new TerminalExec();
        terminalExec.runDiff(commentFile1,commentFile2,compareFile);
        int diffLine = FileUtil.calculateDiffLineFromDiffFile(compareFile);
        int file1Line = FileUtil.calculateFileLineFromTargetFile(commentFile1);
        int file2Line = FileUtil.calculateFileLineFromTargetFile(commentFile2);
        sim = CalFileSim.calculateSimValueByDiff(file1Line,file2Line,diffLine);
        return sim;
    }
}
