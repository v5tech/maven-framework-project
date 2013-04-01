package com.fengjing.framework.springmvc.viewer.rss;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import com.fengjing.framework.springmvc.model.SampleContent;
import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Content;
import com.sun.syndication.feed.rss.Item;

@Service("rssViewer")
public class CustomRssViewer extends AbstractRssFeedView{

	
	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Channel feed,
			HttpServletRequest request) {
		feed.setTitle("Spring MVC RRS VIEW");
		feed.setDescription("Spring MVC RRS VIEW");
		feed.setLink("http://blog.csdn.net/sxyx2008");
		super.buildFeedMetadata(model, feed, request);
	}
	
	
	
	@Override
	protected List<Item> buildFeedItems(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		@SuppressWarnings("unchecked")
		List<SampleContent> listContent = (List<SampleContent>) model.get("feedContent");
		List<Item> items = new ArrayList<Item>(listContent.size());
		for(SampleContent tempContent : listContent ){
			 
			Item item = new Item();
 
			Content content = new Content();
			content.setValue(tempContent.getSummary());
			item.setContent(content);
 
			item.setTitle(tempContent.getTitle());
			item.setLink(tempContent.getUrl());
			item.setPubDate(tempContent.getCreatedDate());
 
			items.add(item);
		}
		
		return items;
	}

}
