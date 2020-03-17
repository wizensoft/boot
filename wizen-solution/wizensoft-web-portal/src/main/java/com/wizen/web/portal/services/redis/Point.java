package com.wizen.web.portal.services.redis;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Builder;
import lombok.Getter;

@Getter
@RedisHash("point")
public class Point implements Serializable {

    @Id
    private String key;
    //private Long amount;
    private String value;
    private LocalDateTime refreshTime;

    @Builder
    public Point(String key, String value, LocalDateTime refreshTime) {
        this.key = key;
        this.value = value;
        this.refreshTime = refreshTime;
    }

    public void refresh(String value, LocalDateTime refreshTime){
        if(refreshTime.isAfter(this.refreshTime)){ // 저장된 데이터보다 최신 데이터일 경우
            this.value = value;
            this.refreshTime = refreshTime;
        }
    }
   
    
}