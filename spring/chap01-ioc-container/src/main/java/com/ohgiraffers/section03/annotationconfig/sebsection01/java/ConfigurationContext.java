package com.ohgiraffers.section03.annotationconfig.sebsection01.java;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("configurationSection03")
// 베이스 패키지 설정이 별도로 없을 경우 현재 패키지 기준으로 스캔이 수행된다.
@ComponentScan(basePackages = "com.ohgiraffers")
public class ConfigurationContext {
}
