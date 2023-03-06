package db.dao;

import db.model.Products;
import db.model.ProductsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    long countByExample(ProductsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    int deleteByExample(ProductsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    int insert(Products record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    int insertSelective(Products record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    List<Products> selectByExample(ProductsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    Products selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    int updateByExampleSelective(@Param("record") Products record, @Param("example") ProductsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    int updateByExample(@Param("record") Products record, @Param("example") ProductsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    int updateByPrimaryKeySelective(Products record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    int updateByPrimaryKey(Products record);
}