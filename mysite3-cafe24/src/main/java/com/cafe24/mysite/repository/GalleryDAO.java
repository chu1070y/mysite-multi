package com.cafe24.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.mysite.vo.GalleryVO;

@Repository
public class GalleryDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public Boolean insertImg(GalleryVO vo) {
		int count = sqlSession.insert("gallery.insertImg", vo);
		return 1 == count;
	}
	
	public List<GalleryVO> getList(){
		return sqlSession.selectList("gallery.imgList");
	}

}
