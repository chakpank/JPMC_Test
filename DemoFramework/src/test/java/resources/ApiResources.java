package resources;

public enum ApiResources {
	
	CreatePostAPI("/posts"),
	CreateCommentAPI("/comments"),
	GetUsersAPI("/users");
	
	private String resource; 
	
	ApiResources(String resource){
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}

}
