//package com.zrk.entity.sandbox;
//
//import java.util.Date;
//
///**
// * @author zhang run kai
// * @version 1.0
// * @date 2021/3/31 22:31
// */
//public class Result {
//
//    //运行Id
//    private Integer submitId;
//    /**
//     * 结果
//     * AC:0
//     * SE:1 沙盒出错 线程池意外停止
//     * WA:2
//     * TE:3 超时
//     * ME:4 超过规定内存
//     */
//    private Integer resultId;
//    //运行类型，指语言
//    private String submitType;
//    //提交时间
//    private Date submitTime;
//    //运行时间
//    private long runTime;
//    //运行内存
//    private long runMemory;
//
//    private String message;
//    public Result() {
//    }
//
//    public Result(SandboxSubmit problem, Integer resultId, long runTime, long runMemory) {
//        this.resultId = resultId;
//        this.submitId = problem.getSubmitId();
//        this.submitType = problem.getSubmitType();
//        this.submitTime = problem.getSubmitTime();
//        this.runTime = runTime;
//        this.runMemory = runMemory;
//    }
//    public Result(SandboxSubmit problem, Integer resultId, long runTime, long runMemory, String message) {
//        this.resultId = resultId;
//        this.submitId = problem.getSubmitId();
//        this.submitType = problem.getSubmitType();
//        this.submitTime = problem.getSubmitTime();
//        this.runTime = runTime;
//        this.runMemory = runMemory;
//        this.message = message;
//    }
//
//    public Integer getResultId() {
//        return resultId;
//    }
//
//    public void setResultId(Integer resultId) {
//        this.resultId = resultId;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public Integer getSubmitId() {
//        return submitId;
//    }
//
//    public void setSubmitId(Integer submitId) {
//        this.submitId = submitId;
//    }
//
//    public String getSubmitType() {
//        return submitType;
//    }
//
//    public void setSubmitType(String submitType) {
//        this.submitType = submitType;
//    }
//
//    public Date getSubmitTime() {
//        return submitTime;
//    }
//
//    public void setSubmitTime(Date submitTime) {
//        this.submitTime = submitTime;
//    }
//
//    public long getRunTime() {
//        return runTime;
//    }
//
//    public void setRunTime(long runTime) {
//        this.runTime = runTime;
//    }
//
//    public long getRunMemory() {
//        return runMemory;
//    }
//
//    public void setRunMemory(long runMemory) {
//        this.runMemory = runMemory;
//    }
//
//    @Override
//    public String toString() {
//        return "Result{" +
//                "submitId=" + submitId +
//                ", resultId=" + resultId +
//                ", submitType='" + submitType + '\'' +
//                ", submitTime=" + submitTime +
//                ", runTime=" + runTime +
//                ", runMemory=" + runMemory +
//                ", message='" + message + '\'' +
//                '}';
//    }
//}
