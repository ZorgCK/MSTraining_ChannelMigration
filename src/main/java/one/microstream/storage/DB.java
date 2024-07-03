package one.microstream.storage;

import org.eclipse.store.storage.embedded.configuration.types.EmbeddedStorageConfiguration;
import org.eclipse.store.storage.embedded.types.EmbeddedStorageManager;

import one.microstream.domain.Root;

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
