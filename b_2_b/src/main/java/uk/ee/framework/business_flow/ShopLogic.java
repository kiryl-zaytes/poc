package uk.ee.framework.business_flow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;
import uk.ee.framework.business_objects.dao.billing_details.BillingDetails;
import uk.ee.framework.business_objects.dao.customer.Customer;
import uk.ee.framework.business_objects.dao.order_management.Order;
import uk.ee.framework.business_objects.dao.order_management.constant.SHOP_OPTIONS;
import uk.ee.framework.business_objects.dao.payment_details.PaymentDetails;
import uk.ee.framework.business_objects.dao.rsalogin.RSALoginDAO;
import uk.ee.framework.elements.sections.shop.CustomizeDevice;
import uk.ee.framework.elements.sections.shop.DeviceList;
import uk.ee.framework.elements.sections.shop.DeviceSearch;
import uk.ee.framework.pages.shop.Cart;
import uk.ee.framework.pages.shop.CheckStoreStock;
import uk.ee.framework.pages.shop.Checkout;
import uk.ee.framework.pages.shop.ChooseDelivery;
import uk.ee.framework.pages.shop.ChoosePlan;
import uk.ee.framework.pages.shop.ChooseSIMOPlan;
import uk.ee.framework.pages.shop.ConfirmRetailLoginScreen;
import uk.ee.framework.pages.shop.ConfirmationPage;
import uk.ee.framework.pages.shop.Devices;
import uk.ee.framework.pages.shop.EEUpgrades;
import uk.ee.framework.pages.shop.MBBGallery;
import uk.ee.framework.pages.shop.RetailLogin;
import uk.ee.framework.pages.shop.RetailLoginLinks;
import uk.ee.framework.pages.shop.SBMBBHomeScreen;
import uk.ee.framework.pages.shop.SBTabletsHomeScreen;
import uk.ee.framework.pages.shop.SearchResults;
import uk.ee.framework.pages.shop.ShopLanding;
import uk.ee.framework.pages.shop.SimOnly;
import uk.ee.framework.pages.shop.UpgradeCheckout;
import uk.ee.framework.pages.web.WebHomePage;
import uk.ee.framework.post_processor.Loggable;

/**
 * Created by kiryl_zayets on 5/19/16.
 * 

 */
@Component
@Scope("prototype")
public class ShopLogic {

	@Loggable
	protected Logger logger;
	@Autowired
	ShopLanding shopLanding;
	@Autowired
	Cart cart;
	@Autowired
	SimOnly simOnly;
	@Autowired
	MBBGallery mbbGallery;
	@Autowired
	ChoosePlan choosePlan;
	@Autowired
	ChooseSIMOPlan chooseSIMOPlan;
	@Autowired
	SBMBBHomeScreen sbMBBHomeScreen;
	@Autowired
	SBTabletsHomeScreen sbTabletsHomeScreen;
	@Autowired
	ChooseDelivery chooseDelivery;
	@Autowired
	Checkout checkOut;
	@Autowired
	UpgradeCheckout upgradeCheckout;	
	DeviceList deviceList;	
	DeviceSearch deviceSearch;	
	CustomizeDevice customizeDevice;
	@Autowired
	Devices devices;
	@Autowired
	ConfirmationPage confirmationPage;
	@Autowired
	RetailLogin retailLogin;
	@Autowired
	ConfirmRetailLoginScreen confirnRetailLogin;
	@Autowired
	RetailLoginLinks retailLoginLinks;
	@Autowired
	WebHomePage webHomePage;
	@Autowired
	SearchResults searchresults;
	@Autowired
	CheckStoreStock checkStoreStock;
	@Autowired
	EEUpgrades eeUpgrades;
	

	/**
	 * This method is used to make a MBB order.
	 * @param order
	 * @param planType
	 * @param deliveryAddress
	 * @param postCode
	 * @param customerType
	 * @param customerObj
	 * @param bdObj
	 * @param pdObj
	 */
	public void makeMBBOrder(final Order order, final String planType, final String deliveryAddress,
			final String postCode, final String customerType, final Customer customerObj, final BillingDetails bdObj,
			final PaymentDetails pdObj) {
		webHomePage.launchWeb();
		shopLanding.navigateMBB();
		selectDevice(planType, order);
		choosePlan.chooseMBBPlan(order);
		cart.goToDeliveryOptions();
		chooseDelivery.selectAddress(deliveryAddress, postCode);
		if ("PAYM".equalsIgnoreCase(planType)) {
			checkOut.checkOutNewCustomer(customerType, customerObj, bdObj, pdObj);
		} else {
			checkOut.checkOutPaygCustomer(customerType, customerObj, bdObj, pdObj);
		}
		System.out.println("Order Id: " + confirmationPage.getOrderNumber());
		logger.debug("Exited from ShopLogic.makePaymMBBOrder");
	}

