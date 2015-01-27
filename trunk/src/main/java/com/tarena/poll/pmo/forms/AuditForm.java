package com.tarena.poll.pmo.forms;

import org.apache.struts.action.ActionForm;

public class AuditForm extends ActionForm {
	private static final long serialVersionUID = 2518427888200862122L;
	private int isValid;

	public int getIsValid() {
		return isValid;
	}

	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}
	
}
