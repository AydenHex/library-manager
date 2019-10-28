package com.libmanager;

import com.views.WindowManager;
import com.views.WindowManagers;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hé François, met nous 20... stp" );
        //WindowManager manage = new WindowManager();
        WindowManagers manager = new WindowManagers();
        manager.setVisible(true);
        //manage.setVisible(true);
    }
}
