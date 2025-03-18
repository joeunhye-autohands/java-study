package hello.hello_spring.service;

import hello.hello_spring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//    @PersistenceContext
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    // 뜰때 memberService, memberRepository 모두 스프링 빈에 등록
    // 스프링 빈에 등록되어있는 repository를 멤버 서비스에 넣어준다.
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    // memberRepository는 이미 생성자를 통해 주입받았으므로 이 메소드는 필요 없습니다.
    // @Bean
    // public MemberRepository memberRepository() {
    //    return new JpaMemberRepository(em);
    // }
}
