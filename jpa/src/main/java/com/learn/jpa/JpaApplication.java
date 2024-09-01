package com.learn.jpa;

import com.github.javafaker.Faker;
import com.learn.jpa.models.Author;
import com.learn.jpa.models.File;
import com.learn.jpa.models.Text;
import com.learn.jpa.models.Video;
import com.learn.jpa.repositories.AuthorRepository;
import com.learn.jpa.repositories.FileRepository;
import com.learn.jpa.repositories.TextRepository;
import com.learn.jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.LongStream;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    //    @Bean
    public CommandLineRunner commandLineRunner(
            AuthorRepository authorRepo,
            VideoRepository videoRepo,
            FileRepository fileRepo,
            TextRepository textRepo
    ) {
        return args -> {
            var author = Author
                    .builder()
                    .firstName("Vikas")
                    .lastName("Poute")
                    .age(24)
                    .email("dev.vikaspoute@gmail.com")
                    .build();
            authorRepo.save(author);

            var video = Video
                    .builder()
                    .name("Java")
                    .size(20)
                    .url("http://localhost:8080")
                    .length(500)
                    .build();

            var file = File
                    .builder()
                    .name("Java")
                    .size(20)
                    .url("http://localhost:8080")
                    .type("Java File")
                    .build();

            var text = Text
                    .builder()
                    .name("Java")
                    .size(20)
                    .url("http://localhost:8080")
                    .content("Hello World")
                    .build();

            videoRepo.save(video);
            fileRepo.save(file);
            textRepo.save(text);

        };
    }

//    @Bean
    public CommandLineRunner insertData(AuthorRepository authorRepo) {
        return args -> {
            Faker faker = new Faker();
            LongStream.range(0, 1000)
                    .mapToObj(i -> Author.builder()
                            .firstName(faker.name().firstName())
                            .lastName(faker.name().lastName())
                            .age(faker.number().numberBetween(18, 65))
                            .email(faker.internet().emailAddress())
                            .createdAt(LocalDateTime.now())
                            .lastModifiedAt(LocalDateTime.now())
                            .createdBy(faker.internet().emailAddress())
                            .lastModifiedBy(faker.internet().emailAddress())
                            .build())
                    .forEach(authorRepo::save);

        };
    }

}
