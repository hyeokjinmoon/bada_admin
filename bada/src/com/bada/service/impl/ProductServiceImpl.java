package com.bada.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import com.bada.model.Product;
import com.bada.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	SqlSession sqlSession;
	Logger logger;
	
	public ProductServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}
	
	@Override
	public void insertProduct(Product product) throws Exception {
		try {
			int result = sqlSession.insert("ProductMapper.insertProduct", product);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("등록신청된 상품이 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("상품 등록신청에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public List<Product> selectProductListByMember(Product product) throws Exception {
		List<Product> result = null;
		try {
			result = sqlSession.selectList("ProductMapper.selectProductListByMember", product);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("상품 목록 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public int selectProductCountByMember(Product product) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("ProductMapper.selectProductCountByMember", product);
		} catch (Exception e) {
			throw new Exception("상품수 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public Product selectProductView(Product product) throws Exception {
		Product result = null;
		try {
			result = sqlSession.selectOne("ProductMapper.selectProductView", product);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 상품이 없습니다.");
		} catch (Exception e) {
			throw new Exception("상품 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public int selectProductSaleAllCount(Product product) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("ProductMapper.selectProductSaleAllCount", product);
		} catch (Exception e) {
			throw new Exception("상품수 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public List<Product> selectProductSaleAll(Product product) throws Exception {
		List<Product> result = null;
		try {
			result = sqlSession.selectList("ProductMapper.selectProductSaleAll", product);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("상품 목록 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public int selectProductSaleCategoryCount(Product product) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("ProductMapper.selectProductSaleCategoryCount", product);
		} catch (Exception e) {
			throw new Exception("상품수 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public List<Product> selectProductSaleCategory(Product product) throws Exception {
		List<Product> result = null;
		try {
			result = sqlSession.selectList("ProductMapper.selectProductSaleCategory", product);
		} catch (Exception e) {
			throw new Exception("상품 목록 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public Product selectProductDetail(Product product) throws Exception {
		Product result = null;
		try {
			result = sqlSession.selectOne("ProductMapper.selectProductDetail", product);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 상품이 없습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("상품 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public Product selectProductCartInsert(Product product) throws Exception {
		Product result = null;
		try {
			result = sqlSession.selectOne("ProductMapper.selectProductCartInsert", product);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 상품이 없습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("상품 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public void updateProductByPayment(Product product) throws Exception {
		try {
			int result = sqlSession.update("ProductMapper.updateProductByPayment", product);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new Exception("결제할 상품이 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new Exception("상품 결제에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public Map<String, String> selectProductName(Product product) throws Exception {
		Map<String, String> result = null;
		try {
			result = sqlSession.selectMap("ProductMapper.selectProductName", product, "value");
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 상품명이 없습니다.");
		} catch (Exception e) {
			throw new Exception("상품명 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public void deleteProduct(Product product) throws Exception {
		try {
			int result = sqlSession.update("ProductMapper.deleteProduct", product);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new Exception("삭제할 상품이 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new Exception("상품 삭제에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

}
