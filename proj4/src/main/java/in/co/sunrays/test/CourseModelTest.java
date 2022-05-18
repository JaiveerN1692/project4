package in.co.sunrays.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.sunrays.bean.CourseBean;
import in.co.sunrays.model.CourseModel;

public class CourseModelTest {
public static void main(String[] args) {
	testAdd();
	//testUpdate();
	//testDelete();
	//testSearch();
	//testList();
	
}

private static void testList() {
	try {
		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();
        List list = new ArrayList();
        list = model.list(1, 6);
        if (list.size() < 0) {
            System.out.println("Test List fail");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bean = (CourseBean) it.next();
            System.out.println(bean.getId());
            System.out.println(bean.getCourse_Name());
            System.out.println(bean.getDescription());
            System.out.println(bean.getDuration());
            System.out.println(bean.getCreatedDatetime());
            System.out.println(bean.getModifiedBy());
            System.out.println(bean.getModifiedDatetime());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
	
}

private static void testSearch() {
	try {
		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();
		List list = new ArrayList();
        bean.setCourse_Name("BE");
        list = model.search(bean, 1, 10);
        if (list.size() < 0) {
            System.out.println("Test Search fail");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bean = (CourseBean) it.next();
            System.out.println(bean.getId());
            System.out.println(bean.getCourse_Name());
            System.out.println(bean.getDescription());
            System.out.println(bean.getCreatedBy());
            System.out.println(bean.getModifiedBy());
            System.out.println(bean.getCreatedDatetime());
            System.out.println(bean.getModifiedDatetime());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
	
}

private static void testDelete() {
	try {
		CourseModel model = new CourseModel();
		CourseBean bean = new CourseBean();
		bean.setId(1L);
		model.delete(bean);
		System.out.println("Test Delete Success");
		CourseBean bean1 = model.findByPk(2);
		if (bean1 == null) {
			System.out.println("Test add fail");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

private static void testUpdate() {
	try {
		CourseModel model = new CourseModel();
		CourseBean bean = model.findByPk(1);
		bean.setCourse_Name("B.E");
		bean.setDescription("Mechanical");
		bean.setDuration("Four");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		model.update(bean);
		System.out.println("Test Add Success");
		
		CourseBean bean1 = model.findByPk(1);
		if (bean1 == null) {
			System.out.println("Test add fail");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

private static void testAdd() {
	try {
		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();
		bean.setCourse_Name("BcA");
		bean.setDescription("Civil");
		bean.setDuration("Four");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		long pk = model.add(bean);
		System.out.println("Test Add Success");
		
		
		CourseBean bean1 = model.findByPk(pk);
		if(bean1 != null) {
			System.out.println("Test add fail");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
}
