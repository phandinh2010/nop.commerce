package pageUI;

public class HomePageUI {

	
	public static final String SEARCH_TEXTBOX_AT_HOME_PAGE= "id=small-searchterms";
	public static final String SEARCH_TEXTBOX_AT_SEARCH_PAGE= "id=q";
	public static final String SEARCH_BUTTON_AT_HOME_PAGE = "xpath=//button[text()='Search']";
	public static final String SEARCH_BUTTON_AT_SEARCH_PAGE = "xpath=//div[@class='buttons']//button[text()='Search']";
	public static final String ERROR_MSG_NOT_ENOUGH_CHARACTOR = "xpath=//div[@class='warning']";
	public static final String ERROR_MSG_NO_DATA_FOUND = "xpath=//div[@class='products-container']//div[@class='no-result']";
	public static final String RESULT_SEARCH_PRODUCT_FIRST = "xpath=//a[text()='Lenovo IdeaCentre 600 All-in-One PC']";
	public static final String RESULT_SEARCH_PRODUCT_SECOND = "xpath=//a[text()='Lenovo Thinkpad X1 Carbon Laptop']";
	public static final String RESULT_SEARCH_PRODUCT_ONLY = "xpath=//a[text()='Lenovo Thinkpad X1 Carbon Laptop']";
	public static final String SEARCH_ADVANCE_CHECKBOX = "id=advs";
	public static final String PARENT_CATEGORIES_DROPDOWN = "id=cid";
	public static final String AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX = "id=isc";
	public static final String MANUFACTURER_DROPDOWN = "id=mid";
	public static final String APPLE_MACBOOK_PRO_PRODUCT = "xpath=//a[text()='Apple MacBook Pro 13-inch']";
	public static final String MENU_HEADER = "xpath=//ul[@class='top-menu notmobile']//a[text()='%s']";
	public static final String SUBMENU_HEADER = "xpath=//ul[@class='top-menu notmobile']//a[text()='%s']";
	public static final String SORT_ITEM_DROPDOWN = "id=products-orderby";
	public static final String LIST_PRODUCT_SORT = "xpath=//h2[@class='product-title']/a";
	public static final String LIST_OF_PRICET_SORT = "xpath=//span[@class='price actual-price']";	
	public static final String DISPLAY_DROPLIST = "id=products-pagesize";
	public static final String NUMBER_OF_PRODUCT_PER_PAGE = "xpath=//div[@class='item-box']";
	public static final String PAGE_CURRENT = "xpath=//li[@class='current-page']/span";
	public static final String NEXT_PAGE_BUTTON = "xpath=//li[@class='next-page']";
	public static final String PREV_PAGE_BUTTON = "xpath=//li[@class='previous-page']";
	public static final String PAGING_FUNCTION = "xpath=//div[@class='pager']";
	public static final String SELECt_A_PRODUCT = "xpath=//h2/a[text()='%s']"; 
}
