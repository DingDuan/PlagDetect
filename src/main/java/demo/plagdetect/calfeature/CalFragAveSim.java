package demo.plagdetect.calfeature;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CalFragAveSim {

    /**
     * @Author duanding
     * @Description 分析测试程序，提取片段
     * @Date 4:54 PM 2019/9/19
     * @Param [mutModelList, rootPath]
     * @return java.util.Map<java.lang.Integer,java.util.List<ContestantTFModel>>
     **/
//    public static Map<Integer, List<ContestantTFModel>> analyze(List<MUTModel> mutModelList, String rootPath){
//
//        //get all MUT from mysql database;
////        mutModelList = mutModelDao.getMUTModelList();
//
//        List<TestFileModel> testFileModelList = null;
//        List<ContestantTestModel> contestantTestModelList = null;
//        StringBuffer buffer = null;
//        File rootDirectory = new File(rootPath);
//        if (!rootDirectory.exists()) {
//            System.err.println("The root directory does not exist.");
//            return null;
//        }
//        File[] testFiles = rootDirectory.listFiles();
//        if (testFiles != null) {
//            for (File testFile : testFiles) {
//                String testFileName = testFile.getName();
//                if (".DS_Store".equals(testFileName)) {
//                    continue;
//                }
//                System.out.println(testFileName);
//                //                    if ("ArgumentTest.java".equals(testFileName)) {
//                TestFileModel testFileModel = new TestFileModel(testFileName);
//                List<InvokeMethodModel> testMethodList = analyzeTestFile(mutModelList,testFile);
//                if (testMethodList != null) {
//                    testFileModel.setTestMethodList(testMethodList);
//                    if (testFileModelList == null) {
//                        testFileModelList = new ArrayList<>();
//                    }
//                    testFileModelList.add(testFileModel);
//                }
//                //                    }
//            }
//            String[] splits = rootPath.split("/");
//            String cid = splits[splits.length-1];
//            ContestantTestModel contestantTestModel = new ContestantTestModel(cid);
////                if ("364".equals(contestantId)) {
//            List<TestFileModel> allTestFileModelList = testFileModelList;
//            if (allTestFileModelList != null) {
//                contestantTestModel.setTestFileModelList(allTestFileModelList);
//            }
//            if (contestantTestModelList == null) {
//                contestantTestModelList = new ArrayList<>();
//            }
//            contestantTestModelList.add(contestantTestModel);
//        }
//        buffer = new StringBuffer(rootPath);
//        int subjectStringIndex = buffer.indexOf("junit");
//        buffer.replace(subjectStringIndex, buffer.length(), "analysis");
//        buffer.append(File.separator + "sim_analysis"
//                + File.separator + "tfs_classified_by_cid");
////                buffer.append(File.separator + "sim_analysis"
////                        + File.separator + "cid_tfs_for_plaggie");
//        String targetDirectoryPath = buffer.toString();
//        //System.out.println(targetDirectoryPath);
////                writeContestantTestFragmentsForTry(targetDirectoryPath, contestantTestModelList);
//
//        //many lines of this method are annotated,as save to DB instead of to files.
//        writeContestantTestFragmentsToTargetFile(targetDirectoryPath, contestantTestModelList);
//
//
//
//        /**
//         * 2018.06.21
//         * classify test fragments by mut(mid)
//         */
//        Map<Integer, List<ContestantTFModel>> testFragmentsByMIDMap = classifyTFByMID(mutModelList,contestantTestModelList);
//        int start = buffer.indexOf("tfs_classified_by_cid");
//        int end = start + "tfs_classified_by_cid".length();
//        buffer.replace(start, end, "tfs_classified_by_mid");
//        targetDirectoryPath = buffer.toString();
////                writeTFsClassifiedByMIDToTargetFile(targetDirectoryPath, testFragmentsByMIDMap);
//        //the part of writing to database deleted,use jpa to write
////        writeTFsClassifiedByMIDToDatabase(testFragmentsByMIDMap);
//        return testFragmentsByMIDMap;
//        /**
//         * 2018.06.25
//         * Calculate similarity value between two TFs.
//         */
////                List<ContestantSimilarityByMID> contestantSimilarityByMIDList = calculateAllContestantTFSimilarity(testFragmentsByMIDMap);
////                writeTFsSimilarityValueByMIDToTargetFile(targetDirectoryPath, contestantSimilarityByMIDList);
//        /**
//         * 2018.06.27
//         * Statistic the number of contestant classified by MID.
//         */
////                Map<Integer, Integer> mIdTFNumberMap = statisticTFNumberClassifiedByMID(testFragmentsByMIDMap);
////                writeTFNumberStatisticResultToTargetFile(targetDirectoryPath, mIdTFNumberMap);
//    }
//}

    /**
     * @Author duanding
     * @Description 计算片段相似度平均值
     * @Date 8:10 PM 2019/9/19
     * @Param [tfSimValueList]
     * @return double
     **/
    public static double calAverageSimlarity(List<Double> tfSimValueList){
        double average = 0.0;
        double total = 0.0;
        for(double simValue : tfSimValueList){
            total += simValue;
        }
        average = total/tfSimValueList.size();
        return average;
    }
}
