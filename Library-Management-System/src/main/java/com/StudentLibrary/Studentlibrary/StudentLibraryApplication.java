package com.StudentLibrary.Studentlibrary;

import com.StudentLibrary.Studentlibrary.Model.Author;
import com.StudentLibrary.Studentlibrary.Model.Book;
import com.StudentLibrary.Studentlibrary.Model.Card;
import com.StudentLibrary.Studentlibrary.Model.Genre;
import com.StudentLibrary.Studentlibrary.Model.Student;
import com.StudentLibrary.Studentlibrary.Repositories.AuthorRepository;
import com.StudentLibrary.Studentlibrary.Repositories.BookRepository;
import com.StudentLibrary.Studentlibrary.Repositories.CardRepository;
import com.StudentLibrary.Studentlibrary.Repositories.StudentRepository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentLibraryApplication implements CommandLineRunner {



	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CardRepository cardRepository;


	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentLibraryApplication.class, args);
	}

	@Override
	public void run(String... args)throws Exception {

		Student student =new Student("abc@gnail.com","Rohit",21,"India");

		Card card=new Card();
		card.setStudent(student);
		student.setCard(card);

		cardRepository.save(card);
		studentRepository.updateStudentEmail("xyz@yahoo.com","xyz@1234");

		Author author=new Author("Rohit","coder@gmail.com",76,"India");
		Book book=new Book("Intro to Java", Genre.Java,author);
		author.setBooks_written(Arrays.asList(book));
		authorRepository.save(author);
		cardRepository.findAll().stream().forEach(System.out::println);

	}
}
