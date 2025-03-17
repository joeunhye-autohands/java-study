package hello.hello_spring.service;

import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    // 뜰때 memberService, memberRepository 모두 스프링 빈에 등록
    // 스프링 빈에 등록되어있는 repository를 멤버 서비스에 넣어준다.
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}

