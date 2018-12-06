package web.entity;

public class Category {
	private Integer categoryId;
	private String categoryName;
	private String cdescribe;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCdescribe() {
		return cdescribe;
	}

	public void setCdescribe(String cdescribe) {
		this.cdescribe = cdescribe;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", cdescribe=" + cdescribe
				+ "]";
	}

}
