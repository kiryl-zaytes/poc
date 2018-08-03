package uk.ee.framework.site_map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by prabhu_s on 5/16/16.
 */
@Component
public class WebMap {

    @Value("${web.url}")
    public String webUrl;
}
