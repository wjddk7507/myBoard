package kr.co.myboard.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import kr.co.myboard.domain.Navertv;

@Service
public class ContentServiceImpl implements ContentService {

	@Override
	public List<Navertv> naverParsing() {
		String source_id;
		Document doc;
		
		List<Navertv> list = new ArrayList<Navertv>();

		try {
			doc = Jsoup.connect("http://tv.naver.com/r/").get();
			Elements contents = doc.select("a.box");	
			Navertv content;
			
			for(Element temp : contents) {
				String title = temp.select("img").attr("alt");
				String src = temp.attr("href");
				String img = temp.attr("data-anisrc");
				
				content = new Navertv();
				content.setTitle(title);
				content.setSrc(src);
				content.setImg(img);
				
				list.add(content);
			}
			
			contents = doc.select("a.cds_thm");	
			for(Element temp : contents) {
				String title = temp.select("img").attr("alt");
				String src = temp.attr("href");
				String img = temp.attr("data-anisrc");
				
				content = new Navertv();
				content.setTitle(title);
				content.setSrc(src);
				content.setImg(img);
				
				list.add(content);
			}
			
		} catch (IOException e) {
			System.out.println("네이버 tv 파싱 : "+e.getMessage());
			e.printStackTrace();
		}
		
		return list;

		/*
		Map<String, List<String>> map = new HashMap<String,  List<String>>();
		
		List<String> title = new ArrayList<String>();
		List<String> link = new ArrayList<String>();
		List<String> img = new ArrayList<String>();
		
		try {
			doc = Jsoup.connect("http://tv.naver.com/r/").get();
			Elements contents = doc.select("a.box");	
			
			for(Element temp : contents) {
				title.add(temp.select("img").attr("alt"));
				link.add(temp.attr("href"));
				img.add(temp.attr("data-anisrc"));
			}
			// 4~100위
			contents = doc.select("a.cds_thm");	
			for(Element temp : contents) {
				title.add(temp.select("img").attr("alt"));
				link.add(temp.attr("href"));
				img.add(temp.attr("data-anisrc"));
			}
			map.put("title", title);
			map.put("link", link);
			map.put("img", img);
			
			return map;
			
		} catch (IOException e) {
			System.out.println("네이버 tv 파싱 : "+e.getMessage());
			e.printStackTrace();
		}
		return null;
		
		*/
	}

}
