package com.example.yahoobias;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;

public class NewsAdapter extends ArrayAdapter<NewsDataModel> {

	
	public NewsAdapter(Context context, List<NewsDataModel> tweets) {
		super(context, R.layout.news_item, tweets);
	}

	// Translate method. Get data and convert it to view.
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Get the data item for this position
		NewsDataModel dataModel = getItem(position);
		// Check if an existing view is being reused, otherwise inflate the view
		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(
					R.layout.news_item, parent, false);
		}
		
		TextView tvTitle = (TextView) convertView
				.findViewById(R.id.tvTitle);
		TextView tvSource = (TextView) convertView
				.findViewById(R.id.tvSource);
		TextView tvAuthor = (TextView) convertView.findViewById(R.id.tvAuthoer);
		ImageView ivPic = (ImageView) convertView
				.findViewById(R.id.ivPic);
		ImageView ivPic1 = (ImageView) convertView
				.findViewById(R.id.ivPic1);
		
		ImageView ivAds = (ImageView) convertView
				.findViewById(R.id.ivAds);
		
		TextView tvReadMore = (TextView) convertView
				.findViewById(R.id.tvReadMore);
		
		if(dataModel.isAds()){
			ivPic.setOnClickListener(new ImageOnClickListener(ivPic, ivPic1, dataModel.getImageUrl(), dataModel.getImageUrl()));
			
			ivPic.setScaleType(ImageView.ScaleType.FIT_XY);
			ivPic1.setScaleType(ImageView.ScaleType.FIT_XY);
			ivPic1.setOnClickListener(new ImageOnClickListener(ivPic1, ivPic, dataModel.getImageUrl1(), dataModel.getImageUrl()));
			
			ImageLoader.getInstance().displayImage(dataModel.getImageUrl(), ivPic, new SimpleImageLoadingListener() {
				@Override
				public void onLoadingComplete(String imageUri, View view,
						Bitmap loadedImage) {
					// TODO Auto-generated method stub
					super.onLoadingComplete(imageUri, view, loadedImage);
					
					Bitmap newBitmap = Bitmap.createBitmap(loadedImage, 0, 0, loadedImage.getWidth() / 2, loadedImage.getHeight(), null, false);
					((ImageView) view).setImageBitmap(newBitmap);
				}
	});

			ImageLoader.getInstance().displayImage(dataModel.getImageUrl1(), ivPic1, new SimpleImageLoadingListener() {
				@Override
				public void onLoadingComplete(String imageUri, View view,
						Bitmap loadedImage) {
					// TODO Auto-generated method stub
					super.onLoadingComplete(imageUri, view, loadedImage);
					
					Bitmap newBitmap = Bitmap.createBitmap(loadedImage, 0, 0, loadedImage.getWidth() / 2, loadedImage.getHeight(), null, false);
					((ImageView) view).setImageBitmap(newBitmap);
				}
	});
			
			tvSource.setVisibility(View.INVISIBLE);
			tvAuthor.setVisibility(View.INVISIBLE);
			tvReadMore.setVisibility(View.INVISIBLE);
		}else{
			ivAds.setVisibility(View.GONE);
			ImageLoader.getInstance().displayImage(dataModel.getImageUrl(), ivPic);
			ivPic1.setVisibility(View.GONE);
		}
		
		
		
		
		
		if(dataModel.getTitle() != null){
			tvTitle.setText(dataModel.getTitle());
		} else{
			tvTitle.setText("");
		}
		
		if(dataModel.getSource() != null){
			tvSource.setText(dataModel.getSource());
		}else{
			tvSource.setText("");
		}
		
		if(dataModel.getAuthor() != null){
			tvAuthor.setText(dataModel.getAuthor());
		}else{
			tvAuthor.setText("");
		}

		
	
		
		
		
		return convertView;
	}
	
	
	
	static class ImageOnClickListener implements OnClickListener{

		private ImageView self;
		private ImageView other;
		private String selfUrl;
		private String otherUrl;
		private boolean isBack = false;
		
		public ImageOnClickListener(ImageView self, ImageView other, String selfUrl, String otherUrl){
			this.other = other;
			this.self = self;
			this.selfUrl = selfUrl;
			this.otherUrl = otherUrl;
		}
		
		@Override
		public void onClick(View v) {
			if(!isBack){
				other.setVisibility(View.GONE);
				ImageLoader.getInstance().displayImage(selfUrl, self);
				isBack = true;
			}else{
				isBack = false;
				other.setVisibility(View.VISIBLE);
				ImageLoader.getInstance().displayImage(selfUrl, self, new SimpleImageLoadingListener() {
					@Override
					public void onLoadingComplete(String imageUri, View view,
							Bitmap loadedImage) {
						// TODO Auto-generated method stub
						super.onLoadingComplete(imageUri, view, loadedImage);
						
						Bitmap newBitmap = Bitmap.createBitmap(loadedImage, 0, 0, loadedImage.getWidth() / 2, loadedImage.getHeight(), null, false);
						((ImageView) view).setImageBitmap(newBitmap);
					}
		});
			}
		}
		
	}
	
	
}
