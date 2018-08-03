package com.poc.pubcentral.common.driver.bpp;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kiryl_zayets on 6/29/15.
 */
public class TestScope implements Scope {

    CustomThreadLocal customThreadLocal = new CustomThreadLocal();
    private Map<String, Object> cache = new HashMap<>();

    //    @Override
//    public Object get(String s, ObjectFactory<?> objectFactory) {
//        if(!cache.containsKey(s)){
//            Object g = objectFactory.getObject();
//            cache.put(s,g);
//        }
//
//        return cache.get(s);
//    }
    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        Map<String, Object> scope = (Map<String, Object>) customThreadLocal
                .get();
        Object object = scope.get(s);
        if (object == null) {
            object = objectFactory.getObject();
            scope.put(s, object);
        }
        return object;
    }

//    public void reset(){
//        cache.clear();
//    }

    @Override
    public Object remove(String s) {
        Map<String, Object> scope = (Map<String, Object>) customThreadLocal
                .get();
        return scope.remove(s);
    }

//    @Override
//    public Object remove(String s) {
//        return cache.remove(s);
//    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }

    class CustomThreadLocal extends ThreadLocal {
        protected Map<String, Object> initialValue() {
            System.out.println("initialize ThreadLocal");
            return new HashMap<String, Object>();
        }
    }
}
