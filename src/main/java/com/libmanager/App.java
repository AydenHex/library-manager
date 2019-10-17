package com.libmanager;

import com.views.WindowManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        WindowManager manage = new WindowManager();
        manage.setVisible(true);
    }
}
