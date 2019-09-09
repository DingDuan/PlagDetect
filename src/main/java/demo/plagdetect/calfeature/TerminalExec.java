package demo.plagdetect.calfeature;

import java.io.*;

public class TerminalExec {


    /*
     * @Author duanding
     * @Description Java调用diff命令
     * @Date 10:54 AM 2019/9/7
     * @Param [oldFile, newFile, compareFile]
     * @return java.io.File
     **/
    public File runDiff(File oldFile, File newFile, File compareFile)
    {

        //oldFileName=(oldFile.getPath()).replace('\\', '/');
        String oldFileName=oldFile.getPath();
//        System.out.println("filename"+oldFileName);
        //newFileName=(newFile.getPath()).replace('\\', '/');
        String newFileName=newFile.getPath();
        String[] commands=new String[4];
        commands[0]="diff";
        commands[1]="-u";
        commands[2]=oldFileName;
        commands[3]=newFileName;
//        log.info("command"+commands.toString());
        try
        {
            Process proc=Runtime.getRuntime().exec(commands);
            InputStream in = proc.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(reader);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(compareFile));
            char buf[] = new char[1024];         //字符缓冲区
            int len;
            while ((len = bufferedReader.read(buf)) != -1)
            {
                bufferedWriter.write(buf, 0, len);
            }
            bufferedWriter.flush();
            bufferedReader.close();
            bufferedWriter.close();
        }catch(IOException e){
            System.err.println("数据比较出错"+ e.toString());
            e.printStackTrace();
        }
        return compareFile;
    }

    /*
     * @Author duanding
     * @Description 执行mac命令行命令
     * @Date 9:28 AM 2019/9/7
     * @Param [command]
     * @return java.lang.String
     **/
    public String execute(String command) {
        String[] cmd = {"/bin/bash"};
        Runtime rt = Runtime.getRuntime();
        Process proc = null;
        try {
            proc = rt.exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 打开流
        OutputStream os = proc.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

        String output = "";
        try {
            bw.write(command);

            bw.flush();
            bw.close();

            /** 真奇怪，把控制台的输出打印一遍之后竟然能正常终止了~ */
            output = readConsole(proc);

            /** waitFor() 的作用在于 java 程序是否等待 Terminal 执行脚本完毕~ */
            proc.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int retCode = proc.exitValue();
       System.out.println("unix script retCode = " + retCode);
        if (retCode != 0) {
            readConsole(proc);
            System.err.println("UnixScriptUil.execute 出错了!!");
        }
        return output;
    }

    /*
     * @Author duanding
     * @Description 读取控制命令的输出结果
     * @Date 9:29 AM 2019/9/7
     * @Param [process]
     * @return java.lang.String
     **/
    public String readConsole(Process process) {
        StringBuffer cmdOut = new StringBuffer();
        InputStream fis = process.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                cmdOut.append(line).append(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//       System.out.println("执行系统命令后的控制台输出为：\n" + cmdOut.toString());
        return cmdOut.toString().trim();
    }
}
