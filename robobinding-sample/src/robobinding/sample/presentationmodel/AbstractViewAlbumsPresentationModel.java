package robobinding.sample.presentationmodel;

import robobinding.binding.viewattribute.ItemClickEvent;
import robobinding.presentationmodel.AbstractPresentationModel;
import robobinding.sample.CreateEditAlbumActivity;
import robobinding.sample.ViewAlbumActivity;
import robobinding.sample.dao.AlbumDao;
import robobinding.sample.model.Album;
import android.content.Context;
import android.content.Intent;

public abstract class AbstractViewAlbumsPresentationModel extends AbstractPresentationModel
{
	protected static final String PROPERTY_ALBUMS = "albums";
	
	protected Context context;
	protected AlbumDao albumDao;
	
	public AbstractViewAlbumsPresentationModel(Context context, AlbumDao albumDao)
	{
		this.context = context;
		this.albumDao = albumDao;
	}

	public void createAlbum()
	{
		context.startActivity(new Intent(context, CreateEditAlbumActivity.class));
	}

	public void viewAlbum(ItemClickEvent event)
	{
		Album album = albumDao.getAll().get(event.getPosition());
		
		Intent intent = new Intent(context, ViewAlbumActivity.class);
		intent.putExtra(ViewAlbumActivity.ALBUM_ID, album.getId());
		context.startActivity(intent);
	}
}