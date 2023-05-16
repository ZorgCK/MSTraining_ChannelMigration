package one.microstream.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import one.microstream.reference.Lazy;


public class Root
{
	private final Map<String, Lazy<List<Book>>>	books	= new HashMap<String, Lazy<List<Book>>>();
	private final Map<String, Lazy<Author>>		authors	= new HashMap<String, Lazy<Author>>();
	
	public Map<String, Lazy<List<Book>>> getBooks()
	{
		return books;
	}
	
	public Map<String, Lazy<Author>> getAuthors()
	{
		return authors;
	}
}
