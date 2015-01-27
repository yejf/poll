package com.tarena.poll.pm.forms;


//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;

//import com.tarena.poll.commons.log.LogOutPut;
import com.tarena.poll.entity.TClass;
import com.tarena.poll.entity.TClassType;
/**
 * 用在增加班级和修改班级信息
 * 采用委托
 * @author liuxiaofei&zhengxh
 *
 */
public class ClassForm extends ActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4642565546737716358L;
	
	//private static Log log = LogFactory.getLog(ClassForm.class);
	
	private TClass clazz = new TClass();
	
	public ClassForm() {
		//log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

	/**
	 * @param classIP
	 * @see com.tarena.poll.entity.TClass#setClassIP(java.lang.String)
	 */
	public void setClassIP(String classIP) {
		//LogOutPut.getInstance().debug(">>>>>>>>>>>>>>>>>>>>>>"+classIP);
		clazz.setClassIP(classIP);
	}

	/**
	 * @param className
	 * @see com.tarena.poll.entity.TClass#setClassName(java.lang.String)
	 */
	public void setClassName(String className) {
		//LogOutPut.getInstance().debug(">>>>>>>>>>>>>>>>>>>>>>"+className);
		clazz.setClassName(className);
	}

	/**
	 * @param classType
	 * @see com.tarena.poll.entity.TClass#setClassType(java.lang.String)
	 */
	public void setClassType(TClassType classType) {
		//LogOutPut.getInstance().debug(">>>>>>>>>>>>>>>>>>>>>>"+classType);
		clazz.setClassType(classType);
	}

	/**
	 * @param id
	 * @see com.tarena.poll.entity.TClass#setId(java.lang.Integer)
	 */
	public void setId(Integer id) {
		//LogOutPut.getInstance().debug(">>>>>>>>>>>>>>>>>>>>>>"+id);
		clazz.setId(id);
	}

	/**
	 * @param remark
	 * @see com.tarena.poll.entity.TClass#setRemark(java.lang.String)
	 */
	public void setRemark(String remark) {
		//LogOutPut.getInstance().debug(">>>>>>>>>>>>>>>>>>>>>>"+remark);
		clazz.setRemark(remark);
	}

	/**
	 * @param status
	 * @see com.tarena.poll.entity.TClass#setStatus(int)
	 */
	public void setStatus(int status) {
		clazz.setStatus(status);
	}

	/**
	 * @return the clazz
	 */
	public TClass getClazz() {
		return clazz;
	}

	
}