	/**
	 * This method is used to make a SIMO order.
	 * 
	 * @param order
	 * @param planType
	 * @param deliveryAddress
	 * @param postCode
	 * @param customerType
	 * @param customerObj
	 * @param bdObj
	 * @param pdObj
	 */
	public void makeSimOrder(final Order order, final String planType, final String deliveryAddress,
			final String postCode, final String customerType, final Customer customerObj, final BillingDetails bdObj,
			final PaymentDetails pdObj) {
		webHomePage.launchWeb();
		shopLanding.launchSIMO();
		selectDevice(planType, order);
		if ("PAYM".equalsIgnoreCase(planType)) {
			chooseSIMOPlan.choosePaymPhonePlan(order);
		} else {
			chooseSIMOPlan.choosePaygPhonePlan(order);
		}
		cart.goToSecureCheckout();
		if ("PAYM".equalsIgnoreCase(planType)) {
			checkOut.checkOutSIMONewCustomer(customerType, customerObj, bdObj, pdObj);
		} else {
			checkOut.checkOutSIMOPaygCustomer(customerType, customerObj, bdObj, pdObj);
		}
		System.out.println("Order Id: " + confirmationPage.getOrderNumber());
	}

	/**
	 * This method is used to make a Phone order.
	 * 
	 * @param order
	 * @param planType
	 * @param deliveryAddress
	 * @param postCode
	 * @param customerType
	 * @param customerObj
	 * @param bdObj
	 * @param pdObj
	 */
	public void phoneOrder(final Order order, final String planType, final String deliveryAddress,
			final String postCode, final String customerType, final Customer customerObj, final BillingDetails bdObj,
			final PaymentDetails pdObj) {
		webHomePage.launchWeb();
		if ("PAYM".equalsIgnoreCase(planType)) {
			shopLanding.navigatePaymPhones();
		} else {
			shopLanding.navigatePaygPhones();
		}		
		selectDevice(planType, order);
		if ("PAYM".equalsIgnoreCase(planType)) {
			choosePlan.choosePaymPhonePlan(order);
		} else {
			choosePlan.choosePaygPhonePlan(order);
		}
		// cart.addExtras(order.getExtras(),
		// order.getBasketOrder()).goToDeliveryOptions();
		cart.goToDeliveryOptions();
		chooseDelivery.selectAddress(deliveryAddress, postCode);
		if ("PAYM".equalsIgnoreCase(planType)) {
			checkOut.checkOutNewCustomer(customerType, customerObj, bdObj, pdObj);
		} else {
			checkOut.checkOutPaygCustomer(customerType, customerObj, bdObj, pdObj);
		}
		System.out.println("Order Id: " + confirmationPage.getOrderNumber());
		logger.debug("Exited from ShopLogic.phoneOrder");
	}

	/**
	 * This method is used to make a Tablet order.
	 * @param order
	 * @param planType
	 * @param deliveryAddress
	 * @param postCode
	 * @param customerType
	 * @param customerObj
	 * @param bdObj
	 * @param pdObj
	 */
	public void tabletOrder(final Order order, final String planType, final String deliveryAddress,
			final String postCode, final String customerType, final Customer customerObj, final BillingDetails bdObj,
			final PaymentDetails pdObj) {
		webHomePage.launchWeb();
		shopLanding.navigateTablets();
		selectDevice(planType, order);
		choosePlan.choosePaymPlan(order);
		cart.goToDeliveryOptions();
		chooseDelivery.selectAddress(deliveryAddress, postCode);
		if ("PAYM".equalsIgnoreCase(planType)) {
			checkOut.checkOutNewCustomer(customerType, customerObj, bdObj, pdObj);
		} else {
			checkOut.checkOutPaygCustomer(customerType, customerObj, bdObj, pdObj);
		}		
		System.out.println("Order Id: " + confirmationPage.getOrderNumber());
	}

