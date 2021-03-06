package com.example.dao;

import com.example.domain.mybatis.PersonDemo;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDemoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person_demo
     *
     * @mbggenerated Wed Jul 04 21:33:08 CST 2018
     */
    int deleteByPrimaryKey(String personId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person_demo
     *
     * @mbggenerated Wed Jul 04 21:33:08 CST 2018
     */
    int insert(PersonDemo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person_demo
     *
     * @mbggenerated Wed Jul 04 21:33:08 CST 2018
     */
    int insertSelective(PersonDemo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person_demo
     *
     * @mbggenerated Wed Jul 04 21:33:08 CST 2018
     */
    PersonDemo selectByPrimaryKey(String personId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person_demo
     *
     * @mbggenerated Wed Jul 04 21:33:08 CST 2018
     */
    int updateByPrimaryKeySelective(PersonDemo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person_demo
     *
     * @mbggenerated Wed Jul 04 21:33:08 CST 2018
     */
    int updateByPrimaryKey(PersonDemo record);
}