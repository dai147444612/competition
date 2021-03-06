package com.inet.code.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 返回值模式
 *
 * @author HCY
 * @since 2020-10-29
 */
@ApiModel
public class Result {
    /**
     * 时间
     */
    @ApiModelProperty("调用方法的时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date timestamp;
    /**
     * 状态信息
     * 200 - 成功
     * 401 - 非法的
     * 403 - 禁止
     * 404 - 未找到
     * 500 - 错误
     */
    @ApiModelProperty("状态的信息码")
    private Integer status;

    public static final Integer STATUS_OK_200 = 200;
    public static final Integer STATUS_ILLEGAL_401 = 401;
    public static final Integer STATUS_BAN_403 = 403;
    public static final Integer STATUS_NOT_FOUND_404 = 404;
    public static final Integer STATUS_ERROR_500 = 500;

    /**
     * 信息
     */
    @ApiModelProperty("调用的信息提示")
    private String info;

    public static final String INFO_OK_200 = "OK";
    public static final String INFO_ILLEGAL_401 = "ILLEGAL";
    public static final String INFO_BAN_403 = "BAN";
    public static final String INFO_NOT_FOUND_404 = "NOT FOUNT";
    public static final String INFO_ERROR_500 = "ERROR";
    /**
     * 详情
     */
    @ApiModelProperty("调用的信息详情")
    private String details;

    public static final String DETAILS_OK_200 = "成功";
    public static final String DETAILS_ILLEGAL_401 = "非法的";
    public static final String DETAILS_BAN_403 = "禁止的";
    public static final String DETAILS_NOT_FOUND_404 = "未找到";
    public static final String DETAILS_ERROR_500 = "错误";

    /**
     * 返回信息
     */
    @ApiModelProperty("返回信息")
    private Object message;

    /**
     * 调用URL
     */
    @ApiModelProperty("调用的URL路径")
    private String path;

    /**
     * 空参
     */
    public Result() {
    }

    /**
     * OK
     *
     * @param message 信息
     * @param path    URL路径
     * @return Result 风格的返回值
     * @author HCY
     * @since 2020-11-19
     */
    public Result result200(Object message, String path) {
        return new Result(
                Result.STATUS_OK_200
                , Result.INFO_OK_200
                , Result.DETAILS_OK_200
                , message
                , path);
    }

    /**
     * ILLEGAL
     *
     * @param message 信息
     * @param path    URL路径
     * @return Result 风格的返回值
     * @author HCY
     * @since 2020-11-19
     */
    public Result result401(Object message, String path) {
        return new Result(
                Result.STATUS_ILLEGAL_401
                , Result.INFO_ILLEGAL_401
                , Result.DETAILS_ILLEGAL_401
                , message
                , path);
    }

    /**
     * BAN
     *
     * @param message 信息
     * @param path    URL路径
     * @return Result 风格的返回值
     * @author HCY
     * @since 2020-11-19
     */
    public Result result403(Object message, String path) {
        return new Result(
                Result.STATUS_BAN_403
                , Result.INFO_BAN_403
                , Result.DETAILS_BAN_403
                , message
                , path);
    }

    /**
     * NotFound
     *
     * @param message 信息
     * @param path    URL路径
     * @return Result 风格的返回值
     * @author HCY
     * @since 2020-11-19
     */
    public Result result404(Object message, String path) {
        return new Result(
                Result.STATUS_NOT_FOUND_404
                , Result.INFO_NOT_FOUND_404
                , Result.DETAILS_NOT_FOUND_404
                , message
                , path);
    }

    /**
     * ERROR
     *
     * @param message 信息
     * @param path    URL路径
     * @return Result 风格的返回值
     * @author HCY
     * @since 2020-11-19
     */
    public Result result500(Object message, String path) {
        return new Result(
                Result.STATUS_ERROR_500
                , Result.INFO_ERROR_500
                , Result.DETAILS_ERROR_500
                , message
                , path);
    }

    /**
     * 全参
     *
     * @param status
     * @param info
     * @param details
     * @param message
     * @param path
     * @author HCY
     * @since 2020-10-29
     */
    public Result(Integer status, String info, String details, Object message, String path) {
        this.timestamp = new Date();
        this.status = status;
        this.info = info;
        this.details = details;
        this.message = message;
        this.path = path;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp() {
        this.timestamp = new Date();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String error) {
        this.info = error;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Result{" +
                "timestamp=" + timestamp +
                ", status=" + status +
                ", info='" + info + '\'' +
                ", details='" + details + '\'' +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
