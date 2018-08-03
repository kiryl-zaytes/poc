package uk.ee.framework.site_map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by kiryl_zayets on 5/19/16.
 *
 * Modified by Syamphaneendra Kalluri on 06/29/16.
 */

@Component
public class ShopMap {

	@Value("${shop.url}")
	public String SHOP;

	@Value("${shop.paym.mobile}")
	public String PAYM_PHONES;

	@Value("${shop.payg.mobile}")
	public String PAYG_PHONES;

	@Value("${shop.paym.tablets}")
	public String PAYM_TABLETS;

	@Value("${shop.payg.tablets}")
	public String PAYG_TABLETS;

    @Value("${shop.paym.cameras}")
    public String PAYM_CAMERAS;

    @Value("${shop.payg.cameras}")
    public String PAYG_CAMERAS;

    @Value("${shop.paym.sims}")
    public String PAYM_SIMS;

	@Value("${shop.payg.sims}")
	public String PAYG_SIMS;

	@Value("${shop.sim}")
	public String SIMS;

	@Value("${shop.paym.mbb}")
	public String PAYM_MBB;

	@Value("${shop.payg.mbb}")
	public String PAYG_MBB;

	@Value("${shop.rsa.url}")
	public String RSA_URL;

	@Value("${business.url.mobile}")
	public String SB_PHONES;
	
	@Value("${shop.paym.upgrades}")
	public String PAYM_UPGRADES;

}
