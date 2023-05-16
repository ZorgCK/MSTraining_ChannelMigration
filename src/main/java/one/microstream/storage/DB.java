package one.microstream.storage;

import one.microstream.domain.Root;
import one.microstream.storage.embedded.configuration.types.EmbeddedStorageConfiguration;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;

public class DB
{
	public static EmbeddedStorageManager	storageManager;
	public final static Root				root	= new Root();
	
	static
	{		
		storageManager = EmbeddedStorageConfiguration.Builder()
			.setChannelCount(2)
			.createEmbeddedStorageFoundation()
			.createEmbeddedStorageManager(root)
			.start();
	}
}
