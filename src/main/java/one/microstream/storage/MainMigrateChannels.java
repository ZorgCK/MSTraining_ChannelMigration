package one.microstream.storage;

import org.eclipse.store.storage.embedded.configuration.types.EmbeddedStorageConfiguration;
import org.eclipse.store.storage.embedded.tools.storage.converter.StorageConverter;
import org.eclipse.store.storage.types.StorageConfiguration;

public class MainMigrateChannels
{
	public static void main(String[] args)
	{		
		final StorageConfiguration sourceConfig = EmbeddedStorageConfiguration.Builder()
			.setChannelCount(2)
			.setStorageDirectory("storage")
			.createEmbeddedStorageFoundation().getConfiguration();
		
		final StorageConfiguration targetConfig = EmbeddedStorageConfiguration.Builder()
			.setChannelCount(4)
			.createEmbeddedStorageFoundation().getConfiguration();
		
		
		System.out.println("Source storage configuration: " + sourceConfig.channelCountProvider());
		System.out.println("Target storage configuration: " + targetConfig.channelCountProvider());
		
		final StorageConverter storageConverter = new StorageConverter(sourceConfig, targetConfig);
		storageConverter.start();
		
		System.out.println("Storage conversion finished!");
	}
}
