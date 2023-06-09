package com.lewis.base.mapper;

import com.lewis.base.entity.Record;
import java.util.List;

public interface RecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table record
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table record
     *
     * @mbg.generated
     */
    int insert(Record record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table record
     *
     * @mbg.generated
     */
    Record selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table record
     *
     * @mbg.generated
     */
    List<Record> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table record
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Record record);
}