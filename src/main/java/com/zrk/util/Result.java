package com.zrk.util;


public class Result {

    /**
     * 服务器状态码
     */
    private Integer status;

    /**
     * 服务信息
     */
    private String message;

    /**
     * 数据
     */
    private Object data;

    public Result() {
    }

    public Result(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    /**
     * 用于请求成功的时候
     * @return new Result(200,"请求成功",null);
     */
    public static Result seccuss(){
        return Result.seccuss("请求成功");
    }
    public static Result seccuss(Object data){
        return Result.seccuss("请求成功",data);
    }
    public static Result seccuss(String message,Object data){
        return new Result(200,message,data);
    }

    public static Result errorRequest(){
        return Result.errorRequest("请求错误");
    }
    public static Result errorRequest(String message){
        return new Result(403,message,null);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
