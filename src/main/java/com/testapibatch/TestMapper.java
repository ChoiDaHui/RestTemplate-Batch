package com.testapibatch;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {
    //group by
    @Select("select `address`, sum(`count`) as 'count' from `data` group by `address`")
    List<TestDTO> read_data();
    //전체데이터 다가져오고 자바로 정제
    @Select("select `address`, `count` from `data`")
    List<TestDTO> read_all_data();

}
