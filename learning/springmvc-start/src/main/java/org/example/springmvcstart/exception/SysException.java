package org.example.springmvcstart.exception;

/**
 * 自定义异常类
 */
public class SysException extends Exception{

    private String message;

    public SysException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
