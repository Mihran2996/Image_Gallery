package itspace.am.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Optional<String> name=Optional.ofNullable(null);
//        if(name.isPresent()){//veradardznume boolean arjeq ete ka goyutyun uni,
//            System.out.println(name.get().charAt(0));//petqe kanchel get metod@ vor
//                                                      //arden hasaneli linen stringi metodner@
//        }else{
//            name.orElse("valod");
//        }
    }
}
