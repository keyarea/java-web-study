package net.fangcun.web.formbean;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录表单
 */
public class LoginFormBean {

    // 用户输入的用户名
    private String name;

    // 用户输入的密码
    private String password;

    // 用户输入的验证码
    private String verifyCode;

    // 存储校验不同时给用户的错误提示信息
    private Map<String, String> errors = new HashMap<String, String>();

    /**
     * validate方法负责校验表单输入项
     * 表单输入项校验规则：
     *   private String name; 用户名不能为空，并且要是1-8的字母
     *   private String password; 密码不能为空
     *   private String verifyCode; 验证码不能为空
     */
    public boolean validate() {

        boolean isok = true;

        if(this.name == null || this.name.trim().equals("")){
            isok = false;
            this.errors.put("name", "用户名不能为空");
        }

        if(this.password == null || this.password.trim().equals("")){
            isok = false;
            this.errors.put("password", "密码不能为空");
        }

        if(this.verifyCode == null || this.password.trim().equals("")){
            isok = false;
            this.errors.put("verifyCode", "验证码不能为空");
        }



        return isok;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
