package resources;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import pojo.CreateComment;
import pojo.CreatePost;

public class TestDataBuilder {
	
	private static CreatePost static_cp;
	private static CreatePost dynamic_cp;
	
	private static CreateComment static_comment;
	private static CreateComment dynamic_comment;
	
	private static HashMap<String,String> headerMap;

	
	//Creating Data for Post Creation
	public static CreatePost CreatePostPayload() {
		
		static_cp = new CreatePost();		
		static_cp.setUserId((int)Math.random()*100);
		static_cp.setId((int)Math.random()*1000);
		static_cp.setTitle("Sample Title for Post");
		static_cp.setBody("Sample Post Body");
		
		return static_cp;
		
	}
	
	//Creating Data for Post Creation
	public static CreatePost CreatePostPayloadWithData(int userId, int id, String title, String body ) {
		
		dynamic_cp = new CreatePost();		
		dynamic_cp.setUserId(userId);
		dynamic_cp.setId(id);
		dynamic_cp.setTitle(title);
		dynamic_cp.setBody(body);
		
		return dynamic_cp;
		
	}
	
	// Creating the collection of required attribute in POST request header
	public static HashMap<String,String> getHeaders(){
		
		headerMap = new HashMap<String, String>();
		headerMap.put("Content-type", "application/json");
		headerMap.put("charset", "UTF-8");
		
		return headerMap;
		
	}
	
	//Creating Data for Post Creation
		public static CreateComment CreateCommentPayload() {
			
			static_comment = new CreateComment();		
			static_comment.setPostId(101);
			static_comment.setId((int)Math.random()*100);
			static_comment.setName("User@21");
			static_comment.setEmail("user21@test.email.com");
			static_comment.setBody("Test Comment 21");
			
			return static_comment;
			
		}
		
		//Creating Data for Post Creation
		public static CreateComment CreateCommentPayloadWithData(int postId, int id, String name, String email, String text ) {
			
			dynamic_comment = new CreateComment();		
			dynamic_comment.setPostId(postId);
			dynamic_comment.setId(id);
			dynamic_comment.setName(name);
			dynamic_comment.setEmail(email);
			dynamic_comment.setBody(text);
			
			return dynamic_comment;
			
		}
		

}
