package com.testapibatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class TestService {
    @Autowired
    TestMapper testMapper;

    @Scheduled(cron = "* 40 5 * * ?")
    public void create_csv(){
        List<TestDTO> testDTOS = testMapper.read_data();
        try(
                FileOutputStream fileOutputStream = new FileOutputStream("20240102_0504_통계.csv");
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "MS949");
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        ){
            for(TestDTO testDTO : testDTOS){
                bufferedWriter.write(testDTO.getAddress());
                bufferedWriter.write(",");
                bufferedWriter.write(String.valueOf(testDTO.getCount()));
                bufferedWriter.write("\n");
            }
            System.out.println("파일 생성완료");
        } catch (Exception e){
            System.out.println("오류 발생");
        }
    }



}
