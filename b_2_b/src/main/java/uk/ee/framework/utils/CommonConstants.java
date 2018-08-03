package uk.ee.framework.utils;

/**
 * Created by Syamphaneendra Kalluri on 07/12/2016
 * 
 * This class is a constant file having all common constants used in the
 * project.
 * 
 */
public final class CommonConstants {

	// JPA Config Constants
	/**
	 * HIBERNATE_DIALECT_KEY
	 */
	public static final String HIBERNATE_DIALECT_KEY = "hibernate.dialect";

	/**
	 * HIBERNATE_DIALECT_VALUE
	 */
	public static final String HIBERNATE_DIALECT_VALUE = "org.hibernate.dialect.HSQLDialect";

	/**
	 * HIBERNATE_SHOW_SQL
	 */
	public static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";

	/**
	 * HIBERNATE_DB_ACTION
	 */
	public static final String HIBERNATE_DB_ACTION = "javax.persistence.schema-generation.database.action";

	/**
	 * HIBERNATE_SQL_LOAD_SCRIPT
	 */
	public static final String HIBERNATE_SQL_LOAD_SCRIPT = "javax.persistence.sql-load-script-source";

	/**
	 * PACKAHES_TO_SCAN
	 */
	public static final String PACKAHES_TO_SCAN = "uk.ee.framework.business_objects";

	// Driver Package Constants
	/**
	 * LOCAL_EXTENDED_WEB_DRIVER
	 */
	public static final String LOCAL_EXTENDED_WEB_DRIVER = "localExtendedWebDriver";

	/**
	 * PERFECTO_EXTENDED_WEB_DRIVER
	 */
	public static final String PERFECTO_EXTENDED_WEB_DRIVER = "perfectosExtendedWebDriver";

	/**
	 * MOBILE_EXTENDED_WEB_DRIVER
	 */
	public static final String MOBILE_EXTENDED_WEB_DRIVER = "mobileExtendedWebDriver";

	/**
	 * HHMMSS
	 */
	public static final String HHMMSS = "HHmmss";

	/**
	 * TEST_NAME
	 */
	public static final String TEST_NAME = "testName";

	/**
	 * URL
	 */
	public static final String URL = "url";

	// DevicePostProcessor
	/**
	 * TYPE
	 */
	public static final String TYPE = "type";

	/**
	 * MOBILE_SMALL
	 */
	public static final String MOBILE_SMALL = "mobile";

	/**
	 * PAGES
	 */
	public static final String PAGES = "pages";

	/**
	 * BASE_PAGE
	 */
	public static final String BASE_PAGE = "BasePage";

	/**
	 * MOBILE
	 */
	public static final String MOBILE = "Mobile";

	/**
	 * DESKTOP
	 */
	public static final String DESKTOP = "desktop";

	// BasePage
	/**
	 * SPRING_PROFILES_ACTIVE
	 */
	public static final String SPRING_PROFILES_ACTIVE = "spring.profiles.active";

	/**
	 * MOBILE_LOCAL
	 */
	public static final String MOBILE_LOCAL = "mobileLocal";

	// Common Constants
	/**
	 * EMPTY_STR
	 */
	public static final String EMPTY_STR = "";

	/**
	 * PAYM
	 */
	public static final String PAYM = "PAYM";

	/**
	 * PAYG
	 */
	public static final String PAYG = "PAYG";

	/**
	 * YES
	 */
	public static final String YES = "Yes";

	/**
	 * NO
	 */
	public static final String NO = "No";

	/**
	 * PAYM_PHONES
	 */
	public static final String PAYM_PHONES = "PAYMPhones";

	/**
	 * PAYG_PHONES
	 */
	public static final String PAYG_PHONES = "PAYGPhones";

	/**
	 * TRUE
	 */
	public static final String TRUE = "true";

	/**
	 * FALSE
	 */
	public static final String FALSE = "false";

	/**
	 * ZERO
	 */
	public static final int ZERO = 0;

	/**
	 * ONE
	 */
	public static final int ONE = 1;

	// Testing Constants
	// BaseTest
	/**
	 * THREADS
	 */
	public static final String THREADS = "threads";

	/**
	 * LOCATIONS
	 */
	public static final String LOCATIONS = "classpath:configuration/driver.xml";

	// TestNG constants
	/**
	 * TEST_GROUP_REGRESSION
	 */
	public static final String TEST_GROUP_REGRESSION = "Regression";

	/**
	 * DATA_PROVIDER_TESTUSERS
	 */
	public static final String DATA_PROVIDER_TESTUSERS = "testUsers";

	/**
	 * DATA_PROVIDER_TESTEXTUSERS
	 */
	public static final String DATA_PROVIDER_TESTEXTUSERS = "testExtUsers";

	// Common testing data

	/**
	 * DELIVET_TO_HOME
	 */
	public static final String DELIVET_TO_HOME = "deliverToHome";

	/**
	 * COMMON_POSTCODE
	 */
	public static final String COMMON_POSTCODE = "LS116EE";
	
	/**
	 * EXT_CUSTOMER_POSTCODE
	 */
	public static final String EXT_CUSTOMER_POSTCODE = "AL97DS";

	/**
	 * NO_SELECTION
	 */
	public static final String NO_SELECTION = "No Selection";

	/**
	 * ADD_FULL_COVER
	 */
	public static final String ADD_FULL_COVER = "Add FULL COVER";

	/**
	 * CAPACITY_64GB
	 */
	public static final String CAPACITY_64GB = "64GB";

	/**
	 * CAPACITY_2GB
	 */
	public static final String CAPACITY_2GB = "2GB";

	/**
	 * SB
	 */
	public static final String SB = "SB";

	/**
	 * STR_123456
	 */
	public static final String STR_123456 = "123456";
	
	/**
	 * STR_1234
	 */
	public static final String STR_1234 = "1234";

	// Devices
	/**
	 * IPHONE
	 */
	public static final String IPHONE = "iPhone";

	/**
	 * IPHONE_6S
	 */
	public static final String IPHONE_6S = "iphone-6s";

	/**
	 * IPHONE_6S_16GB_SPACE_GREY
	 */
	public static final String IPHONE_6S_16GB_SPACE_GREY = "iphone-6s-16gb-space-grey";

	/**
	 * IPHONE_6S_16GB_GOLD
	 */
	public static final String IPHONE_6S_16GB_GOLD = "iphone-6s-16gb-gold";

	/**
	 * IPAD_AIR2
	 */
	public static final String IPAD_AIR2 = "ipad-air-2";

	/**
	 * IPAD_AIR2_16GB_SPACE_GREY
	 */
	public static final String IPAD_AIR2_16GB_SPACE_GREY = "ipad-air-2-16gb-space-grey";

	/**
	 * IPAD_PRO9_32GB_ROSEGOLD
	 */
	public static final String IPAD_PRO9_32GB_ROSEGOLD = "ipad-pro-9-7-inch-32gb-rose-gold";

	/**
	 * OSPREY2
	 */
	public static final String OSPREY2 = "osprey-2";

	/**
	 * SAMSUNG_GALA3_MIDNIGHT_BLACK
	 */
	public static final String SAMSUNG_GALA3_MIDNIGHT_BLACK = "samsung-galaxy-a3-midnight-black-payg";

	/**
	 * FOURGEE_WIFI
	 */
	public static final String FOURGEE_WIFI = "4gee-wifi";

	/**
	 * HUAWEI_T1PRO8
	 */
	public static final String HUAWEI_T1PRO8 = "huawei-t1-pro-8-payg";

	/**
	 * Private constructor
	 */
	private CommonConstants() {
		super();
	}

}
