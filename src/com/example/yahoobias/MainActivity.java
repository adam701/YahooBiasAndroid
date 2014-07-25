package com.example.yahoobias;

import java.util.ArrayList;
import java.util.List;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends FragmentActivity {

	private ListView lvNews;
	private List<NewsDataModel> datas;
	private NewsAdapter adapter;
	
	
	private void init(){
		String[][] mocks = {{"5 Things You Didn't Know About Professional Video Gaming", "Yahoo Tech", "Gordon Cameron", "https://s3.yimg.com/cd/resizer/FIT_TO_WIDTH-w450/8f019af07d0490b58ab1946f973eab3301ebfa24.jpg",null,"false"},
				{"Why I Backed a Kickstarter Effort to Redesign the Bible", "Yahoo Tech", "Rob Wakjer", "https://s.yimg.com/cd/resizer/FIT_TO_WIDTH-w500/8ce14a013d09f982d3c37920acd6ef618cb3a611.jpg", null, "false"},
				{"IPOs Get Bigger but Leave Less for Public Investors", "Finance", "BusinessWeek", "http://ww4.hdnux.com/photos/13/24/45/2967879/7/628x471.jpg", null, "false"},
				{"Chris Pratt's Advice for Getting in Shape", "Yahoo Movies", null, "http://resources3.news.com.au/images/2013/12/05/1226775/867955-0d682936-57ee-11e3-8753-b885d06300c5.jpg", null, "false"},
				{"Food for Your Pets","Yahoo Food",null,"http://www.omfgod.com/wp-content/uploads/2012/03/broken-cat-400x345.jpg","http://ourhometowndeal.com/wp-content/uploads/2012/09/naturesselect.jpg","true"},
				{"Russia firing artillery on Ukraine troops: US", "Yahoo!", null, "http://l1.yimg.com/bt/api/res/1.2/NqkKxCjUTRbkEBBWT.__BA--/YXBwaWQ9eW5ld3M7Zmk9ZmlsbDtoPTYzNDtweW9mZj0wO3E9NzU7dz05NjA-/http://media.zenfs.com/en_us/News/afp.com/Part-PAR-Par7935738-1-1-0.jpg","","false"},
				{"'Avengers: Age of Ultron': New Images Debut!", "Yahoo Movie", null, "https://s1.yimg.com/bt/api/res/1.2/bainoEPsJ2_c.1Tzbh4Lug--/YXBwaWQ9eW5ld3M7Zmk9ZmlsbDtoPTQ4NDtweW9mZj0wO3E9NzU7c209MTt3PTYzMA--/http://media.zenfs.com/en_ca/News/AccessHollywood/212803.jpg", "", "false"},
				{"Investigators Solve Mystery of Porcelain Dolls Left on Doorsteps", "Yahoo", null, "https://s1.yimg.com/bt/api/res/1.2/MQTJvE2yDUIuj_r4I15mmw--/YXBwaWQ9eW5ld3M7Zmk9ZmlsbDtoPTU0MDtweW9mZj0wO3E9NzU7dz05NjA-/http://media.zenfs.com/en_us/gma/us.abcnews.gma.com/HT_Porcelain_Dolls_mar_140724_16x9_992.jpg", "", "false"}};
		
		for (String[] mock : mocks){
			adapter.add(new NewsDataModel(mock[0], mock[2], mock[1], mock[3], mock[4], mock[5]));
		}
	}
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		   DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().
	        		cacheInMemory().cacheOnDisc().build();
	       ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
	            .defaultDisplayImageOptions(defaultOptions)
	            .build();
	       ImageLoader.getInstance().init(config);
		
		this.lvNews = (ListView) findViewById(R.id.lvYahooBias);
		this.datas = new ArrayList<NewsDataModel>();
		this.adapter = new NewsAdapter(getApplicationContext(), this.datas);
		this.lvNews.setAdapter(this.adapter);
		init();
	}
	
}