	/**
	 * This method is used to make a RSA order.
	 * 
	 * @param order
	 * @param planType
	 * @param deliveryAddress
	 * @param postCode
	 * @param customerType
	 * @param customerObj
	 * @param bdObj
	 * @param pdObj
	 * @param rsaLogObj
	 */
	public void rsaphoneOrder(final Order order, final String planType, final String deliveryAddress,
			final String postCode, final String customerType, final Customer customerObj, final BillingDetails bdObj,
			final PaymentDetails pdObj, final RSALoginDAO rsaLogObj, final String confirmRetailStr,
			final String scenarioType) {
		shopLanding.launchRSALandingPage();
		retailLogin.login(rsaLogObj);
		confirnRetailLogin.confirmLogin(confirmRetailStr);
		retailLoginLinks.navigateToGallery(scenarioType);
		selectDevice(planType, order);
		if ("PAYMPhones".equalsIgnoreCase(scenarioType)) {
			choosePlan.chooseRSAPaymPhonePlan(order);
		} else if ("PAYGPhones".equalsIgnoreCase(scenarioType)) {
			choosePlan.choosePaygPhonePlan(order);
		}
		cart.goToDeliveryOptions();
		chooseDelivery.selectAddress(deliveryAddress, postCode);
		if ("PAYM".equalsIgnoreCase(planType)) {
			checkOut.checkOutRSANewCustomer(customerType, customerObj, bdObj, pdObj);
		} else {
			checkOut.checkOutRSAPaygCustomer(customerType, customerObj, bdObj, pdObj);
		}
		System.out.println("Order Id: " + confirmationPage.getOrderNumber());
	}

	public void SBphoneOrder(final Order order, final String planType,
			final String postCode, final String customerType, final Customer customerObj, final BillingDetails bdObj,
			final PaymentDetails pdObj) {
		webHomePage.launchWeb();
		shopLanding.navigateSmallBusiness();
		shopLanding.navigateSBPhones();
		selectDevice(planType, order);
		choosePlan.selectPlan(planType, order);
		cart.goToSBDeliveryOptions();
//		chooseDelivery.selectAddress(deliveryAddress, postCode);
		checkOut.checkOutSBNewCustomer(postCode, customerType, customerObj, bdObj, pdObj);
		System.out.println("Order Id: " + confirmationPage.getOrderNumber());
	}
	
	public void makeSBTabletOrder(final Order order, final String planType,
			final String postCode, final String customerType, final Customer customerObj, final BillingDetails bdObj,
			final PaymentDetails pdObj, final String typeOfBusiness) {
		webHomePage.launchWeb();
		shopLanding.navigateSmallBusiness();
		shopLanding.navigateSBTablets();
		sbTabletsHomeScreen.selectTablets();
		selectDevice(planType, order);
		choosePlan.selectPlan(planType, order);
		cart.goToSBDeliveryOptions();
		checkOut.checkOutSB(postCode, customerType, customerObj, bdObj, pdObj);
		System.out.println("Order Id: " + confirmationPage.getOrderNumber());
	}

	public void makeSBSimOrder(final Order order, final String planType,
			final String postCode, final String customerType, final Customer customerObj, final BillingDetails bdObj,
			final PaymentDetails pdObj, final String typeOfBusiness) {	
		webHomePage.launchWeb();
		shopLanding.navigateSmallBusiness();
		shopLanding.navigateSBSIMO();
		simOnly.selectSBSIMO();
		chooseSIMOPlan.chooseSBSIMOPlan();
		cart.goToSBSimSecureCheckout(typeOfBusiness);
		checkOut.checkOutSBSIMONewCustomer(postCode, customerType, customerObj, bdObj, pdObj);
		System.out.println("Order Id: " + confirmationPage.getOrderNumber());
	}

	public void makeSBMBBOrder(final Order order, final String planType,
			final String postCode, final String customerType, final Customer customerObj, final BillingDetails bdObj,

			final PaymentDetails pdObj, final String typeOfBusiness) {
		webHomePage.launchWeb();
		shopLanding.navigateSmallBusiness();
		shopLanding.navigateSBMBB();
		sbMBBHomeScreen.selectWiFiDevices();
		selectDevice(planType, order);
		choosePlan.selectPlan(planType, order);
		cart.goToSBSimSecureCheckout(typeOfBusiness);
		checkOut.checkOutSB(postCode, customerType, customerObj, bdObj, pdObj);
		System.out.println("Order Id: " + confirmationPage.getOrderNumber());
	}
	
	public void webSearchResults(String str){
		webHomePage.launchWeb();
		webHomePage.webSearch(str);
		searchresults.webSearchResult();
	}
	
	public void shopSearchResults(String str){
		webHomePage.launchWeb();
		webHomePage.webToShop();
		shopLanding.shopSearch(str);
		searchresults.webSearchResult();
	}
	
	public void navigateToSmallBusiness(){
		shopLanding.launchShopLandingPage();
		shopLanding.navigateSmallBusiness();
	}
	
