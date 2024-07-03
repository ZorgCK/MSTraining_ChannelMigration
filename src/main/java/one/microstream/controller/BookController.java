package one.microstream.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.serializer.reference.Lazy;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import one.microstream.domain.Book;
import one.microstream.storage.DB;
import one.microstream.utils.MockupUtils;


@Controller("/books")
public class BookController
{
	@Get("/setupData")
	public HttpResponse<?> setupData()
	{
		List<Book> allCreatedBooks = MockupUtils.loadMockupData();
		
		allCreatedBooks.forEach(b ->
		{
			DB.root.getBooks().computeIfAbsent(
				b.getIsbn().substring(0, 2),
				k -> Lazy.Reference(new ArrayList<>()))
			.get().add(b);
			
			DB.root.getAuthors().computeIfAbsent(
				b.getAuthor().getId() + ":" + b.getAuthor().getEmail() + ":" + b.getAuthor().getLastname(),
				k -> Lazy.Reference(b.getAuthor()));
		});
		
		DB.storageManager.storeAll(DB.root.getBooks(), DB.root.getAuthors());
		
		return HttpResponse.ok("Books successfully created!");
	}
	
	
	@Get("/ISBNstartsWith_1")
	public List<Book> ISBNstartsWith1()
	{
		return DB.root.getBooks().entrySet().stream()
			.filter(s -> s.getKey().startsWith("1"))
			.flatMap(e -> e.getValue().get().stream())
			.collect(Collectors.toList());
	}

}
