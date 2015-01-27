package com.tarena.poll.web.forms;

import org.apache.struts.action.ActionForm;
/************
 * 修改密码时，封装参数
 * @author liuxiaofei
 * @modify by zhengxh
 * @date 2009-1-9
 */
public class ModifyPasswdForm extends ActionForm {
	private static final long serialVersionUID = 979979864036125139L;
	private String newPassword;
	private String newPasswordConfim;
	private String oldPassword;
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	} 
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getNewPasswordConfim() {
		return newPasswordConfim;
	}
	public void setNewPasswordConfim(String newPasswordConfim) {
		this.newPasswordConfim = newPasswordConfim;
	}
	
	
//	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
//		ActionErrors errors = new ActionErrors();
//		if(newPasswd.equals(reNewPasswd)){
//			ActionMessage message=new ActionMessage("errors.modify_password");
//			System.out.println("validate password!");
//			errors.add("password", message);
//		}
//		return errors;
//	}
}
