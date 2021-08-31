/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author julio
 */
public class Session {
    
    private Map<String, Object> _map = new Hashtable<String, Object>();
    
    private static Session _session = new Session();
    
    public static Session getSession(){
        return _session;
    }
    
    public void setAttribute(String key, Object value){
        _map.put(key, value);
    }
    
    public Object getAttribute(String key){
        return _map.get(key);
    }

    
}
