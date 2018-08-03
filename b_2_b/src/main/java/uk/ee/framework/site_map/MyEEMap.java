package uk.ee.framework.site_map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by kiryl_zayets on 4/28/16.
 */

@Component
public class MyEEMap {

    @Value("${myEE.url}")
    public String myEE;

    @Value("${myEE.dashboard}")
    public String DASHBOARD;
    
    @Value("${myEE.bills}")
    public String bills;
    
    @Value("${myEE.topUpHistory}")
    public String topUpHistory;
    
    @Value("${myEE.allowances}")
    public String allowances;
}