	public void navigateToLargeBusiness(){
		shopLanding.launchShopLandingPage();
		shopLanding.navigateLargeBusiness();
	}
	
	
	/**
	 * This method is used to select the device based on order options and plan
	 * type(like payg or paym)
	 * 
	 * @param planType
	 * @param order
	 */
	public void selectDevice(String planType, Order order) {
		logger.debug("Entered into ShopLogic.selectDevice");
		switch (order.getOptions()) {
		case SIM:
			simOnly.selectPlan(order.getCapacity(), order.getTermOfUsage(), order.getAccount(), order.getCalls());
			break;
		case PLAN:
			break; // TODO: add functionality
		case MBB:			
			if ("SB".equalsIgnoreCase(planType)) {
				mbbGallery.selectDevice(order.getName());
				break;
			} else {
				if ("PAYM".equalsIgnoreCase(planType)) {
					mbbGallery.selectPaymPlan();
				} else {
					mbbGallery.selectPaygPlan();
				}
				mbbGallery.selectDevice(order.getName());
				break;
			}
		case PHONE:
			if ("SB".equalsIgnoreCase(planType)) {
				mbbGallery.selectDevice(order.getName());
				break;
			} else {
				if ("PAYM".equalsIgnoreCase(planType)) {
					mbbGallery.selectPayType(planType, SHOP_OPTIONS.PHONE);
				} else {
					mbbGallery.selectPayType(planType, SHOP_OPTIONS.PHONE);
				}
				mbbGallery.selectDevice(order.getName());
				break;
			}
		case PHONEUPGRADE:			
			mbbGallery.selectDevice(order.getName());
			break;
		case TABLET:
			if ("PAYM".equalsIgnoreCase(planType)) {
				mbbGallery.selectPayType(planType, SHOP_OPTIONS.TABLET);
			} else {
				mbbGallery.selectPayType(planType, SHOP_OPTIONS.TABLET);
			}
			mbbGallery.selectDevice(order.getName());
			break;
		case SB:			
			mbbGallery.selectDevice(order.getName());
			break;
		default:
			mbbGallery.selectDevice(order.getName());
		}
		logger.debug("Exited from ShopLogic.selectDevice");
	}

	/**
	 * This method is used to upgrade a Paym Phone.
	 * 
	 * @param order
	 * @param planType
	 * @param deliveryAddress
	 * @param postCode
	 * @param customerType
	 * @param customerObj
	 * @param bdObj
	 * @param pdObj
	 */
	public void phoneUpgradation(final Order order, final String planType, final String deliveryAddress,
			final String postCode, final String customerType, final Customer customerObj, final BillingDetails bdObj,
			final PaymentDetails pdObj) {
//		webHomePage.launchWeb();
//		webHomePage.webToShop();
		shopLanding.launchShopPaymUpgrade();
		selectDevice(planType, order);
		choosePlan.chooseUpgradePhonePlan(order);
		upgradeCheckout.upgradePaymPhones(customerType, customerObj, bdObj, pdObj);
		System.out.println("Order Id: " + confirmationPage.getOrderNumber());
	}

	public void PersonalToBusiness() {
		webHomePage.launchWeb();
		shopLanding.navigateSmallBusiness();
	}

	public void rsaStockCheckervalidation(String deviceType, RSALoginDAO rsaLogObj, String confirmRetailStr) {
		shopLanding.launchRSALandingPage();
		retailLogin.login(rsaLogObj);
		confirnRetailLogin.confirmLogin(confirmRetailStr);
		retailLoginLinks.navigateToStockCheck(deviceType);		
		devices.selectDeviceStockCheck();		
		checkStoreStock.stockLevels();
	}
	
	public void rsaPhoneUpgradation(final Order order, final String planType, final String deliveryAddress,
			final String postCode, final String customerType, final Customer customerObj, final BillingDetails bdObj,
			final PaymentDetails pdObj, final RSALoginDAO rsaLogObj, final String confirmRetailStr,
			final String scenarioType) {
		shopLanding.launchRSALandingPage();
		retailLogin.login(rsaLogObj);
		confirnRetailLogin.confirmLogin(confirmRetailStr);
		retailLoginLinks.navigateToEEUpgrades();
		eeUpgrades.upgradePhones();
		selectDevice(planType, order);
		choosePlan.chooseUpgradePhonePlan(order);
		upgradeCheckout.upgradePaymPhones(customerType, customerObj, bdObj, pdObj);
		System.out.println("Order Id: " + confirmationPage.getOrderNumber());
	}
	
}
