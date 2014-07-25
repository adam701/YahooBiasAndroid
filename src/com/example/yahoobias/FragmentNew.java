package com.example.yahoobias;

import com.nostra13.universalimageloader.core.ImageLoader;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentNew extends Fragment {

	private View view;
	private TextView tvTitle;
	private TextView tvSource;
	private TextView tvAuthor;
	private ImageView ivPic;
	
	
	private String title;
	private String author;
	private String picUrl;
	private String source;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Defines the xml file for the fragment
		view = inflater.inflate(R.layout.news_item, container, false);
		// Setup handles to view objects here
		// etFoo = (EditText) v.findViewById(R.id.etFoo);

		tvTitle = (TextView) view.findViewById(R.id.tvTitle);
		tvSource = (TextView) view.findViewById(R.id.tvSource);
		tvAuthor = (TextView) view.findViewById(R.id.tvAuthoer);
		ivPic = (ImageView) view.findViewById(R.id.ivPic);

		ImageLoader.getInstance().displayImage(picUrl, ivPic);
		tvTitle.setText(title);
		tvSource.setText(source);
		tvAuthor.setText(author);
		
		return view;
	}

	public void setView(String title, String source, String author,
			String picUrl) {
		this.title = title;
		this.source = source;
		this.author = author;
		this.picUrl = picUrl;
	}

}
