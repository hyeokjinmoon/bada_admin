package com.bada_admin.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import com.bada_admin.model.Product;
import com.bada_admin.service.ProductService;

public class ProductServiceImpl implements ProductService {
	SqlSession sqlSession;
	Logger logger;
	
	public ProductServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}
	
	@Override
	public void insertProductMember(Product product) throws Exception {
		try {
			int result = sqlSession.insert("ProductMapper.insertProductMember", product);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("상품 정보 입력이 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("상품 정보 입력에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public void insertProductBada(Product product) throws Exception {
		try {
			int result = sqlSession.insert("ProductMapper.insertProductBada", product);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("상품 정보 입력이 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("상품 정보 입력에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public List<Product> selectProductList(Product product) throws Exception {
		List<Product> result = null;
		try {
			result = sqlSession.selectList("ProductMapper.selectProductList", product);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회할 상품 목록이 없습니다.");
		} catch (Exception e) {
			throw new Exception("상품 목록 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public Product selectProduct(Product product) throws Exception {
		Product result = null;
		try {
			result = sqlSession.selectOne("ProductMapper.selectProduct", product);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회할 상품이 없습니다.");
		} catch (Exception e) {
			throw new Exception("상품 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public int selectProductCount(Product product) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("ProductMapper.selectProductCount", product);
		} catch(Exception e) {
			throw new Exception("상품수 조회에 실패했습니다.");
		}
		return result;
	}

}
