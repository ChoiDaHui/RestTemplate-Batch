package com.testapibatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TestService {
    @Autowired
    TestMapper testMapper;

    @Scheduled(cron = "* 40 5 * * ?")
    public void create_csv(){
        List<TestDTO> testDTOS = testMapper.read_data();
        LocalDateTime localDateTime = LocalDateTime.now();
        String dateTime = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmm"));
        try(
               FileOutputStream fileOutputStream = new FileOutputStream(dateTime+"_통계.csv");
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "MS949");
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        ){

            bufferedWriter.write("행이름,이름\n");
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
