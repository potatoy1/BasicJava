package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import chapter20.memo.MemoDAO;
import chapter20.memo.MemoVO;

class MyTest {
	MemoDAO dao = new MemoDAO();

//	@Test
	void memoSelectList() throws Exception {
		List<MemoVO> list = dao.selectList();
		assertEquals(2, list.size());
	}

//	@Test
	void memoSelectOne() throws Exception {
		MemoVO vo = dao.selectOne(0);
		assertNotNull(vo);
	}

//	@Test
	void insert() throws Exception {
		MemoVO vo = new MemoVO();
		vo.setTitle("두번째 메모");
		vo.setContents("곧 점심시간이다~");
		int insertMemo = dao.insertMemo(vo);
		assertEquals(1, insertMemo);
		assertEquals(2, dao.selectList().size());
	}
	
//	@Test
	void update() throws Exception {
		MemoVO vo = new MemoVO();
		vo.setId(4);
		vo.setTitle("오늘은 화요일");
		vo.setContents("9시 45분이 지났다.");
//		assertEquals(1, updateMemo);//성공하면 1, 실패하면 0
		MemoVO memo = dao.selectOne(4);
		assertNull(vo.getModifyDate());

		dao.updateMemo(vo);
		memo = dao.selectOne(4);
		
		assertEquals(vo.getTitle(), memo.getTitle());
		assertNotNull(memo.getModifyDate());
	}
	@Test
	void delete() throws Exception {
		dao.deleteMemo(2);
		assertEquals(6, dao.selectList().size());
	}
}