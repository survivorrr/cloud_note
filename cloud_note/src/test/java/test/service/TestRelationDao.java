package test.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloud_note.dao.RelationDao;
import cn.tedu.cloud_note.entity.Book;
import cn.tedu.cloud_note.entity.User;
import test.TestBase;

public class TestRelationDao extends TestBase{
	private RelationDao rdao;
	
	@Before
	public void init() {
		rdao = super.getContext().getBean("relationDao",RelationDao.class);
	}
	@Test
	public void testMany() {
		User user = rdao.findUserAndBooks1("48595f52-b22c-4485-9244-f4004255b972");
		System.out.println("=============�û���Ϣ=================");
		System.out.println("����:"+user.getCn_user_name());
		System.out.println("�ǳ�:"+user.getCn_user_nick());
		System.out.println("�ʼǱ�����:"+user.getBooks().size());
		System.out.println("=============�ʼǱ��б�=====================");
		for(Book book:user.getBooks()) {
			System.out.println(book.getCn_notebook_name());
		}
	}
	
	@Test
	public void testOne() {
		List<Book> list = rdao.findBookAndUser();
		for(Book book:list) {
			System.out.println(book.getCn_notebook_name()+" "+book.getCn_notebook_createtime());
			if(book.getUser()!=null) {
				System.out.println(book.getUser().getCn_user_name());
			}
		}
	}
}